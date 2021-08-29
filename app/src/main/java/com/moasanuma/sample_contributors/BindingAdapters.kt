package com.moasanuma.sample_contributors

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.moasanuma.sample_contributors.network.ContributorsProperty
import com.moasanuma.sample_contributors.overview.OverviewViewModel.ContributorsApiStatus
import com.moasanuma.sample_contributors.overview.PhotoGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri =
            imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<ContributorsProperty>?
) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("contributorsApiStatus")
fun bindStatus(
    statusImageView: ImageView,
    status: ContributorsApiStatus?
) {
    when (status) {
        ContributorsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ContributorsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ContributorsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
