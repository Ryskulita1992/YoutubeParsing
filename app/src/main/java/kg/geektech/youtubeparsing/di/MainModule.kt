package kg.geektech.youtubeparsing.di

import kg.geektech.youtubeparsing.data.remoteDB.RetrofitClient
import kg.geektech.youtubeparsing.data.YoutubeRepository
import kg.geektech.youtubeparsing.data.localDB.DatabaseClient
import kg.geektech.youtubeparsing.ui.main.MainViewModel
import kg.geektech.youtubeparsing.ui.detailedPlaylist.DetailedPlaylistViewModel
import kg.geektech.youtubeparsing.ui.lastPage.LastPageViewModel
import kg.geektech.youtubeparsing.ui.simplePlaylist.SimplePlaylistViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var networkModule = module {
    single { RetrofitClient() }
    single { RetrofitClient().provideYoutubeApi() }
}
var repositoryModule = module {
    factory { YoutubeRepository(get(), get()) }
}

var dbModule = module {
    single { DatabaseClient().provideDatabase(androidContext()) }
    single { DatabaseClient().providePlaylistDao(get()) }
}

var viewModelModule = module {
    viewModel { SimplePlaylistViewModel(get()) }
    viewModel { DetailedPlaylistViewModel(get()) }
    viewModel {
        MainViewModel(get())

    }
}



