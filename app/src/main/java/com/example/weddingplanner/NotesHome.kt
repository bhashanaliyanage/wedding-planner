package com.example.weddingplanner

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.weddingplanner.adapter.ItemsAdapter
import com.example.weddingplanner.adapter.NotesAdapter
import com.example.weddingplanner.database.ItemsDatabase
import com.example.weddingplanner.database.NotesDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_budget_calc.*
import kotlinx.android.synthetic.main.fragment_notes_home.*
import kotlinx.coroutines.launch

class NotesHome : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_notes_home, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notes_recycler.setHasFixedSize(true)
        notes_recycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                var notes = NotesDatabase.getDatabase(it).noteDao().getAllNotes()
                notes_recycler.adapter = NotesAdapter(notes)
            }
        }

        btnAddNote.setOnClickListener {
            Log.e("FAB", "Clicked")
            replaceFragment(NotesAdd())
        }

        /*btnAddNote.setOnClickListener {
            view -> replaceFragment(NotesAdd())
        }*/
        /*fun onClickFab(view: View) {
            replaceFragment(NotesAdd())
        }*/
    }
}