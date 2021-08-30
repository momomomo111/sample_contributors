package com.moasanuma.sample_contributors.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moasanuma.sample_contributors.network.ContributorsProperty

class DetailViewModel(@Suppress("UNUSED_PARAMETER")contributorsProperty: ContributorsProperty, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<ContributorsProperty>()
    val selectedProperty: LiveData<ContributorsProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = contributorsProperty
    }
}
