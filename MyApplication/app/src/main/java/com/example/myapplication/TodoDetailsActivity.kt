package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.example.myapplication.databinding.ActivityTodoDetailsBinding


class TodoDetailsActivity : AppCompatActivity() {
    private val TODOKey = "USER"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_user_detail)


         val binding: ActivityTodoDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_todo_details)
        val selectedUser = intent.getSerializableExtra(TODOKey) as TodoData

        binding.user = selectedUser

    }
}