package org.bedu.bedushop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var username : EditText
    private lateinit var emailInput: EditText
    private lateinit var phoneInput : EditText
    private lateinit var passwordInput : EditText
    private lateinit var registerButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        username = findViewById(R.id.username)
        emailInput = findViewById(R.id.emailInput)
        phoneInput = findViewById(R.id.phoneInput)
        passwordInput = findViewById(R.id.passwordInput)

        registerButton = findViewById(R.id.registerBtn)

        registerButton.setOnClickListener {
            val duration = Toast.LENGTH_SHORT
            if(validate(username, emailInput, phoneInput, passwordInput)) {

                val toast = Toast.makeText(applicationContext, getString(R.string.registerSuccessToast), duration)
                toast.show()
                finish()
            } else {
                val toast = Toast.makeText(applicationContext, getString(R.string.registerErrorToast), duration)
                toast.show()
            }
        }

    }

    fun validate(username: EditText, email: EditText, phone: EditText, pass: EditText): Boolean {
        if(username.text.isBlank() || email.text.isBlank() || phone.text.isBlank() || pass.text.isBlank()) {
            return false
        }
        return true
    }
}