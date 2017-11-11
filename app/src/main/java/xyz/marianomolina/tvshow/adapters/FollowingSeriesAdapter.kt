package xyz.marianomolina.tvshow.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import info.movito.themoviedbapi.model.tv.TvSeries
import xyz.marianomolina.tvshow.R
import xyz.marianomolina.tvshow.adapters.holders.FollowingSeriesViewHolder

/**
 * Created by Mariano Molina on 8/11/17.
 * Twitter: @xsincrueldadx
 */
class FollowingSeriesAdapter: RecyclerView.Adapter<FollowingSeriesViewHolder>() {

    private var mDataset: List<TvSeries> = ArrayList()

    override fun onBindViewHolder(holder: FollowingSeriesViewHolder, position: Int) {
        with(mDataset[position]) {
            holder.bindFollowingSerie(this)
        }
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingSeriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.follow_series_row, parent, false)
        return FollowingSeriesViewHolder(view)
    }

    fun loadFollowingSeries(series: List<TvSeries>) {
        this.mDataset = series
        notifyDataSetChanged()
    }

}