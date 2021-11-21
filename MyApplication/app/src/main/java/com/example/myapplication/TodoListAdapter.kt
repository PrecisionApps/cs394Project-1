package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(val data: MutableList<TodoData>) : RecyclerView.Adapter<TodoListAdapter.ItemViewHolder>() {
    class ItemViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val textView = item.findViewById<TextView>(R.id.text)

        private val TODOKey = "Todo"
        lateinit var todo: TodoData

        init {
            item.setOnClickListener {
                //click handling
                val showDetailIntent = Intent(itemView.context, TodoDetailsActivity::class.java)
                showDetailIntent.putExtra(TODOKey, todo)
                itemView.context.startActivity(showDetailIntent)
            }

        }

        fun bind(todo: TodoData) {
            this.todo = todo
            textView.text = todo.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layouts, parent, false)
        return ItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val todo = data[position]
        holder.bind(todo)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}