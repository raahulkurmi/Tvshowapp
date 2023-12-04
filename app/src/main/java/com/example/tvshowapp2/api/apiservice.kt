package com.example.tvshowapp2.api

import com.example.tvshowapp2.helper.constant
import com.example.tvshowapp2.model.tvshowmodel
import com.google.android.gms.common.api.Response
import retrofit2.http.GET

interface apiservice {

    @GET(constant.endpoint)
    suspend fun gettvshow():retrofit2.Response<tvshowmodel>

}