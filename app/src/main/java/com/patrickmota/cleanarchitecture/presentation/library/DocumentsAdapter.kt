package com.patrickmota.cleanarchitecture.presentation.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.patrickmota.cleanarchitecture.R
import com.patrickmota.core.domain.Document
import com.patrickmota.cleanarchitecture.presentation.StringUtil
import kotlinx.android.synthetic.main.item_document.view.*


class DocumentsAdapter(
    private val documents: MutableList<com.patrickmota.core.domain.Document> = mutableListOf(),
    private val glide: RequestManager,
    private val itemClickListener: (com.patrickmota.core.domain.Document) -> Unit
) : RecyclerView.Adapter<DocumentsAdapter.ViewHolder>() {

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val previewImageView: ImageView = view.ivPreview
    val titleTextView: TextView = view.tvTitle
    val sizeTextView: TextView = view.tvSize
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_document, parent, false)
    )
  }

  override fun getItemCount() = documents.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.run {
    glide.load(documents[position].thumbnail)
        .error(glide.load(R.drawable.preview_missing))
        .into(holder.previewImageView)
    holder.previewImageView.setImageResource(R.drawable.preview_missing)
    holder.titleTextView.text = documents[position].name
    holder.sizeTextView.text = StringUtil.readableFileSize(documents[position].size)
    holder.itemView.setOnClickListener { itemClickListener.invoke(documents[position]) }
  }

  fun update(newDocuments: List<com.patrickmota.core.domain.Document>) {
    documents.clear()
    documents.addAll(newDocuments)

    notifyDataSetChanged()
  }
}