package com.moasanuma.sample_contributors.overview

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.moasanuma.sample_contributors.getOrAwaitValue
import com.moasanuma.sample_contributors.network.ContributorsProperty
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OverviewViewModelTest {
    private lateinit var overviewViewModel: OverviewViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        overviewViewModel = OverviewViewModel()
    }

    @Test
    fun getContributorsProperties_setJsonData() {

        overviewViewModel.displayPropertyDetails(
            ContributorsProperty(
                "login",
                100,
                "42ff3",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "https://",
                "User",
                false,
                100
            )
        )
        overviewViewModel.displayPropertyDetailsComplete()

        val value = overviewViewModel.navigateToSelectedProperty.getOrAwaitValue()

        assertThat(value, `is`(nullValue()))
    }
}
