package com.moasanuma.sample_contributors.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moasanuma.sample_contributors.network.ContributorsApi
import com.moasanuma.sample_contributors.network.ContributorsProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getContributorsProperties()
    }

    private fun getContributorsProperties() {
        ContributorsApi.retrofitService.getProperties().enqueue(
            object : Callback<List<ContributorsProperty>> {
                override fun onResponse(
                    call: Call<List<ContributorsProperty>>,
                    response: Response<List<ContributorsProperty>>
                ) {
                    _response.postValue(response.body().toString())
                }

                override fun onFailure(call: Call<List<ContributorsProperty>>, t: Throwable) {
                    _response.postValue("Failure: " + t.message)
                }
            }
        )
    }
}
