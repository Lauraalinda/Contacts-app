package dev.alinda.mycontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.alinda.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityViewContactBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras(){

        val extras =intent.extras
        var name =extras?.getString("NAME","")
        var phone =extras?.getString("PHONE_NUMBER","")
        var email=extras?.getString("EMAIL","")
        var address=extras?.getString("ADDRESS","")
        var image=binding.imgImage

        Toast
            .makeText(this,name,Toast.LENGTH_LONG)
            .show()
        Toast
            .makeText(this,phone,Toast.LENGTH_LONG)
            .show()
        Toast
            .makeText(this,email,Toast.LENGTH_LONG)
            .show()
        Toast
            .makeText(this,address,Toast.LENGTH_LONG)
            .show()
        binding.tvName2.text=name
        binding.tvPhonenumber2.text=phone
        binding.tvEmail2.text=email
        binding.tvAddress2.text=address
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)


    }
}

