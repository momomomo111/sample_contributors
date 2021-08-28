package com.moasanuma.sample_contributors.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moasanuma.sample_contributors.network.ContributorsApi
import com.moasanuma.sample_contributors.network.ContributorsProperty
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    private val _properties = MutableLiveData<List<ContributorsProperty>>()

    val properties: LiveData<List<ContributorsProperty>>
        get() = _properties

    init {
        getContributorsProperties()
    }

    private fun getContributorsProperties() {
        viewModelScope.launch {
            try {
                _properties.value = ContributorsApi.retrofitService.getProperties()
                _response.value = "Success: Mars properties retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}
