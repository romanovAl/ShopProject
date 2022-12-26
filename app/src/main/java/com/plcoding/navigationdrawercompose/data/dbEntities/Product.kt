package com.plcoding.navigationdrawercompose.data.dbEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(
    ForeignKey(
        entity = Order::class,
        parentColumns = arrayOf("productId"),
        childColumns = arrayOf("id"),
        onDelete = ForeignKey.CASCADE
    )
))
class Product(
    @PrimaryKey val id : Int,
    @ColumnInfo val name : String,
    @ColumnInfo val price : String
)