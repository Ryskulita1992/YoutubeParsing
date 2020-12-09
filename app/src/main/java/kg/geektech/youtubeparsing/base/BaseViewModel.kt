package kg.geektech.youtubeparsing.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.geektech.youtubeparsing.data.models.Item


open class BaseViewModel: ViewModel() {
    var errorMessage = MutableLiveData<String>()

    var listItems= MutableLiveData<Item>()
}