package com.example.tvx4

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.leanback.widget.BrowseFrameLayout
import com.example.tvx4.utils.Constants

class MainActivity : FragmentActivity(), View.OnKeyListener, ChannelData {

    lateinit var navBar: BrowseFrameLayout
    lateinit var fragmentContainer: FrameLayout
    lateinit var btnHome: TextView
    lateinit var btnPlay: TextView
    var SIDE_MENU = false
    var selectedMenu = Constants.MENU_HOME
    var channelUrl= Array<String>(4) { "https://arlocallive.lcdn.clarotv.com.ar" +
            "/Content/HLS_HLS_FK/Live/channel(A24)/index.m3u8" }
    lateinit var lastSelectedMenu: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainer = findViewById(R.id.container)
        navBar = findViewById(R.id.blfNavBar)
        btnPlay = findViewById(R.id.btn_player)
        btnHome = findViewById(R.id.btn_home)

        btnHome.setOnKeyListener(this)
        btnPlay.setOnKeyListener(this)

        lastSelectedMenu = btnHome
        lastSelectedMenu.isActivated = true
        changeFragment(HomeFragment())
    }

    fun changeFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
        closeMenu()
    }


    override fun onKey(view: View?, i: Int, key_event: KeyEvent?): Boolean {
        when (i) {
            KeyEvent.KEYCODE_DPAD_CENTER -> {
                lastSelectedMenu.isActivated = false
                view?.isActivated = true
                lastSelectedMenu = view!!
                when (view.id) {
                    R.id.btn_player -> {
                        selectedMenu = Constants.MENU_PLAY
                        val intent = Intent(this, PlayerActivity::class.java)
                        intent.putExtra("url", channelUrl)
                        startActivity(intent)
                    }
                    R.id.btn_home -> {
                        selectedMenu = Constants.MENU_HOME
                        changeFragment(HomeFragment())
                    }
                }
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                if (!SIDE_MENU) {
                    switchToLastSelectedMenu()
                    openMenu()
                    SIDE_MENU = true
                }
            }
        }
        return false
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT && SIDE_MENU){
            SIDE_MENU = false
            closeMenu()
        }
        return super.onKeyDown(keyCode, event)
    }


    override fun onBackPressed() {
        if (!SIDE_MENU) {
            SIDE_MENU = true
            openMenu()
        } else {
            super.onBackPressed()
        }
    }


    fun switchToLastSelectedMenu() {
        when (selectedMenu) {
            Constants.MENU_PLAY -> {
                btnPlay.requestFocus()
            }
            Constants.MENU_HOME -> {
                btnHome.requestFocus()
            }
        }
    }


    fun openMenu(){
        navBar.requestLayout()
        navBar.layoutParams.width = (this.resources.displayMetrics.widthPixels ?: 0) * 16 /100
        lastSelectedMenu.isActivated = false
    }

    fun closeMenu(){
        navBar.requestLayout()
        navBar.layoutParams.width = (this.resources.displayMetrics.widthPixels ?: 0) * 6 /100
        fragmentContainer.requestFocus()
        SIDE_MENU = false
    }

    override fun setUrl(array: Array<String>) {
        channelUrl = array
    }

}