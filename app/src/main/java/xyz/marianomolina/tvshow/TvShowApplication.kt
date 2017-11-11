package xyz.marianomolina.tvshow

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by Mariano Molina on 8/11/17.
 * Twitter: @xsincrueldadx
 */
class TvShowApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

}