package org.bedu.bedushop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment


//validación en la MainActivity
// verificar si ya se inicio sesión o no, en el caso de que no haya iniciado sesión definir una transición a la activity login

const val logggedIn = false

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      si el user está logueado no ingresa al layout login
        if(logggedIn) {
            setContentView(R.layout.activity_main)

            val listFragment = supportFragmentManager.findFragmentById(R.id.fragmentList) as ListFragment
            listFragment.setListener {
                val detailFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as DetailFragment
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.PRODUCT, it)
                startActivity(intent)
            }
        } else {
            setContentView(R.layout.activity_login_register)
            val intent = Intent(this, LoginRegisterActivity::class.java).apply {
                putExtras(intent)
            }

            startActivity(intent)
        }
    }
}