package com.example.muleobollaemproject.feature.see

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.databinding.ItemSeeBinding

class SeeAdapter(private val seeList : ArrayList<SeeData>):RecyclerView.Adapter<SeeAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_see,parent,false)

        return CustomViewHolder(ItemSeeBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.itemTv.text = seeList[position].name+" : "+seeList[position].main
    }

    override fun getItemCount(): Int {
        return seeList.size
    }
    class CustomViewHolder(val binding: ItemSeeBinding):RecyclerView.ViewHolder(binding.root) {

    }

}