package org.bedu.bedushop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin : Button
    private lateinit var btnRegister: Button
    private lateinit var inputEmail : EditText
    private lateinit var inputPass : EditText
    private lateinit var errorUser : TextView
    private lateinit var errorPass : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.register)

        inputEmail = findViewById(R.id.email)
        inputPass = findViewById(R.id.password)

        errorUser = findViewById(R.id.errorUser)
        errorPass = findViewById(R.id.errorPass)


        btnLogin.setOnClickListener {

            if(inputEmail.text.isBlank() && inputPass.text.isBlank()) {
                errorUser.text = getString(R.string.errorUser)
                errorPass.text = getString(R.string.errorPass)
            } else if(inputEmail.text.isBlank()) {
                errorUser.text = getString(R.string.errorUser)
            } else if (inputPass.text.isBlank()) {
                errorPass.text = getString(R.string.errorPass)
            } else {
                // TOAST
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, getString(R.string.successToast), duration)
                toast.show()
            }
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java).apply {
                putExtras(intent)
            }

            startActivity(intent)
        }

        inputEmail.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //text.text = input.text
                if(errorUser.text.isNotBlank()) errorUser.text = ""
            }
        })

        inputPass.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun afterTextChanged(p0: Editable?) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(errorPass.text.isNotBlank()) errorPass.text = ""
            }

        })
    }
}