package com.example.myapplication

import java.io.Serializable
import java.util.*

data class TodoData(val title: String,
                    val description: String,
                    val date: String
): Serializable