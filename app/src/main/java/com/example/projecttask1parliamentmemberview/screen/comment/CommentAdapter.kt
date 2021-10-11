package com.example.projecttask1parliamentmemberview.screen.comment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttask1parliamentmemberview.data.Comment
import com.example.projecttask1parliamentmemberview.databinding.ListCommentBinding

/**
 * Name: Son Dang (2012177)
 * Date: 11.10.2021
 * Adapter for CommentList RecyclerView
 */

class CommentAdapter : ListAdapter<Comment, CommentAdapter.ViewHolder>(CommentListDiffCallback()) {

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val comment = getItem(position)
            holder.bind(comment)
        }

        // Call when the RecyclerView need a viewHolder
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder.from(parent)
        }

        class ViewHolder private constructor(val binding: ListCommentBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(comment: Comment) {
                binding.commentData = comment
                binding.commentItem.text = comment.comment
            }

            companion object {
                fun from(parent: ViewGroup): ViewHolder {
                    val layoutInflater = LayoutInflater.from(parent.context)
                    val binding = ListCommentBinding.inflate(layoutInflater, parent, false)
                    return ViewHolder(binding)
                }
            }
        }
    }

    // Use DiffCallBack to update the changes in the list of items
    class CommentListDiffCallback : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }
}