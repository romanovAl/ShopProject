package com.plcoding.navigationdrawercompose.data.dbEntities

import androidx.room.ColumnInfo

data class MainDB(
    @ColumnInfo val productsList: List<Product>,
    @ColumnInfo val balance: Balance,
    @ColumnInfo val ordersList : List<Order>
)