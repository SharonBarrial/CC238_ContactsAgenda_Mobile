package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ContactAdapter(var contacts: ArrayList<Contact>) : Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        //metodo que se encarga de "inflar" los datos del prototype
        // mostrar
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact, parent, false)
        return ContactPrototype(view)
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        // vincula el contacto con el prototype
        // bind the contact with the prototype
        //holder.bind(contacts[position])
        holder.bind(contacts.get(position))
    }

    override fun getItemCount(): Int {
        //return the number of contacts, devuelve el tamaño
        return contacts.size
    }

}

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //vincular los componentes del prototype con el adapter
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvPhone = itemView.findViewById<TextView>(R.id.tvPhonenumber)

    //Vamos a crear una función "bind" que vincule el control con la clase contact
    fun bind(contact: Contact) {
        tvName.text = contact.name
        tvPhone.text = contact.phoneNumber
    }

}
