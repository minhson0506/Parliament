package com.example.projecttask1parliamentmemberview.screen.listmember

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttask1parliamentmemberview.R
import com.example.projecttask1parliamentmemberview.data.Member
import com.example.projecttask1parliamentmemberview.databinding.ListMemberBinding

/**
 * Name: Son Dang (2012177)
 * Date: 10.10.2021
 * Adapter for MemberList RecyclerView
 */

class ListMemberAdapter (private val clickListener: MemberListener):
    ListAdapter<Member, ListMemberAdapter.ViewHolder>(MemberListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    // Call when the RecyclerView need a viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListMemberBinding):
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(member: Member, clickListener: MemberListener) {
            binding.clickListener = clickListener
            binding.member = member
            binding.name.text = member.first + " " + member.last
            binding.constituency.text = member.constituency

            val imageDrawable = when (member.party) {
                "sd" -> R.drawable.sd
                "ps" -> R.drawable.ps
                "kd" -> R.drawable.kd
                "kesk" -> R.drawable.kesk
                "kok" -> R.drawable.kok
                "vihr" -> R.drawable.vihr
                "liik" -> R.drawable.liik
                "vas" -> R.drawable.vas
                "r" -> R.drawable.r
                else -> R.drawable.ic_launcher_foreground
            }
            binding.partyImage.setImageResource(imageDrawable)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListMemberBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

// Use DiffCallBack to update the changes in the list of items
class MemberListDiffCallback: DiffUtil.ItemCallback<Member>() {
    override fun areItemsTheSame(oldItem: Member, newItem: Member): Boolean {
        return oldItem.personNumber == newItem.personNumber
    }

    override fun areContentsTheSame(oldItem: Member, newItem: Member): Boolean {
        return oldItem == newItem
    }
}
class MemberListener(val clickListener: (personNumber: Int) -> Unit) {
    fun onClick(member: Member) = clickListener(member.personNumber)
}