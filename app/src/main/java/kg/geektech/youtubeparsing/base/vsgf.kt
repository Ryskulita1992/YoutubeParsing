package kg.geektech.youtubeparsing.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlin.reflect.KClass

abstract class BaseFragmenthhh<out ViewModel : BaseViewModel>(
    private var layoutId: Int,
    viewModelClass: KClass<ViewModel>
) : AppCompatActivity() {
    abstract fun layoutId(): Int

    val viewModel: ViewModel by lazy { getViewModel<ViewModel>(viewModelClass) }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        initLanguage()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setupViews()
        setupLiveData()
        setupFetchRequests()
        showError()
    }


    private fun initLanguage() {}

    abstract fun setupLiveData()
    abstract fun setupViews()
    abstract fun setupFetchRequests()

    private fun showError() {
        viewModel.errorMessage.observeForever {
        }
    }


}