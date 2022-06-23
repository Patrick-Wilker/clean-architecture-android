package com.patrickmota.cleanarchitecture.presentation.reader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.patrickmota.cleanarchitecture.R
import com.patrickmota.core.domain.Bookmark
import kotlinx.android.synthetic.main.item_bookmark.view.*

class BookmarksAdapter(
    private val bookmarks: MutableList<com.patrickmota.core.domain.Bookmark> = mutableListOf(),
    private val itemClickListener: (com.patrickmota.core.domain.Bookmark) -> Unit
) : RecyclerView.Adapter<BookmarksAdapter.ViewHolder>() {

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val titleTextView: TextView = view.bookmarkNameTextView
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bookmark, parent, false)
    )
  }

  override fun getItemCount() = bookmarks.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.titleTextView.text = holder.itemView.resources.getString(
        R.string.page_bookmark_format,
        bookmarks[position].page
    )
    holder.itemView.setOnClickListener { itemClickListener.invoke(bookmarks[position]) }
  }

  fun update(newBookmarks: List<com.patrickmota.core.domain.Bookmark>) {
    bookmarks.clear()
    bookmarks.addAll(newBookmarks)

    notifyDataSetChanged()
  }
}