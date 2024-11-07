package com.example.homework

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.ComponentActivity
import com.example.homework.databinding.ActivityFirstPageBinding

class MainActivity : ComponentActivity() {

    private lateinit var viewBinding: ActivityFirstPageBinding
    // this is comment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)







// Добавляем TextWatcher для каждого поля EditText
        viewBinding.editText1.addTextChangedListener(textWatcher)
        viewBinding.editText2.addTextChangedListener(textWatcher)
        viewBinding.editText3.addTextChangedListener(textWatcher)

        // Добавляем слушатель для CheckBox
        viewBinding.editBox.setOnCheckedChangeListener { _, _ -> checkFields() }

        // Обработчик для кнопки
        viewBinding.submitButton.setOnClickListener {
            // Ваш код для отправки данных
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)

        }
    }

    // TextWatcher для отслеживания изменения текста в EditText
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            checkFields()
        }
        override fun afterTextChanged(s: Editable?) {}
    }
    // Функция для проверки всех полей
    private fun checkFields() {
        val isText1Filled = viewBinding.editText1.text.toString().isNotEmpty()
        val isText2Filled = viewBinding.editText2.text.toString().isNotEmpty()
        val isText3Filled = viewBinding.editText3.text.toString().isNotEmpty()
        val isCheckBoxChecked = viewBinding.editBox.isChecked

        viewBinding.submitButton.isEnabled =
            isText1Filled && isText2Filled && isText3Filled && isCheckBoxChecked
    }
}