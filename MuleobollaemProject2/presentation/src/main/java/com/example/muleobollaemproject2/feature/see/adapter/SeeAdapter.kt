package com.example.muleobollaemproject2.feature.see.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.comment.Comment
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.databinding.ItemCommentBinding

class SeeAdapter(private val commentList: List<Comment>):
    RecyclerView.Adapter<SeeAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment,parent,false)
        return CustomViewHolder(ItemCommentBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.tvComment.text = commentList[position].username+" : "+commentList[position].content
        Log.d("TAG", "onBindViewHolder: "+commentList[position].username)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    class CustomViewHolder(val binding: ItemCommentBinding):RecyclerView.ViewHolder(binding.root) {

    }
}