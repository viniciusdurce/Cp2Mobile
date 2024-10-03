package com.example.cp2_mobile.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.cp2_mobile.R

class ContactListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var listViewContacts: ListView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewContacts = view.findViewById(R.id.listViewContacts)

        // Obter contatos passados como argumentos
        val contactList = arguments?.getStringArrayList("contacts") ?: arrayListOf()

        // Configurar adaptador
        val contactsAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, contactList)
        listViewContacts.adapter = contactsAdapter
    }
}
