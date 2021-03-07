package com.example.producto.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "producto_table_temp")
data class TodoEntity(
    @ColumnInfo(name = "todo_id")
    @PrimaryKey(autoGenerate = true)
    var todo_id:Int,
    @ColumnInfo(name = "todo_name")
    var todo_name :String,
    @ColumnInfo(name="todo_completed")
    var todo_completed:Boolean,
    @ColumnInfo(name = "todo_category")
    var todo_category:String,
    @ColumnInfo(name="todo_createdDate")
    var todo_CreatedDate: Long
)