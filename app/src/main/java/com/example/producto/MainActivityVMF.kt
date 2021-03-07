package com.example.producto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.producto.database.RepositoryProducto
import java.lang.IllegalArgumentException

class MainActivityVMF(private val repository: RepositoryProducto): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityVM::class.java))
            return MainActivityVM(repository) as T
        throw IllegalArgumentException("No View Model Found")
    }
}