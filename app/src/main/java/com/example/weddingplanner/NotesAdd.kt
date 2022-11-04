package com.example.weddingplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weddingplanner.database.NotesDatabase
import com.example.weddingplanner.entities.Notes
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_notes_add.*
import kotlinx.coroutines.launch

class NotesAdd : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes_add, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddNoteBack.setOnClickListener {
            replaceFragment(NotesHome())
        }

        btnAddNoteFrag.setOnClickListener {
            if (etNoteTitle.text.isNullOrEmpty() && etNote.text.isNullOrEmpty()) {
                Toast.makeText(context, "Note Name or Note is Required!", Toast.LENGTH_SHORT).show()
            } else {
                launch {
                    val notes = Notes()
                    notes.title = etNoteTitle.text.toString()
                    notes.note = etNote.text.toString()
                    context?.let {
                        NotesDatabase.getDatabase(it).noteDao().insertNote(notes)
                        etNoteTitle.setText("")
                        etNote.setText("")
                        replaceFragment(NotesHome())
                    }
                    Snackbar.make(it,"Note Added", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}