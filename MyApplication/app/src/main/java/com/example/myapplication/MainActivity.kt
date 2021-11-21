package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener({ view -> onClick(view) })


        val recyclerView = findViewById<RecyclerView>(R.id.recycler)

        recyclerView.layoutManager = LinearLayoutManager(this)

        //fillSampleTodos()
        //recyclerView.adapter = TodoListAdapter()


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigationHost) as NavHostFragment

        drawerLayout = binding.drawerLayout
        NavigationUI.setupWithNavController(binding.navigationHost, navHostFragment.navController)
        //to displau the hamburger menu icon for nav drawer
        NavigationUI.setupActionBarWithNavController(this,navHostFragment.navController, drawerLayout)
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