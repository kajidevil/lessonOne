package com.example.homework

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.editText1.addTextChangedListener(textWatcher)
        viewBinding.editText2.addTextChangedListener(textWatcher)
        viewBinding.editText3.addTextChangedListener(textWatcher)

        viewBinding.editBox.setOnCheckedChangeListener { _, _ -> checkFields() }
        viewBinding.submitButton.setOnClickListener {

        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            checkFields()
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun checkFields() {
        val isText1Filled = viewBinding.editText1.text.toString().isNotEmpty()
        val isText2Filled = viewBinding.editText2.text.toString().isNotEmpty()
        val isText3Filled = viewBinding.editText3.text.toString().isNotEmpty()
        val isCheckBoxChecked = viewBinding.editBox.isChecked

        viewBinding.submitButton.isEnabled =
            isText1Filled && isText2Filled && isText3Filled && isCheckBoxChecked
    }

}