package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symbols")
data class SymbolsDb(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val code: String,
    val name: String
)