package com.moasanuma.sample_contributors.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moasanuma.sample_contributors.databinding.GridViewItemBinding
import com.moasanuma.sample_contributors.network.ContributorsProperty

class PhotoGridAdapter : ListAdapter<ContributorsProperty,
    PhotoGridAdapter.ContributorsPropertyViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.ContributorsPropertyViewHolder {
        return ContributorsPropertyViewHolder(
            GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: PhotoGridAdapter.ContributorsPropertyViewHolder,
        position: Int
    ) {
        val contributorsProperty = getItem(position)
        holder.bind(contributorsProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ContributorsProperty>() {
        override fun areItemsTheSame(
            oldItem: ContributorsProperty,
            newItem: ContributorsProperty
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: ContributorsProperty,
            newItem: ContributorsProperty
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class ContributorsPropertyViewHolder(
        private var binding:
            GridViewItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: ContributorsProperty) {
            binding.property = marsProperty
            binding.executePendingBindings()
        }
    }
}
