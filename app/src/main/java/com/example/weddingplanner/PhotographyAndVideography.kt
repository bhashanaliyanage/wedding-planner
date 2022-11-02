package com.example.weddingplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_photography_and_videography.*

class PhotographyAndVideography : Fragment() {
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
        return inflater.inflate(R.layout.fragment_photography_and_videography, container, false)
    }

    companion object;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPhotoVideoSlider.setOnClickListener {
            val buttonText = btnPhotoVideoSlider.text.toString()
            if (buttonText == "Videography") {
                btnPhotoVideoSlider.text = "Photography"
                btnPhotoVideoSlider.setBackgroundColor(resources.getColor(R.color.accent))
            } else {
                btnPhotoVideoSlider.text = "Videography"
                btnPhotoVideoSlider.setBackgroundColor(resources.getColor(R.color.black_accent))
            }
        }
    }
}