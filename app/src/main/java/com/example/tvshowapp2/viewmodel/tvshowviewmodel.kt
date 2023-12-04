package com.example.tvshowapp2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowapp2.model.tvshowmodelItem
import com.example.tvshowapp2.repository.tvshowrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class tvshowviewmodel @Inject constructor(private val repository: tvshowrepository): ViewModel(){

    private val _response= MutableLiveData<List<tvshowmodelItem>>()
    val tvshowresponsedata: LiveData<List<tvshowmodelItem>>
        get() = _response
    init {

        getalltvshow()
    }


    private fun getalltvshow()=viewModelScope.launch {
        repository.gettvshbow().let {response ->
            if(response.isSuccessful){
                _response.postValue(response.body())
            }else
            {
                Log.d("Taggy","getalltvshow ${response.code()}")
            }

        }
    }


}