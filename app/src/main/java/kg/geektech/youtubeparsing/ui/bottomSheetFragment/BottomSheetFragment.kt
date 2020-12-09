package kg.geektech.youtubeparsing.ui.bottomSheetFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kg.geektech.youtubeparsing.R
import kg.geektech.youtubeparsing.data.models.Item
import kg.geektech.youtubeparsing.ui.bottomSheetFragment.rv.BottomSheetAdapter
import kg.geektech.youtubeparsing.ui.detailedPlaylist.rv.DetailedAdapter
import kg.geektech.youtubeparsing.ui.lastPage.KEY_TO_BOTTOM
import kg.geektech.youtubeparsing.ui.lastPage.LastPageViewModel
import kg.geektech.youtubeparsing.ui.simplePlaylist.INT
import kotlinx.android.synthetic.main.detailed_playlist_fragment.*
import org.koin.android.ext.android.inject


open class BottomSheetFragment() : BottomSheetDialogFragment() {
    private var bottomSheetAdapter:BottomSheetAdapter?=null
    private var arrayOfList: MutableList<Item> = mutableListOf()
    private var list: Item? = null
    private val viewModel by inject<LastPageViewModel>()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null)
            let {
                list = arguments?.getSerializable(KEY_TO_BOTTOM) as Item
                Log.e("TAG", "onCreate:  id ${list?.contentDetails?.videoId} " )
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        setAdapter()

    }

    fun setAdapter() {
        Log.e("TAG", "setAdapter: ", )
        recycler_detailed.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        bottomSheetAdapter = BottomSheetAdapter(arrayOfList, this::onItemClick)
        recycler_detailed.apply {
            adapter = this@BottomSheetFragment.bottomSheetAdapter
        }
    }

    fun onItemClick(item: Item){


    }



}
