package at.fh.swengb.vollmer.homeexercise2

import android.arch.persistence.room.Entity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private val notesAdapter = NotesAdapter()
    lateinit var db: NotesDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val nameText = sharedPreferences.getString("MY_KEY_FOR_STRING", "Anonymous")
        val ageText = sharedPreferences.getString("MY_KEY_FOR_INT", "noAge")

        val textView= findViewById(R.id.my_text_view) as TextView
        textView.setText("Notes for "+ nameText+ "," + ageText)

        db = NotesDatabase.getDatabase(this)

        recyclerView2.adapter = notesAdapter
        recyclerView2.layoutManager = LinearLayoutManager(this)
    }


    override fun onResume() {
        super.onResume()
        db.notesDao.all()
        notesAdapter.updateList(db.notesDao.all())
    }

     fun addIt (v:View){
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
     }

}
