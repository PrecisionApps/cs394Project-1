package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener({ view -> onClick(view) })


        val recyclerView = findViewById<RecyclerView>(R.id.recycler)

        recyclerView.layoutManager = LinearLayoutManager(this)

        //fillSampleTodos()
        recyclerView.adapter = TodoListAdapter()
    }

    val todos = mutableListOf<TodoData>()

    fun fillSampleTodos() {


        for(i in 0..10) {
            todos.add(TodoData(i.toString() + ". Todo Test",i.toString() + ". yapılacak iş ",
                "Şimdi"
            ))
        }






    }


    fun onClick(v: View?) {
        println("Button click is working...")
    }
}