package kg.geektech.youtubeparsing.ui.detailedPlaylist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.youtubeparsing.R
import kg.geektech.youtubeparsing.data.models.Item
import kg.geektech.youtubeparsing.databinding.DetailedPlaylistFragmentBinding
import kg.geektech.youtubeparsing.ui.detailedPlaylist.rv.DetailedAdapter
import kg.geektech.youtubeparsing.ui.simplePlaylist.INT
import org.koin.android.ext.android.inject

const val KEY = "detailedId"
class DetailedPlaylistFragment : Fragment(R.layout.detailed_playlist_fragment) {

    private lateinit var adapter: DetailedAdapter
    private var arrayOfList: MutableList<Item> = mutableListOf()
    private val viewModel by inject<DetailedPlaylistViewModel>()
    private var fragmentBinding: DetailedPlaylistFragmentBinding? = null
    private val binding: DetailedPlaylistFragmentBinding get() = fragmentBinding!!
    private var list: Item? = null
    private var description: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null)
            let {
                list = arguments?.getSerializable(INT) as Item
                viewModel.fetchPlaylistVideo(list?.id)
                Log.e("TAG", "onCreate:  id ${list?.contentDetails?.videoId} ")
//                arrayOfList.addAll(list)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DetailedPlaylistFragmentBinding.bind(view)
        fragmentBinding = binding
        getPlaylists()
        setTitle()

    }
    override fun onResume() {
        super.onResume()
        list = arguments?.getSerializable(INT) as Item
        viewModel.fetchPlaylistVideo(list?.id)
    }

    fun setAdapter() {
        Log.e("TAG", "setAdapter: ")
        fragmentBinding!!.recyclerDetailed.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        adapter = DetailedAdapter(arrayOfList, this::onItemClick)
        fragmentBinding!!.recyclerDetailed.apply {
            adapter = this@DetailedPlaylistFragment.adapter
        }
    }

    fun getPlaylists() {
        viewModel.detailPlaylists.observeForever {
            Log.d("ololo", "$it")
            arrayOfList.addAll(it)
            setAdapter()
        }
    }

    fun setTitle() {
        let {
            binding.detailsTitleTV.text = list?.snippet?.title
            description = list?.snippet?.description
            Log.e("TAG", "getPlaylists: ${description.toString()} ")
        }
    }

    fun onItemClick(detailedList: Item) {
        var detailedList = detailedList
        //var id=detailedList?.contentDetails?.videoId?.get(index = getId())
        Log.e("TAG", "onItemClick: $id")
//        var playlist = item
        val result = Bundle()

        Log.e("TAG", "onItemClick: VIDEO ID:${detailedList.contentDetails?.videoId}")
        result.putSerializable(KEY, detailedList)
        //result.putSerializable(KEY, playlist)
        findNavController().navigate(R.id.actionFromPlaylistToLAst, result)


    }


//    companion object {
//        var playlist: Item? = null
//        fun instanceFragment(fragment: Fragment, playlist: Item) {
//            Log.e("TAG", "instanceFragment: $playlist ")
//            val navController = fragment.findNavController()
//            this.playlist = playlist
//            var amount=9
//            navController?.navigateUp()
//            val action = DetailedPlaylistFragmentDirections.actionPlaylistFragmentToLastPageFragment()
//            navController.navigate(R.id.action_mainFragment_to_detailedFragment, action)
//            Log.e("TAG", "instanceFragment:$action ")
//        }
//    }


}