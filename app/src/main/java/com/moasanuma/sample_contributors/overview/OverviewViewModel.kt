package com.moasanuma.sample_contributors.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moasanuma.sample_contributors.network.ContributorsApi
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getContributorsProperties()
    }

    private fun getContributorsProperties() {
        viewModelScope.launch {
            try {
                val listResult = ContributorsApi.retrofitService.getProperties()
                _response.postValue(listResult.toString())
            } catch (e: Exception) {
                _response.postValue("Failure: ${e.message}")
            }
        }
    }
}
