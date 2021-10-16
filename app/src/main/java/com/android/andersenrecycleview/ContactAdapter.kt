package com.android.andersenrecycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.andersenfragments.R
import com.android.andersenfragments.databinding.ContactViewItemBinding
import com.bumptech.glide.Glide

typealias OnItemClicked = (Contact) -> Unit

class ContactAdapter(
    private val contacts: List<Contact>,
    private val context: Context,
    private val onItemClicked: OnItemClicked,
) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    class ContactHolder(
        itemView: View,
        private val context: Context,
        private val contactsSize: Int,
        onItemClicked: OnItemClicked
    ) : RecyclerView.ViewHolder(itemView) {

        private val binding = ContactViewItemBinding.bind(itemView)

        private lateinit var contact: Contact

        init {
            binding.root.setOnClickListener {
                onItemClicked(contact)
            }
        }

        fun bind(contact: Contact) {
            this.contact = contact

            with(binding) {
                titleView.text = contact.getNameAndSurname()
                downloadImage(context, contact, this)
            }
        }

        private fun downloadImage(
            context: Context,
            contact: Contact,
            binding: ContactViewItemBinding
        ) {
            Glide.with(context)
                .load(contact.imageUrl)
                .placeholder(R.drawable.a)
                .error(R.drawable.b)
                .into(binding.imageView)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.contact_view_item, parent, false)
        return ContactHolder(view, context, contacts.size, onItemClicked)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size
}