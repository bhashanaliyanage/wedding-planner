package com.example.weddingplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.weddingplanner.database.ItemsDatabase
import com.example.weddingplanner.entities.Items
import kotlinx.android.synthetic.main.fragment_create_budget_calculator_item.*
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreateBudgetCalculatorItemFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return inflater.inflate(R.layout.fragment_create_budget_calculator_item, container, false)
        var rootView: View = inflater.inflate(R.layout.fragment_create_budget_calculator_item, container, false)
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CreateBudgetCalculatorItemFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_add_item_submit.setOnClickListener {
            saveItem()
        }
    }

    private fun saveItem() {
        if (txt_item_title.text.isNullOrEmpty()) {
            Toast.makeText(context, "Item name required!", Toast.LENGTH_SHORT).show()
        }
        if (txt_item_price.text.isNullOrEmpty()) {
            Toast.makeText(context, "Item price required!", Toast.LENGTH_SHORT).show()
        }

        launch {
            var items = Items()
            items.title = txt_item_title.text.toString()
            items.price = txt_item_price.text.toString()

            context?.let {
                ItemsDatabase.getDatabase(it).budgetDao().insertItem(items)
                txt_item_title.setText("")
                txt_item_price.setText("")
            }
        }
    }
}