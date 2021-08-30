package com.moasanuma.sample_contributors.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moasanuma.sample_contributors.network.ContributorsProperty

class DetailViewModelFactory(
        private val contributorsProperty: ContributorsProperty,
        private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(contributorsProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
