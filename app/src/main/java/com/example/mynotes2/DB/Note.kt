package com.example.mynotes2.DB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    var title: String,
    var note:String
)
{
    @PrimaryKey(autoGenerate = true)
    var key:Int = 0
}

