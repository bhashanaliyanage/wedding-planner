package com.example.weddingplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weddingplanner.database.ItemsDatabase
import com.example.weddingplanner.entities.Items
import kotlinx.android.synthetic.main.fragment_budget_calc_add.*
import kotlinx.coroutines.launch

class BudgetCalcAddFragment : BaseFragment(){
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_budget_calc_add, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add_item_back.setOnClickListener {
            replaceFragment(BudgetCalc())
        }

        btn_add_item_submit.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
        if (txt_item_title.text.isNullOrEmpty() && txt_item_price.text.isNullOrEmpty()) {
            Toast.makeText(context, "Item Name or Price Required!", Toast.LENGTH_SHORT).show()
        } else {
            launch {
                var items = Items()
                items.title = txt_item_title.text.toString()
                items.price = txt_item_price.text.toString()
                context?.let {
                    ItemsDatabase.getDatabase(it).budgetDao().insertItem(items)
                    txt_item_title.setText("")
                    txt_item_price.setText("")
                    replaceFragment(BudgetCalc())
                }
            }
        }
    }


}