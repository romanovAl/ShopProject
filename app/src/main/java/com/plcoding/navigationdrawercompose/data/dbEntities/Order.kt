package com.plcoding.navigationdrawercompose.data.dbEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Order(
    @PrimaryKey val uid : Int,
    @ColumnInfo val productId: Int,
    @ColumnInfo val count : Int
)