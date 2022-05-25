package com.example.muleobollaemproject.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.databinding.ActivityMainBinding
import com.example.muleobollaemproject.databinding.ItemMainBinding

class MainAdapter(private val mainList:ArrayList<MainData>, private val mainActivity: MainActivity):RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)

        return CustomViewHolder(ItemMainBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.itemName.text = mainList[position].name
        holder.binding.itemTitle.text = mainList[position].title
        holder.binding.itemMain.text = mainList[position].main
        holder.itemView.setOnClickListener {
            mainActivity.moveSee(mainList[position].main, mainList[position].title)
        }
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    class CustomViewHolder(val binding: ItemMainBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(){
        }
    }
}