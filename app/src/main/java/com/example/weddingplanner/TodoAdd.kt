package com.example.weddingplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weddingplanner.database.ToDosDatabase
import com.example.weddingplanner.entities.ToDos
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_todo_add.*
import kotlinx.coroutines.launch

class TodoAdd : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_todo_add, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddTodoFrag.setOnClickListener {
            if (etTodoTitle.text.isNullOrEmpty()) {
                Toast.makeText(context, "ToDo Title is Required!", Toast.LENGTH_SHORT).show()
            } else {
                launch {
                    val todos = ToDos()
                    todos.title = etTodoTitle.text.toString()
                    context?.let {
                        ToDosDatabase.getDatabase(it).todoDao().insertToDo(todos)
                        etTodoTitle.setText("")
                        replaceFragment(ToDoList())
                    }
                    Snackbar.make(it,"ToDo Added", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}