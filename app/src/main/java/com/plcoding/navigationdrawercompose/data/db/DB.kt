package com.plcoding.navigationdrawercompose.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.plcoding.navigationdrawercompose.data.dbEntities.Balance
import com.plcoding.navigationdrawercompose.data.dbEntities.MainDB
import com.plcoding.navigationdrawercompose.data.dbEntities.Order
import com.plcoding.navigationdrawercompose.data.dbEntities.Product

@Database(entities = arrayOf(MainDB::class, Balance::class, Order::class, Product::class), version = 1)
abstract class DB : RoomDatabase() {
    abstract fun databaseDao() : DatabaseDao

    companion object {
        fun buildDatabase(context : Context) = Room.databaseBuilder(context,
        DB::class.java, "database_shop.db")
            .build()
    }
}