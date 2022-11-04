package com.example.weddingplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weddingplanner.database.ItemsDatabase
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.*

class Dashboard : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardViewBudget.setOnClickListener {
            replaceFragment(BudgetCalc())
        }

        cardViewVenue.setOnClickListener {
            replaceFragment(HotelsFragment())
        }

        todoCard.setOnClickListener {
            replaceFragment(ToDoList())
        }

        launch {
            context?.let {
                var amount = ItemsDatabase.getDatabase(it).budgetDao().getSum()
                val format = NumberFormat.getCurrencyInstance()
                format.maximumFractionDigits = 0
                format.currency = Currency.getInstance("LKR")
                var sendAmount = format.format(amount)

                tvDashboardAmount.text = sendAmount
            }
        }
    }
}