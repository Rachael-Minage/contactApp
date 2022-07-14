package com.example.contactapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class ContactAdapter(var contactList: List<Contacts>):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
            var binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ContactViewHolder(binding)
        }


    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
       var currentContact = contactList.get(position)
        with(holder.binding){
            tvName.text = currentContact.name
            tvPhone.text = currentContact.phoneNumber
            tvAddress.text = currentContact.address
            tvEmail.text = currentContact.email
        }
        val context = holder.itemView.context
        val contactBinding = holder.binding

        holder.binding.tvName.text = currentContact.name
        holder.binding.tvEmail.text = currentContact.email

        holder.binding.tvAddress.text = currentContact.address

        Picasso.get()
            .load(currentContact.image)
            .resize(300, 300)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_account_circle_24)
            .into(holder.binding.imgAvatar)


        holder.binding.cvContacts.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, viewContactActivty::class.java)
            intent.putExtra("NAME", currentContact.name)
            intent.putExtra("PHONE_NUMBER",currentContact.phoneNumber)
            intent.putExtra("EMAIL",currentContact.email)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("IMAGE", currentContact.image)


            context.startActivity(intent)

        }
        holder.binding.imgAvatar.setOnClickListener {
            Toast.makeText(context, "You have clicked on my face", Toast.LENGTH_LONG)
                .show()
        }
    }


    override fun getItemCount(): Int {
        return contactList.size
    }

}

class ContactViewHolder(var binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root){

}