package at.fh.swengb.vollmer.homeexercise2

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Notes::class], version = 1)

abstract class NotesDatabase : RoomDatabase() {

    abstract val notesDao: NotesDao

    companion object {
        fun getDatabase(context: Context): NotesDatabase {
            return Room.databaseBuilder(context, NotesDatabase::class.java, "notes-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}