package com.plcoding.navigationdrawercompose.data.dbEntities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Balance(
    @ColumnInfo val cash : Int,
    @ColumnInfo val cashless : Int
)