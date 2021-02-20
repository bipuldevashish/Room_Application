package com.bipuldevashish.room_application.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.bipuldevashish.room_application.repository.Repository
import com.bipuldevashish.room_application.room.NoteDatabase
import com.bipuldevashish.room_application.room.NoteItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<NoteItem>>
    private val repository: Repository

    init {
        val noteDao = NoteDatabase.getDatabase(application).NoteDao()
        repository = Repository(noteDao)
        readAllData = repository.getAllNotes
    }

    fun insertNotes(noteItem: NoteItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNotes(noteItem)
        }
    }


}