package com.example.homework

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import com.example.homework.databinding.ActivityFirstPageBinding

class MainActivity : ComponentActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var submitButton: Button
    private lateinit var editbox: CheckBox
    private lateinit var viewBinding: ActivityFirstPageBinding

    // this is comment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editbox = findViewById(R.id.editBox)
        submitButton = findViewById(R.id.submitButton)
        // Устанавливаем слушатель для CheckBox
        editbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                addTextWatchers()
            } else {
                // Если CheckBox не отмечен, отключаем кнопку
                submitButton.isEnabled = false
                submitButton.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.gray)
                Toast.makeText(this, "Согласие недано", Toast.LENGTH_SHORT).show()
            }
        }

        submitButton.setOnClickListener {
            Log.d("MainActivity", "Кнопка нажата, переход на SecondActivity")
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addTextWatchers() {
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Проверяем, заполнены ли все поля
                val isFilled =
                    editText1.text.isNotEmpty() && editText2.text.isNotEmpty() && editText3.text.isNotEmpty()
                // Обновляем состояние кнопки в зависимости от заполненности полей
                submitButton.isEnabled = isFilled
                val color = if (isFilled) R.color.teal_700 else R.color.gray
                submitButton.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity, color)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
        // Добавляем TextWatcher к полям ввода
        editText1.addTextChangedListener(textWatcher)
        editText2.addTextChangedListener(textWatcher)
        editText3.addTextChangedListener(textWatcher)
    }
}