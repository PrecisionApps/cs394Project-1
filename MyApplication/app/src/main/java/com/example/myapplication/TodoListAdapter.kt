package com.example.myapplication

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentSecondBinding

class TodoListAdapter(val data: MutableList<TodoData>) : RecyclerView.Adapter<TodoListAdapter.ItemViewHolder>() {
    class ItemViewHolder(val item: View) : RecyclerView.ViewHolder(item) {


        private val TODOKey = "Todo"
        lateinit var todo: TodoData

        init {
            item.setOnClickListener {
                //click handling

                val action = FirstFragmentDirections.actionListFragmentToTaskDetailFragment()

                Navigation.findNavController(item.rootView.findViewById(R.id.navhost)).navigate(action)
            }

        }

        fun bind(todo: TodoData) {
            this.todo = todo
            val textView = itemView.findViewById<TextView>(R.id.textView)
            val desc = itemView.findViewById<TextView>(R.id.dateTextView)
            textView.text = todo.title
            desc.text = todo.date
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