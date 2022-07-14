package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactapp.databinding.ActivityViewContactActivtyBinding
import com.squareup.picasso.Picasso

class viewContactActivty : AppCompatActivity() {
    lateinit var binding: ActivityViewContactActivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContactActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }
    fun  getExtras(){
        val extras=intent.extras
        var name=extras?.getString("NAME","")
        var phone=extras?.getString("PHONE_NUMBER","")
        var email=extras?.getString("EMAIL","")
        var address=extras?.getString("ADDRESS","")
        var image= binding.imgAvatarTwo



        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        Toast.makeText(this,phone,Toast.LENGTH_LONG).show()
        binding.tvContactName.text=name
        binding.tvNum.text=phone

        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)
    }
}


