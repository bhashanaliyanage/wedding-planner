package com.example.weddingplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_hotels.*

class HotelsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotels, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnHotelSlider.setOnClickListener {
            val buttonText = btnHotelSlider.text.toString()

            if (buttonText == "Outdoor") {
                btnHotelSlider.text = "Indoor"
                btnHotelSlider.setBackgroundColor(resources.getColor(R.color.accent))
            } else {
                btnHotelSlider.text = "Outdoor"
                btnHotelSlider.setBackgroundColor(resources.getColor(R.color.black_accent))
            }
        }
    }
}