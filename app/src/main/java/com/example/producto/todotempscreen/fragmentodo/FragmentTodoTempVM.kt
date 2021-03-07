package com.example.producto.todotempscreen.fragmentodo

import androidx.lifecycle.ViewModel
import com.example.producto.database.RepositoryProducto

class FragmentTodoTempVM (var repository: RepositoryProducto):ViewModel()
{
    fun getalltodos() = repository.get_todo()
}
