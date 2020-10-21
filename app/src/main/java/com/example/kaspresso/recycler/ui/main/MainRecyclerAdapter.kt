package com.example.kaspresso.recycler.ui.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspresso.recycler.R
import com.example.kaspresso.recycler.ui.main.model.Application

class MainRecyclerAdapter(private val onApplicationClick: (Application) -> Unit = {}) : ListAdapter<Application, MainRecyclerAdapter.ViewHolder>(Callback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_main_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(application = getItem(position))
    }

    inner class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(application: Application) {
            root.findViewById<TextView>(R.id.text).text = application.title
            if (application.isSelected) {
                root.setBackgroundColor(Color.RED)
            } else {
                root.setBackgroundResource(R.drawable.item_background)
            }
            root.setOnClickListener { onApplicationClick.invoke(application) }
        }
    }

    class Callback : DiffUtil.ItemCallback<Application>() {
        override fun areItemsTheSame(oldItem: Application, newItem: Application): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: Application, newItem: Application): Boolean = oldItem == newItem
    }
}
