package dev.alinda.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.alinda.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts(){
        var contact=Contact("John","0772431177","johnalinda@yahoo.com","Muyenga","https://images.pexels.com/photos/1820919/pexels-photo-1820919.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact1=Contact("Sarah","0772434325","sarahkabahenda6@gmail.com","Munyonyo","https://images.pexels.com/photos/718978/pexels-photo-718978.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact2=Contact("Joel","0788938311","joelmwesigwa@gmail.com","Usa","https://images.pexels.com/photos/2033447/pexels-photo-2033447.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact3=Contact("Linda","0703695954","lindakenyana24@gmail.com","London","https://images.pexels.com/photos/1139243/pexels-photo-1139243.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact4=Contact("Abigail","0756046099","lauraalinda069@gmail.com","Canada","https://images.pexels.com/photos/3214751/pexels-photo-3214751.jpeg?auto=compress&cs=tinysrgb&w=400")

        var contactList = listOf(contact,contact1,contact2,contact3,contact4)
        var contactsAdapter= ContactRvAdapter(contactList)
        binding.rvContacts.layoutManager =LinearLayoutManager(this)
        binding.rvContacts.adapter=contactsAdapter
    }
}