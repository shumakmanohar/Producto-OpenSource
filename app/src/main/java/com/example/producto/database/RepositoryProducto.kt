package com.example.producto.database


class RepositoryProducto(private  val db:ProductoDB)
{
    //Get All Todos
    //no suspend Needed coz it return the LiveData
    fun get_todo() = db.productoDAO.get_AllTodos()
    //Insert
    suspend fun insert_todo(todo: TodoEntity) = db.productoDAO.insert(todo)

    //Delete
    suspend fun delete_todo(todo_ID :Int) = db.productoDAO.delete_todo(todo_ID)


}
