package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        //Cargar los elementos de la lista en el recycler view (ii)
        initView()
    }

    private fun initView() {
        //recycler view
        val rvContact= findViewById<RecyclerView>(R.id.rvContact)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    //function to add contacts to the array list (i)
    private fun localContacts() {
        contacts.add(Contact("John", "1234567890"))
        contacts.add(Contact("Annet", "0987654321"))
        contacts.add(Contact("Smith", "1234567890"))
        contacts.add(Contact("Lucius", "0987654321"))
        contacts.add(Contact("Harry", "1234567890"))
        contacts.add(Contact("Ron", "0987654321"))
        contacts.add(Contact("Hermione", "1234567890"))
        contacts.add(Contact("Ginny", "0987654321"))
        contacts.add(Contact("Fred", "1234567890"))
        contacts.add(Contact("George", "0987654321"))
        contacts.add(Contact("Percy", "1234567890"))
        contacts.add(Contact("Bill", "0987654321"))
        contacts.add(Contact("Charlie", "1234567890"))
        contacts.add(Contact("Molly", "0987654321"))
        contacts.add(Contact("Arthur", "1234567890"))
    }
}