package dev.alinda.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.alinda.mycontacts.databinding.ContactListItemBinding

class ContactRvAdapter (var contactList: List<Contact>):RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding =ContactListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false )

        return ContactsViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val context =holder.itemView.context
        var currentContact = contactList.get(position)
        with(holder.binding) {
            tvName.text = currentContact.name
            tvEmail.text = currentContact.email
            tvPhonenumber.text = currentContact.phone
            tvAddress.text = currentContact.address
            Picasso.get()
                .load(currentContact.image)
                .resize(300, 300)
                .centerCrop()
                .into(imgContact)
             }

            holder.binding.cvContact.setOnClickListener {

                val intent = Intent(context, ViewContactActivity::class.java)
                intent.putExtra("NAME",currentContact.name)
                intent.putExtra("PHONE_NUMBER",currentContact.phone)
                intent.putExtra("EMAIL",currentContact.email)
                intent.putExtra("ADDRESS",currentContact.address)
                intent.putExtra("IMAGE",currentContact.image)
                context.startActivity(intent)
            }
            holder.binding.imgContact.setOnClickListener{
                Toast
                    .makeText(context,"You have clicked on my face",Toast.LENGTH_LONG)
                    .show()
            }
        }


    override fun getItemCount(): Int {
      return contactList.size
    }

}
class ContactsViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root){

}
