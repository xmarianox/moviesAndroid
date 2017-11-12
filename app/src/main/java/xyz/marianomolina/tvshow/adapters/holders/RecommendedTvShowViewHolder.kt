package xyz.marianomolina.tvshow.adapters.holders

import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import info.movito.themoviedbapi.model.tv.TvSeries
import kotlinx.android.synthetic.main.recommended_row.view.*
import xyz.marianomolina.tvshow.R

/**
 * Created by Mariano Molina on 11/11/17.
 * Twitter: @xsincrueldadx
 */
class RecommendedTvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var image = view.recommended_image
    private var show_name = view.recommended_name
    private var label_badge = view.recommended_label_background
    private var label = view.recommended_label

    private var gd = GradientDrawable()

    fun bindRecommendedTvShow(serie: TvSeries) {
        image.contentDescription = serie.originalName
        val uri = Uri.parse("https://image.tmdb.org/t/p/w500${serie.backdropPath}")
        image.setImageURI(uri)

        show_name.setText(serie.originalName)

        // set corner radius
        gd.setColor(ContextCompat.getColor(itemView.context, R.color.colorLabelTag))
        gd.cornerRadius = 6.0f
        label_badge.background = gd
        // label.setText(serie.)

    }

}