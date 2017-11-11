package xyz.marianomolina.tvshow.fragments


import android.annotation.SuppressLint
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
import xyz.marianomolina.tvshow.adapters.FollowingSeriesAdapter


/**
 * A simple [Fragment] subclass.
 */
class FollowingShowListFragment : Fragment() {

    private val TAG: String = FollowingShowListFragment::class.java.simpleName
    private lateinit var series_recycler: RecyclerView
    private lateinit var followingSeriesAdapter: FollowingSeriesAdapter


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_following_show_list, container, false)

        with(view) {
            series_recycler = findViewById(R.id.series_follow_recycler)
        }

        setUpRecyclerView()

        return view
    }

    @SuppressLint("LongLogTag")
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doAsync {
            val api = TmdbApi("390cd641838e2bd6e13ac3628a6be5f8")
            val series = api.tvSeries.getTopRated("en", 1)

            // set series in main thread
            uiThread { setUpTvSeries(series.results) }
        }
    }

    private fun setRecyclerViewLayoutManager(recyclerView: RecyclerView) {
        var scrollPosition = 0

        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.layoutManager != null) {
            scrollPosition = (recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        }

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val defaultItemAnimator = DefaultItemAnimator()

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.itemAnimator = defaultItemAnimator

        recyclerView.scrollToPosition(scrollPosition)
    }


    private fun setUpRecyclerView() {
        with(series_recycler) {
            setRecyclerViewLayoutManager(this)
            setHasFixedSize(true)
        }
    }

    private fun setUpAdapter() {
        followingSeriesAdapter = FollowingSeriesAdapter()
        series_recycler.adapter = followingSeriesAdapter
    }

    private fun setUpTvSeries(series: List<TvSeries>) {
        setUpAdapter()
        followingSeriesAdapter.loadFollowingSeries(series)
    }


}
