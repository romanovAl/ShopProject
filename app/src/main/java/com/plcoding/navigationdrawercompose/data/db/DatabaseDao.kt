package com.plcoding.navigationdrawercompose.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.plcoding.navigationdrawercompose.data.dbEntities.Balance
import com.plcoding.navigationdrawercompose.data.dbEntities.Order
import com.plcoding.navigationdrawercompose.data.dbEntities.Product

@Dao
interface DatabaseDao {
    @Insert
    fun order(order: Order)

    @Delete
    fun deleteOrder(order: Order)

    @Query("SELECT * FROM balance")
    fun getBalance() : Balance

    @Update
    fun updateBalance(balance: Balance)

    @Query("SELECT * FROM product WHERE id = :id")
    fun getProduct(id : Int) : Product

    @Delete
    fun deleteProduct(product: Product)

    @Insert
    fun addProduct(product: Product)
}