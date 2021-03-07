package com.example.producto.todotempscreen.fragmentodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.producto.database.TodoEntity
import com.example.producto.databinding.FragmentTodoTempBinding
import com.example.producto.databinding.TodoCardBinding

class TodoRCV ():RecyclerView.Adapter<TodoRCV.TodoViewHolder>()
{
    var todos = emptyList<TodoEntity>()
    inner  class TodoViewHolder( val binding: TodoCardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
       return TodoViewHolder(TodoCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentItem = todos[position]
       holder.binding.todoTitle.text = currentItem.todo_name.toString()
    }
    fun dataTrigger(todoList: List<TodoEntity>)
    {
        this.todos =todoList
        notifyDataSetChanged()
    }

}