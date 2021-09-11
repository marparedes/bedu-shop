package org.bedu.bedushop

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
    private lateinit var inputEmail : EditText
    private lateinit var inputPass : EditText
    private lateinit var errorUser : TextView
    private lateinit var errorPass : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        inputEmail = findViewById(R.id.email)
        inputPass = findViewById(R.id.password)

        errorUser = findViewById(R.id.errorUser)
        errorPass = findViewById(R.id.errorPass)

        btnLogin.setOnClickListener {

            if(inputEmail.text.isBlank() && inputPass.text.isBlank()) {
                errorUser.text = getString(R.string.errorUser)
                errorPass.text = getString(R.string.errorPass)
            } else {
                // TOAST
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, getString(R.string.successToast), duration)
                toast.show()
            }
            //cuando email y pass no tienen valores se muestra erroruser y errorpass
            // falta validacion de si solo alguno de los dos no tiene valores
        }

        inputEmail.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //text.text = input.text
                if(!errorUser.text.isBlank() || !errorPass.text.isBlank()) {
                    errorUser.text = ""
                    errorPass.text = ""
                }
            }
        })
    }
}