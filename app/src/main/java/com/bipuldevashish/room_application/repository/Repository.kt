package com.bipuldevashish.room_application.repository

import androidx.lifecycle.LiveData
import com.bipuldevashish.room_application.room.NoteDao
import com.bipuldevashish.room_application.room.NoteItem

class Repository(private val noteDao: NoteDao) {


        val getAllNotes: LiveData<List<NoteItem>> = noteDao.getAllNotes()

        suspend fun insertNotes(noteItem: NoteItem){
            noteDao.insert(noteItem)
        }
}