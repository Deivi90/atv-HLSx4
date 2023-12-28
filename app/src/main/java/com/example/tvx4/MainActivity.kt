package com.example.tvx4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.leanback.widget.BrowseFrameLayout

class MainActivity : FragmentActivity(), View.OnKeyListener {

    lateinit var navBar: BrowseFrameLayout
    lateinit var fragmentContainer: FrameLayout

    lateinit var btnHome: TextView
    lateinit var btnPlay: TextView
    var SIDE_MENU = false
    var selectedMenu = "search"

    lateinit var lastSelectedMenu: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainer = findViewById(R.id.container)
        navBar = findViewById(R.id.blfNavBar)
        btnPlay = findViewById(R.id.btn_search)
        btnHome = findViewById(R.id.btn_home)

        btnHome.setOnKeyListener(this)
        btnPlay.setOnKeyListener(this)

        lastSelectedMenu = btnPlay
        //lastSelectedMenu.isActivated = true
        changeFragment(SearchFragment())
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

                when (view?.id) {
                    R.id.btn_search -> {
                        selectedMenu = "search"
                        changeFragment(PlayerActivity(this))
                    }

                    R.id.btn_home -> {
                        selectedMenu = "home"
                        changeFragment(SearchFragment())
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
        if (SIDE_MENU) {
            SIDE_MENU = false
            closeMenu()
        } else {
            super.onBackPressed()
        }
    }


    fun switchToLastSelectedMenu() {
        when (selectedMenu) {
            "search" -> {
                btnPlay.requestFocus()
            }
            "home" -> {
                btnHome.requestFocus()
            }
        }
    }


    fun openMenu(){
        navBar.requestLayout()
        navBar.layoutParams.width = (this.resources.displayMetrics.widthPixels ?: 0) * 16 /100
    }

    fun closeMenu(){
        navBar.requestLayout()
        navBar.layoutParams.width = (this.resources.displayMetrics.widthPixels ?: 0) * 3 /100

        fragmentContainer.requestFocus()
        SIDE_MENU = false
    }


}