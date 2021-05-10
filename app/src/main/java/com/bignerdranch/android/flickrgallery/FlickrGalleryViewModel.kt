package com.bignerdranch.android.flickrgallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.flickrgallery.api.GalleryItem

class FlickrGalleryViewModel : ViewModel() {
    val galleryItemLiveData: LiveData<List<GalleryItem>>

    init {
        galleryItemLiveData = FlickrFetchr().fetchPhotos()
    }

    override fun onCleared() {
        super.onCleared()

    }
}