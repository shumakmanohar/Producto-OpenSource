package com.example.producto.todotempscreen.fragmentodo

import androidx.lifecycle.ReportFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.producto.database.RepositoryProducto
import java.lang.IllegalArgumentException

class FragmentTodoTempVMF(private val repository: RepositoryProducto) :ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragmentTodoTempVM::class.java))
            return FragmentTodoTempVM(repository) as T
        throw IllegalArgumentException("No View Class Model Found")
    }
}