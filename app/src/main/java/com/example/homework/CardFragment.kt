package com.example.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework.databinding.FragmentCardBinding

class CardFragment : Fragment() {

    private lateinit var viewBinding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentCardBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

}