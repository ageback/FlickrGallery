package com.bignerdranch.android.flickrgallery

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FlickrGalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flickr_gallery)

        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, FlickrGalleryFragment.newInstance())
                .commit()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, FlickrGalleryActivity::class.java)
        }
    }
}