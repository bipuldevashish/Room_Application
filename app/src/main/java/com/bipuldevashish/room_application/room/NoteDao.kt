package com.bipuldevashish.room_application.room

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteItem: NoteItem)

    @Update
    suspend fun update(noteItem: NoteItem)


    @Query("DELETE FROM note_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM note_table ORDER BY timeStamp Desc")
    fun getAllNotes(): LiveData<List<NoteItem>>
}