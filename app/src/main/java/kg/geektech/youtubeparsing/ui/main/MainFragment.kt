package kg.geektech.youtubeparsing.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kg.geektech.youtubeparsing.databinding.MainFragmentBinding

class MainFragment : Fragment() {


    private  var viewModel: MainViewModel?=null
    private var fragmentBinding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding get() = fragmentBinding!!



    companion object {
        fun newInstance() = MainFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MainFragmentBinding.bind(view)
        fragmentBinding = binding

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

        // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)



        override fun onDestroyView() {
            // Consider not storing the binding instance in a field, if not needed.
            fragmentBinding = null
            super.onDestroyView()
        }



}