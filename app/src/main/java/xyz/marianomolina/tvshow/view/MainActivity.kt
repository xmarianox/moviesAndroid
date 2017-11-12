package xyz.marianomolina.tvshow.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.find
import xyz.marianomolina.tvshow.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        val toolbar = find<android.support.v7.widget.Toolbar>(R.id.toolbar)
        val container = find<CoordinatorLayout>(R.id.container)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
//        toolbar.setTitle(R.string.app_name)
//        toolbar.setTitleTextColor(Color.WHITE)
    }


}
