package com.crocodic.previewimage

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.facebook.drawee.backends.pipeline.Fresco
import com.helloanatoly.animatedimagesviewer.ImageViewer

class PreviewImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)

        val url = intent.getStringExtra("photo")

        val strings = arrayOf(url)

        ImageViewer.Builder(this, strings)
            .setStartPosition(0)
            .setBackgroundColorRes(R.color.black_alpha35)
            //.setOverlayView(overlayView)
            .hideStatusBar(true)
            .exitAnimation(true)
            .show()
    }

    fun load(url: String, v: View, context: AppCompatActivity) {

        if (url.isEmpty()) {
            Toast.makeText(context, "No image can be displayed !!", Toast.LENGTH_SHORT).show()
            return
        }

        val photo = Intent(context, PreviewImage::class.java)
        photo.putExtra("photo", url)

        val p1 = Pair.create(v, "transition")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context, p1)
        context.startActivity(photo, options.toBundle())
    }

}
