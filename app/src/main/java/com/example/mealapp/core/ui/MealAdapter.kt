package com.example.mealapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealapp.R
import com.example.mealapp.core.domain.model.Meal
import com.example.mealapp.databinding.ItemListMealBinding

class MealAdapter:RecyclerView.Adapter<MealAdapter.ListViewHolder>() {

    private var listData = ArrayList<Meal>()
    var onItemClick:((Meal)->Unit)?=null

    fun setData(newListData: List<Meal>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
    inner class ListViewHolder(view:View):RecyclerView.ViewHolder(view) {
        private val binding = ItemListMealBinding.bind(view)
        fun bind(data:Meal){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(ivItemImage)
                tvItemSubtitle.text = data.strCategory
                tvItemTitle.text=data.strMeal
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_meal, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}