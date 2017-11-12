package xyz.marianomolina.tvshow.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.movito.themoviedbapi.TmdbApi
import info.movito.themoviedbapi.model.tv.TvSeries
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

import xyz.marianomolina.tvshow.R
import xyz.marianomolina.tvshow.adapters.RecommendedTvShowAdapter


/**
 * A simple [Fragment] subclass.
 */
class RecommendedTvShowFragment : Fragment() {

    private lateinit var recommended_recycler: RecyclerView
    private lateinit var recommended_adapter: RecommendedTvShowAdapter


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_recommended_tv_show, container, false)

        with(view) {
            recommended_recycler = findViewById(R.id.recommended_recycler)
        }

        setUpRecyclerView()

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doAsync {
            val api = TmdbApi("390cd641838e2bd6e13ac3628a6be5f8")
            val series = api.tvSeries.getPopular("en", 1)
            //val series = api.tvSeries.getSeries(67744, "en").recommendations

            uiThread { setUpTvShowList(series.results) }
        }
    }

    private fun setUpRecyclerView() {
        with(recommended_recycler) {
            setRecyclerViewLayoutManager(this)
            setHasFixedSize(true)
        }
    }

    private fun setUpAdapter() {
        recommended_adapter = RecommendedTvShowAdapter()
        recommended_recycler.adapter = recommended_adapter
    }

    private fun setUpTvShowList(shows: List<TvSeries>) {
        setUpAdapter()
        recommended_adapter.loadRecommendedSeries(shows)
    }

    private fun setRecyclerViewLayoutManager(recyclerView: RecyclerView) {
        var scrollPosition = 0

        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.layoutManager != null) {
            scrollPosition = (recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        }

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val defaultItemAnimator = DefaultItemAnimator()

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.itemAnimator = defaultItemAnimator
        recyclerView.isNestedScrollingEnabled = false

        recyclerView.scrollToPosition(scrollPosition)
    }

}
