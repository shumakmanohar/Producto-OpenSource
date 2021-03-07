package com.example.producto.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductoDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: TodoEntity)

    @Query("DELETE FROM producto_table_temp WHERE todo_id = :todo_id")
    suspend fun delete_todo(todo_id:Int)

    @Query("SELECT * FROM producto_table_temp")
    fun get_AllTodos():LiveData<List<TodoEntity>>
}