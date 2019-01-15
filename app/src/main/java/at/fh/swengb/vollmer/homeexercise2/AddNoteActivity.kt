package at.fh.swengb.vollmer.homeexercise2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {
    lateinit var db: NotesDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        db = NotesDatabase.getDatabase(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
    }

    fun addNote (v: View){
        val title = myTitle.text.toString()
        val content =myContent.text.toString()
        val notes = Notes(title,content)

        db.notesDao.insert(notes)
        db.notesDao.all()
        val intent = Intent(this, NoteListActivity::class.java)
        startActivity(intent)
    }
}
