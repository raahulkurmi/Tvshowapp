package com.example.tvshowapp2.repository

import com.example.tvshowapp2.api.apiservice
import javax.inject.Inject

class tvshowrepository @Inject constructor(val apiservice: apiservice) {
    suspend fun gettvshbow() =apiservice.gettvshow()
}