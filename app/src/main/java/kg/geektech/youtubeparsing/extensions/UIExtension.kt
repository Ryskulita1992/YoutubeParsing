package kg.geektech.youtubeparsing.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun toastText(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun ImageView.loadImage(url: String?) {
    Glide
        .with(context)
        .load(url)
        .into(this)
}

fun View.layoutParam(run:ViewGroup.LayoutParams.()->Unit){
    val params=layoutParams
    run(params)
    layoutParams=params

}

fun ViewGroup.inflateEx(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}










