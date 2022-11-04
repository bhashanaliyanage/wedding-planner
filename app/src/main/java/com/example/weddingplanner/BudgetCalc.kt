package com.example.weddingplanner

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.weddingplanner.adapter.ItemsAdapter
import com.example.weddingplanner.database.ItemsDatabase
import kotlinx.android.synthetic.main.fragment_budget_calc.*
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Currency

class BudgetCalc : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        fragmentTransaction.replace(R.id.frame_layout, fragment).addToBackStack("Test")
        fragmentTransaction.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_budget_calc, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        budget_calc_recycler.setHasFixedSize(true)
        budget_calc_recycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                var items = ItemsDatabase.getDatabase(it).budgetDao().getAllItems()

                var amount = ItemsDatabase.getDatabase(it).budgetDao().getSum()
                Log.e("Amount", amount.toString())
                val format = NumberFormat.getCurrencyInstance()
                format.maximumFractionDigits = 0
                format.currency = Currency.getInstance("LKR")
                var sendAmount = format.format(amount)
                tvAmount.text = sendAmount

                budget_calc_recycler.adapter = ItemsAdapter(items)
            }
        }

        btnAddItem.setOnClickListener {
            replaceFragment(BudgetCalcAddFragment())
        }
    }
}