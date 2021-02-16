package com.bipuldevashish.room_application.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NoteItem::class], version = 1, exportSchema = false)

abstract class NoteDatabase : RoomDatabase(){

    abstract fun NoteDao() : NoteDao


    companion object{
        @Volatile
        private var INSTANCE : NoteDatabase? = null

        fun getDatabase(context: Context) : NoteDatabase{
            val tempInstance = INSTANCE

            /*
            check for instance if already exists,else create one
             */
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(    //  Database Builder : build's the database
                    context.applicationContext,         //  Provide the Context
                    NoteDatabase::class.java,          //  Table format for Database
                    "note_database"             //  Name for the Database
                ).fallbackToDestructiveMigration()      // If we want to increase the version of database this prevent app from crashing in terms of failure
                .build()                               //  Build fun. to execute the builder.
                INSTANCE = instance                     //  Assigning local var. instance to INSTANCE
                return instance                         //  Returning the instance
            }
        }
    }
}