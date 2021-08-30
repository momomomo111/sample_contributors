package com.moasanuma.sample_contributors.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.moasanuma.sample_contributors.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(OverviewViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = OverviewFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayPropertyDetails(it)
            }
        )
        viewModel.navigateToSelectedProperty.observe(
            viewLifecycleOwner,
            {
                if (null != it) {
                    this.findNavController().navigate(
                        OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it)
                    )
                    viewModel.displayPropertyDetailsComplete()
                }
            }
        )

        return binding.root
    }
}
