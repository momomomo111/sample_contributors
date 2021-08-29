package com.moasanuma.sample_contributors.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moasanuma.sample_contributors.network.ContributorsApi
import com.moasanuma.sample_contributors.network.ContributorsProperty
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    enum class ContributorsApiStatus { LOADING, ERROR, DONE }

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    private val _properties = MutableLiveData<List<ContributorsProperty>>()

    val properties: LiveData<List<ContributorsProperty>>
        get() = _properties

    private val _status = MutableLiveData<ContributorsApiStatus>()

    val status: LiveData<ContributorsApiStatus>
        get() = _status

    init {
        getContributorsProperties()
    }

    private fun getContributorsProperties() {
        viewModelScope.launch {
            _status.value = ContributorsApiStatus.LOADING
            try {
                _properties.value = ContributorsApi.retrofitService.getProperties()
                _status.value = ContributorsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ContributorsApiStatus.ERROR
            }
        }
    }
}
