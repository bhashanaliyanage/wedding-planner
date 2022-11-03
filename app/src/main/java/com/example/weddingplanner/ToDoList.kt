package com.example.weddingplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_to_do_list.*

class ToDoList : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
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
        var count = 0
        todoItem01.setOnClickListener {
            todoItem01Box.performClick()
            if (todoItem01Box.isChecked) {
                count += 1
            } else {
                count -= 1
            }
            taskAmount.text = count.toString() + "/3"
        }

        todoItem02.setOnClickListener {
            todoItem02Box.performClick()
            if (todoItem02Box.isChecked) {
                count += 1
            } else {
                count -= 1
            }
            taskAmount.text = count.toString() + "/3"
        }

        todoItem03.setOnClickListener {
            todoItem03Box.performClick()
            if (todoItem03Box.isChecked) {
                count += 1
            } else {
                count -= 1
            }
            taskAmount.text = count.toString() + "/3"
        }

    }
}