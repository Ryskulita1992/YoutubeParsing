package kg.geektech.youtubeparsing.ui.simplePlaylist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.youtubeparsing.R
import kg.geektech.youtubeparsing.data.models.Item
import kg.geektech.youtubeparsing.databinding.SimplePlaylistFragmentBinding
import kg.geektech.youtubeparsing.extensions.toastText
import kg.geektech.youtubeparsing.ui.simplePlaylist.rv.MainAdapter
import org.koin.android.ext.android.inject
import java.util.*

const val INT = "amount"

class SimplePlaylistFragment : Fragment(R.layout.simple_playlist_fragment) {

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    private lateinit var adapter: MainAdapter
    private var arrayOfList: MutableList<Item> = mutableListOf()

    private val viewModel by inject<SimplePlaylistViewModel>()
    private var fragmentBinding: SimplePlaylistFragmentBinding? = null
    private val binding: SimplePlaylistFragmentBinding get() = fragmentBinding!!


    companion object {
        fun newInstance() = SimplePlaylistFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = SimplePlaylistFragmentBinding.inflate(inflater)
        return binding.root
        Log.e("TAG", "onCreateView: ")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = SimplePlaylistFragmentBinding.bind(view)
        fragmentBinding = binding
        Log.e("TAG", "onViewCreated: ")
        setAdapter()
        fetchPlaylist()
        subscribeToPlaylists()
        subscribeErrorMessage()
    }

    //    fun setUpAdapter(){
//        adapter = MainAdapter(arrayOfList, this::onItemClick)
//        binding.recyclerSimple.apply {
//            adapter = this@SimplePlaylistFragment.adapter
//        }
//    }
    fun setAdapter() {
        Log.e("TAG", "setAdapter: ")
        fragmentBinding!!.recyclerSimple.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        adapter = MainAdapter(arrayOfList, this::onItemClick)
        fragmentBinding!!.recyclerSimple.apply {
            adapter = this@SimplePlaylistFragment.adapter
        }
    }

    private fun subscribeErrorMessage() {
        viewModel.errorMessage.observeForever {
            toastText(requireContext(), "Error message")
        }
    }

    private fun subscribeToPlaylists() {
        setAdapter()
        viewModel.playlist.observeForever {
            arrayOfList.addAll(it)
            adapter.addItems(it)
        }

    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        fragmentBinding = null
        super.onDestroyView()
    }

    fun fetchPlaylist() {
        viewModel.fetchPlaylist()
    }


    fun onItemClick(item: Item) {
        // viewModel.playlist.value[adapter.]
        val result = Bundle()
        result.putSerializable(INT, item)
//        val action = SimplePlaylistFragmentDirections.actionMainFragmentToDetailedFragment()
//        findNavController()?.navi gateUp()
        findNavController().navigate(R.id.action_mainFragment_to_detailedFragment, result)
        Log.e("TAG", "onItemClick: $result ")


//            playList?.let {
//                val amount=10
//
//                val action = SimplePlaylistFragmentDirections.actionMainFragmentToDetailedFragment(amount)
//                val bundle:Bundle
//                findNavController().navigate(action)
//
//
//
//            }
    }
}



