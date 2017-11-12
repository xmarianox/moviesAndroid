package xyz.marianomolina.tvshow.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import info.movito.themoviedbapi.model.tv.TvSeries
import xyz.marianomolina.tvshow.R
import xyz.marianomolina.tvshow.adapters.holders.RecommendedTvShowViewHolder

/**
 * Created by Mariano Molina on 11/11/17.
 * Twitter: @xsincrueldadx
 */
class RecommendedTvShowAdapter: RecyclerView.Adapter<RecommendedTvShowViewHolder>() {

    private var mDataset: List<TvSeries> = ArrayList()

    override fun onBindViewHolder(holder: RecommendedTvShowViewHolder, position: Int) {
        with(mDataset[position]) {
            holder.bindRecommendedTvShow(this)
        }
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedTvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommended_row, parent, false)
        return RecommendedTvShowViewHolder(view)
    }

    fun loadRecommendedSeries(series: List<TvSeries>) {
        this.mDataset = series
        notifyDataSetChanged()
    }

}