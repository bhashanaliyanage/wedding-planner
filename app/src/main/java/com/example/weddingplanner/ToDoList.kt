package com.example.weddingplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.weddingplanner.adapter.ToDosAdapter
import com.example.weddingplanner.database.ToDosDatabase
import kotlinx.android.synthetic.main.fragment_to_do_list.*
import kotlinx.coroutines.launch

class ToDoList : BaseFragment() {
    // TODO: Rename and change types of parameters
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
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddTodo.setOnClickListener {
            replaceFragment(TodoAdd())
        }

        todoRecycler.setHasFixedSize(true)
        todoRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                var todos = ToDosDatabase.getDatabase(it).todoDao().getAllToDos()
                todoRecycler.adapter = ToDosAdapter(todos)
            }
        }
    }
}