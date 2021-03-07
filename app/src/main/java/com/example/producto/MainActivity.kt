package com.example.producto

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.producto.database.ProductoDB
import com.example.producto.database.RepositoryProducto

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Todo Full  Screen
        // Todo App intro
        //viewModel = ViewModelProviders.of(this,viewModelFactory).get(MainActivityVM::class.java)

    }
}