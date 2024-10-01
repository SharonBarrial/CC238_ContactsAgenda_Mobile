package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //array list of contacts (i)
    var contacts = ArrayList<Contact>()

    //adapter for the recycler view (ii)
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //add contacts to the array list (i)
        localContacts()
    }

    //function to add contacts to the array list (i)
    private fun localContacts() {
        contacts.add(Contact("John", "1234567890"))
        contacts.add(Contact("Annet", "0987654321"))
        contacts.add(Contact("Smith", "1234567890"))
        contacts.add(Contact("Lucius", "0987654321"))
        contacts.add(Contact("Harry", "1234567890"))
        contacts.add(Contact("Ron", "0987654321"))
    }
}