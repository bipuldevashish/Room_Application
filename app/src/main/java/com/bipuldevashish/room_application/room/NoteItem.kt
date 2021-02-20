package com.bipuldevashish.room_application.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.bipuldevashish.room_application.util.Converters
import java.util.*

@Entity(
        tableName = "note_table"
)
data class NoteItem(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo val id: Int,
        @ColumnInfo val title: String,
        @ColumnInfo val description: String,
        @TypeConverters(Converters::class)
        @ColumnInfo val date: Date?
)