package kg.geektech.youtubeparsing.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment : Fragment() {

    abstract fun layoutId(): Int


//    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layoutId(), container, false)

    open fun onBackPressed() {}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null


//    private fun progressStatus(viewStatus: Int) =
//        with(activity) { if (this is BaseActivity) this.progress.visibility = viewStatus }


}