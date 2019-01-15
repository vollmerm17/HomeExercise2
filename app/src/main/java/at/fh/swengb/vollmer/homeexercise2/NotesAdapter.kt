package at.fh.swengb.vollmer.homeexercise2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(): RecyclerView.Adapter<NotesViewHolder>() {
    var noteList =listOf<Notes>()


    fun updateList(newList: List<Notes>) {
        noteList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NotesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val notesItemView = inflater.inflate(R.layout.item_note, parent, false)
        return NotesViewHolder(notesItemView)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(viewHolder: NotesViewHolder, position: Int) {
        val notes = noteList[position]
        viewHolder.bindItem(notes) // Unresolved reference, i.e. the function bindItem does not exist. Why?
    }
}

class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindItem(notes: Notes) {
        itemView.title.text =notes.title
        itemView.content.text =notes.content

    }
}