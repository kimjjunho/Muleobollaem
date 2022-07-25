package com.example.muleobollaemproject2.feature.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.databinding.ItemMainBinding
import com.example.domain.entity.main.Main
import com.example.muleobollaemproject2.feature.main.ui.MainActivity

class MainAdapter (private val mainList:List<Main>, private val mainActivity: MainActivity):
    RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)

        return CustomViewHolder(ItemMainBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.itemName.text = mainList[position].user_id
        holder.binding.itemTitle.text = mainList[position].title
        holder.binding.itemMain.text = mainList[position].content
        holder.binding.itemId.text = mainList[position].user_id
        holder.itemView.setOnClickListener {
            mainActivity.moveSee(mainList[position].content, mainList[position].title)
        }
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    class CustomViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(){
        }
    }
}