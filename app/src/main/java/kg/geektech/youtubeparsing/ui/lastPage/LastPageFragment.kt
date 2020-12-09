package kg.geektech.youtubeparsing.ui.lastPage

import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.gesture.GestureOverlayView.ORIENTATION_HORIZONTAL
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.exoplayer2.SimpleExoPlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kg.geektech.youtubeparsing.R
import kg.geektech.youtubeparsing.data.models.Item
import kg.geektech.youtubeparsing.databinding.LastPageFragmentBinding
import kg.geektech.youtubeparsing.extensions.layoutParam
import kg.geektech.youtubeparsing.ui.detailedPlaylist.KEY
import kotlinx.android.synthetic.main.last_page_fragment.*
import org.koin.android.ext.android.inject


const val KEY_TO_BOTTOM = "hdsvfsdhfgsdfgsdhfksa"

class LastPageFragment : Fragment(R.layout.last_page_fragment) {
    private var arrayOfList: MutableList<Item> = mutableListOf()
    private val viewModel by inject<LastPageViewModel>()
    private var fragmentBinding: LastPageFragmentBinding? = null
    private val binding: LastPageFragmentBinding get() = fragmentBinding!!
    private var list: Item? = null
    private var uri: String? = null
    private var videoPlayer: SimpleExoPlayer? = null

    // private var sampleUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
    private var url: String? = null
    private var videoId: String? = null
    var youTubePlayerView: YouTubePlayerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null)
            let {
                list = arguments?.getSerializable(KEY) as Item
            }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = LastPageFragmentBinding.bind(view)
        fragmentBinding = binding
        fragmentBinding.apply {
            youTubePlayerView = youtube_player_view
        }
        // setExoPlayer()
        fillUpDetail()
        setVideo()
    }

    fun fillUpDetail() {
        binding.lastPageTitle.text = list?.snippet?.title
        binding.lastPageDescription.text = list?.snippet?.description
    }

    fun setVideo() {
        youTubePlayerView?.let {
            lifecycle.addObserver(it)
        }
        youTubePlayerView?.enterFullScreen()
        youTubePlayerView?.isFullScreen()
        youTubePlayerView!!.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                videoId = list?.contentDetails?.videoId
                videoId?.let { youTubePlayer.loadVideo(it, 0f) }
            }
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation==ORIENTATION_LANDSCAPE){
            binding.youtubePlayerView?.layoutParam{
                width=ViewGroup.LayoutParams.MATCH_PARENT
                height=ViewGroup.LayoutParams.WRAP_CONTENT
            }
        }
        if (newConfig.orientation== ORIENTATION_HORIZONTAL){
            binding.youtubePlayerView?.layoutParam{
                width=ViewGroup.LayoutParams.MATCH_PARENT
                height=ViewGroup.LayoutParams.MATCH_PARENT
            }

        }
    }


    fun moveToBottomSheet(item: Item) {
        binding.playlistTpBottomSheet.setOnClickListener {
            list = item
            var bundle = Bundle()
            bundle.putSerializable(KEY_TO_BOTTOM, list)
            findNavController().navigate(R.id.action_to_bottom_sheet, bundle)
        }
    }


//    fun buildMediaSource(): MediaSource? {
////          url = "https://www.youtube.com/watch?v=${list?.contentDetails!!.videoId}"
////           url = "https://www.youtube.com/watch?v=${list?.contentDetails?.videoId}"
//            val dataSourceFactory = DefaultDataSourceFactory(requireActivity(), "sample")
//            return ProgressiveMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(Uri.parse(url))
//    }
//
//    fun setExoPlayer() {
//        videoPlayer = SimpleExoPlayer.Builder(requireActivity()).build()
//        binding.player?.player = videoPlayer
//        buildMediaSource()?.let {
//            videoPlayer?.prepare(it)
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//      //  videoPlayer?.playWhenReady = true
//    }
//
//    override fun onStop() {
//        super.onStop()
    //   var isFinishing: Boolean = false
    //    videoPlayer?.playWhenReady = false
    //   if (isFinishing) {
    // releasePlayer()
}
//  }

// private fun releasePlayer() {
//   videoPlayer?.release()
//  }}

