package com.example.producto.todotempscreen.adddialog


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.producto.database.RepositoryProducto
import java.lang.IllegalArgumentException

class DialogFragment_VMFactory(private val repository: RepositoryProducto):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DialogFragment_ViewModel::class.java))
        {
            return DialogFragment_ViewModel(repository) as T
        }
        else
            throw IllegalArgumentException("No View Model Found")
    }
}