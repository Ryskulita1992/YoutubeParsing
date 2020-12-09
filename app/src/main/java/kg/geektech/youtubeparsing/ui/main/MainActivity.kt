package kg.geektech.youtubeparsing.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import kg.geektech.youtubeparsing.R
import kg.geektech.youtubeparsing.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater);
        setContentView(binding.root);
        setNavController()

    }

    fun setNavController(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }


//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.top_app_bar, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here.
//        val id = item.getItemId()
//
//        if (id == R.id.english) {
//            Toast.makeText(this, "Item One Clicked", Toast.LENGTH_LONG).show()
//            return true
//        }
//        if (id == R.id.russian) {
//            Toast.makeText(this, "Item Two Clicked", Toast.LENGTH_LONG).show()
//            return true
//        }
//
//        return super.onOptionsItemSelected(item)
//
//    }

}


