package com.bignerdranch.android.flickrgallery

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
}