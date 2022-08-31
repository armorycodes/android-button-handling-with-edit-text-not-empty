## Android Research Tech
- Template repository for doing research on Android Technologies

## Code

### XML
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/name"
        app:endIconDrawable="@drawable/ic_baseline_close_24"
        app:endIconMode="clear_text">

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/et_1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/til_2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/age"
        app:endIconDrawable="@drawable/ic_baseline_close_24"
        app:endIconMode="clear_text"
        app:helperText="Age max 50">

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/et_2"
            android:maxLength="3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number" />

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/til_3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/app_name"
        app:endIconMode="password_toggle">

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/et_3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="textPassword" />

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/app_name"
        app:endIconDrawable="@drawable/ic_baseline_close_24"
        app:endIconMode="clear_text">

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/et_4"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/app_name"
        app:endIconDrawable="@drawable/ic_baseline_close_24"
        app:endIconMode="clear_text">

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/et_5"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

    </com.google.android.material.textfield.TextInputLayout>

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="48dp"
        android:enabled="false"
        android:text="test" />

</LinearLayout>
```

### Kotlin
```kotlin
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
            et5.addTextChangedListener(textWatcher)

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
```

## Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

## Attention !!!
- Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account