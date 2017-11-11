package xyz.marianomolina.tvshow.adapters.holders

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import info.movito.themoviedbapi.model.tv.TvSeries
import kotlinx.android.synthetic.main.follow_series_row.view.*

/**
 * Created by Mariano Molina on 8/11/17.
 * Twitter: @xsincrueldadx
 */
class FollowingSeriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var cardview = view.follow_series_row
    private var image = view.follow_series_row_image

    fun bindFollowingSerie(serie: TvSeries) {
        image.contentDescription = serie.originalName

        val uri = Uri.parse("https://image.tmdb.org/t/p/w185${serie.posterPath}")

        image.setImageURI(uri)

        // item
        Log.d("Row", "Name: ${serie.originalName}")

    }

}