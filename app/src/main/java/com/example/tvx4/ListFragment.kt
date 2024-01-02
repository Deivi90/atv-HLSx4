package com.example.tvx4

import android.os.Bundle
import android.view.View
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.*
import com.example.tvx4.data.EpgResponse

// Listado de canales
class ListFragment : RowsSupportFragment() {

    private var itemSelectedListener: ((EpgResponse.Channel) -> Unit)? = null
    private var itemClickListener: ((EpgResponse.Channel) -> Unit)? = null
    private var rootAdapter: ArrayObjectAdapter =
        ArrayObjectAdapter(ListRowPresenter(FocusHighlight.ZOOM_FACTOR_MEDIUM))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = rootAdapter

        onItemViewSelectedListener = ItemViewSelectedListener()
        onItemViewClickedListener = ItemViewClickListener()

    }

    fun bindData(dataList: EpgResponse) {
        val arrayObjectAdapter = ArrayObjectAdapter(ItemPresenter())
        dataList.channels.forEach {
            arrayObjectAdapter.add(it)
        }
        val headerItem = HeaderItem("Buenos Aires")
        val listRow = ListRow(headerItem, arrayObjectAdapter)
        rootAdapter.add(listRow)
    }


    fun setOnContentSelectedListener(listener : (EpgResponse.Channel) -> Unit){
        this.itemSelectedListener = listener
    }


    fun setOnItemClickListener(listener: (EpgResponse.Channel) -> Unit) {
        this.itemClickListener = listener
    }


    inner class ItemViewSelectedListener : OnItemViewSelectedListener{
        override fun onItemSelected(
            itemViewHolder: Presenter.ViewHolder?,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder?,
            row: Row?
        ) {
            if (item is EpgResponse.Channel){
                itemSelectedListener?.invoke(item)
            }

        }

    }

    inner class ItemViewClickListener : OnItemViewClickedListener{
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder?,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder?,
            row: Row?
        ) {
            if (item is EpgResponse.Channel){
                itemClickListener?.invoke(item)
            }
        }
    }
}


