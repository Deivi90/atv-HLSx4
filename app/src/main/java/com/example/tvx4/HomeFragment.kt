package com.example.tvx4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.tvx4.data.EpgResponse
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

//Pantalla de Inicio
class HomeFragment : Fragment() {

    lateinit var txtTitle: TextView
    lateinit var txtSubTitle: TextView
    lateinit var txtDescription: TextView
    lateinit var imgBanner: ImageView
    lateinit var listFragment: ListFragment
    lateinit var toast : Toast
    var channelIndex: Int = 0
    private var channelUrl = Array<String>(4) { "https://arlocallive.lcdn.clarotv.com.ar" +
            "/Content/HLS_HLS_FK/Live/channel(A24)/index.m3u8" }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    fun init(view: View) {
        val channelData : ChannelData = activity as ChannelData
        imgBanner = view.findViewById(R.id.img_banner)
        txtTitle = view.findViewById(R.id.title)
        txtSubTitle = view.findViewById(R.id.subtitle)
        txtDescription = view.findViewById(R.id.description)
        listFragment = ListFragment()

        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.list_fragment, listFragment)
        transaction.commit()

        val gson = Gson()
        val i: InputStream = requireContext().assets.open("epg.json")
        val br = BufferedReader(InputStreamReader(i))
        val dataList: EpgResponse = gson.fromJson(br, EpgResponse::class.java)

        listFragment.bindData(dataList)
        listFragment.setOnContentSelectedListener {
            updateBanner(it)
        }
        listFragment.setOnItemClickListener () {
            val text = "Pantalla " + (channelIndex + 1) + ": " + it.name
            toast = Toast.makeText(requireContext(), text, Toast.LENGTH_LONG)
            toast.show()
            channelUrl[channelIndex] = it.group.common.extendedcommon.media
                .language.options.option[0].fastPlay.ipMulticastLms
            channelIndex = (channelIndex + 1) % 4
        }
        channelData.setUrl(channelUrl)
    }


    fun updateBanner(dataList: EpgResponse.Channel) {
        txtTitle.text = "${dataList.number}. ${dataList.name}"
        txtDescription.text = dataList.group.common.extendedcommon.media
            .language.options.option[0].fastPlay.ipMulticastLms
        val url = dataList.group.common.imageLarge
        Glide.with(this).load(url).into(imgBanner)
    }
}