package com.bignerdranch.android.flickrgallery

import com.bignerdranch.android.flickrgallery.api.FlickrResponse
import retrofit2.Call

class FlickrRepository {
    private lateinit var flickrCall: Call<FlickrResponse>

    fun setFlickrCall(call: Call<FlickrResponse>) {
        this.flickrCall = call
    }

    fun cancelRequestInFlight() {
        if (::flickrCall.isInitialized) {
            flickrCall.cancel()
        }
    }
}