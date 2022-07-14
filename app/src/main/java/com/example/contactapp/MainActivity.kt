package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.ActivityMainBinding
import com.example.contactapp.databinding.ContactListItemBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }

    fun displayContacts() {

        var contact1=Contacts("Rachael","0768501532","baronotieno@gmail.com","South B","https://i.pinimg.com/236x/25/a1/5a/25a15ab58fbe9da14d7efb85227525f7.jpg")
        var contact2=Contacts("Lauryne","0768501532","levisodhiambo@gmail.com","Westlands","https://i.pinimg.com/564x/35/e0/a0/35e0a0205018063de1a93dabf717815c.jpg")
        var contact3=Contacts("Minage","0768501532","sofiabaraza@gmail.com","GreenFields","https://www.pinterest.com/pin/25966135343951982/")
        var contact4=Contacts("Wangoko","0768501532","whitneywanjira@gmail.com","Epren","https://i.pinimg.com/236x/9c/3a/21/9c3a21be85270c8cfddf903ae9abfc96.jpg")
        var contact5=Contacts("May","0768501532","floidoketch@gmail.com","Kasarani","https://www.pinterest.com/pin/1046383294644174277/")
        var contact6=Contacts("Gada","0768501532","ruthnabwire@gmail.com","Doonholm","https://i.pinimg.com/236x/37/21/15/3721156d903fe62ec7d0d09b08ce7761.jpg")

        var contactlist = listOf(contact1,contact2,contact3,contact4,contact5,contact6)
        var contactsAdapter = ContactAdapter(contactlist)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactsAdapter
    }
}
