package com.crocodic.previewimagemaster

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.crocodic.previewimage.PreviewImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var url_image = "https://pbs.twimg.com/profile_images/905640995924074496/xZCFjRE-.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().load(url_image).into(ivImage)

        ivImage.setOnClickListener(this)
        btnImage.setOnClickListener(this)
        btnNoImage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivImage -> {
                PreviewImage().load(url_image, ivImage, this)
            }
            R.id.btnImage -> {
                PreviewImage().load(url_image, ivImage, this)
            }
            R.id.btnNoImage -> {
                PreviewImage().load("", ivImage, this)
            }
        }
    }
}
