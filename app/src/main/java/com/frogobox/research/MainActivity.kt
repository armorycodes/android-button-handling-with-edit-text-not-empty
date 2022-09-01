package com.frogobox.research

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.frogobox.research.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {

            et1.addTextChangedListener(textWatcher)
            et2.addTextChangedListener(textWatcher)
            et3.addTextChangedListener(textWatcher)
            et4.addTextChangedListener(textWatcher)
            et5.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    binding.button.isEnabled = validateButton()
                    if (binding.et2.text.toString().isNotEmpty() && binding.et2.text.toString().toInt() > 50) {
                        binding.et2.error = "Max 50"
                    }

                    if (s.toString().length > 1) {
                        if (s.toString()[0] == '0') {
                            val st = s.toString().removePrefix("0")
                            binding.et5.setText(st)
                            binding.et5.setSelection(st.length)
                        }
                    }
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    binding.button.isEnabled = validateButton()
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    binding.button.isEnabled = validateButton()
                    if (binding.et2.text.toString().isNotEmpty() && binding.et2.text.toString().toInt() > 50) {
                        binding.et2.error = "Max 50"
                    }
                }
            })

        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            binding.button.isEnabled = validateButton()
            if (binding.et2.text.toString().isNotEmpty() && binding.et2.text.toString().toInt() > 50) {
                binding.et2.error = "Max 50"
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            binding.button.isEnabled = validateButton()
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.button.isEnabled = validateButton()
            if (binding.et2.text.toString().isNotEmpty() && binding.et2.text.toString().toInt() > 50) {
                binding.et2.error = "Max 50"
            }
        }
    }

    private fun validateButton(): Boolean {
        binding.apply {
            return et1.validateText() &&
                    et2.validateText() &&
                    et3.validateText() &&
                    et4.validateText() &&
                    et5.validateText() &&
                    binding.et2.text.toString().toInt() < 50
        }
    }

    private fun AppCompatEditText.validateText(): Boolean {
        return text.toString().isNotEmpty()
    }


}