package com.example.producto.todotempscreen.adddialog

import androidx.lifecycle.ViewModel
import com.example.producto.database.RepositoryProducto
import com.example.producto.database.TodoEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DialogFragment_ViewModel (
    private val repository:RepositoryProducto
):ViewModel()
{
    //DataBase Functions
    fun insert(todo :TodoEntity) = CoroutineScope(Dispatchers.IO).launch {
        repository.insert_todo(todo)
    }
    fun delete(todo_ID :Int) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete_todo(todo_ID)
    }
    fun getAllTodo() =  repository.get_todo()
}