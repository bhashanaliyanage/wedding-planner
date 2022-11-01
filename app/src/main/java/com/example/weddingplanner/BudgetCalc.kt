package com.example.weddingplanner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_budget_calc.view.*
import kotlinx.coroutines.Dispatchers.Main

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BudgetCalc : BaseFragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_budget_calc, container, false)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            BudgetCalc().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnAddItem.setOnClickListener {
            // replaceFragment(CreateBudgetCalculatorItemFragment(), true)
            // loadFragment(CreateBudgetCalculatorItemFragment())
            Log.d("TEST", "Clicked")
            val intent = Intent (activity, BudgetCalcAdd::class.java)
            requireActivity().startActivity(intent)
        }
    }

    private fun replaceFragment(fragment: Fragment, isTransition: Boolean) {
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()
        /*if(isTransition) {
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
        }*/
        fragmentTransition.replace(R.id.cardView01, fragment)
            .addToBackStack(fragment.javaClass.simpleName)
        Log.e("LOX", "Um Done!")
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.cardView01, fragment)
        fragmentTransition.disallowAddToBackStack()
        fragmentTransition.commit()
    }
}