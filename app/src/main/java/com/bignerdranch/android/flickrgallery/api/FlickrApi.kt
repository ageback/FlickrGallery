package com.bignerdranch.android.flickrgallery.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=d620c755cda2a8b1630636373a90ef16" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s" +
                "&date=2021-05-10"
    )
    fun fetchPhotos(): Call<FlickrResponse>

    /**
     * @Url 注解会覆盖基URL，直接用url参数联网
     */
    @GET
    fun fetchUrlBytes(@Url url: String): Call<ResponseBody>
}