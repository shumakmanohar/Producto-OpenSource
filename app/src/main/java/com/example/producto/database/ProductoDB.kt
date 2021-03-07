package com.example.producto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class ProductoDB : RoomDatabase() {

    abstract val productoDAO: ProductoDAO
    companion object {
        @Volatile
        private var INSTANCE: ProductoDB? = null
        fun getInstance(context: Context): ProductoDB {
            synchronized(this)
            {
                var instance = INSTANCE
                if (instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductoDB::class.java,
                        "producto_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}