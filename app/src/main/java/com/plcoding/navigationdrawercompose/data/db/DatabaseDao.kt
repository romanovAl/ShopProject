package com.plcoding.navigationdrawercompose.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.plcoding.navigationdrawercompose.data.dbEntities.Balance
import com.plcoding.navigationdrawercompose.data.dbEntities.Order
import com.plcoding.navigationdrawercompose.data.dbEntities.Product

@Dao
interface DatabaseDao {
    @Insert
    fun order(order: Order)

    @Query("SELECT * FROM balance")
    fun getBalance() : Balance

    @Delete
    fun deleteProduct(product: Product)

    @Insert
    fun addProduct(product: Product)
}