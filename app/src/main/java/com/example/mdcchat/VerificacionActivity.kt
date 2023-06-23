package com.example.mdcchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mdcchat.databinding.ActivityVerificacionBinding
import com.google.firebase.auth.FirebaseAuth

class VerificacionActivity : AppCompatActivity() {

    var binding :ActivityVerificacionBinding? = null
    var auth:FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVerificacionBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        auth = FirebaseAuth.getInstance()
        if(auth!!.currentUser !=null){
            val intent = Intent(this@VerificacionActivity,
                MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        supportActionBar?.hide()
        binding!!.editNumber.requestFocus()
        binding!!.continueBtn.setOnClickListener {
            val intent=Intent(this@VerificacionActivity,
                OTPActivity::class.java)
            intent.putExtra("NumeroTelefono",binding!!.editNumber.text.toString())
            startActivity(intent)
        }
    }
}