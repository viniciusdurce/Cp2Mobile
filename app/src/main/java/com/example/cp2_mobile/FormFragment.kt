package com.example.cp2_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.cp2_mobile.MainActivity
import com.example.cp2_mobile.R

class FormFragment : Fragment(R.layout.fragment_form) {
    private lateinit var editTextName: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var spinnerContactType: Spinner
    private lateinit var buttonSubmit: Button
    private lateinit var imageButton: ImageButton

    private val contactList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar os componentes da view
        editTextName = view.findViewById(R.id.editTextName)
        editTextPhone = view.findViewById(R.id.editTextPhone)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        spinnerContactType = view.findViewById(R.id.spinnerContactType)
        buttonSubmit = view.findViewById(R.id.buttonSubmit)
        imageButton = view.findViewById(R.id.imageButton)

        // Configurar o Spinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.contact_types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerContactType.adapter = adapter
        }

        buttonSubmit.setOnClickListener {
            val contact = "${editTextName.text}, ${editTextPhone.text}, ${editTextEmail.text}, ${spinnerContactType.selectedItem}"
            contactList.add(contact)

            // Navegar para a lista de contatos
            (activity as MainActivity).showContactList(contactList)
        }

        imageButton.setOnClickListener {
            // Ação do ImageButton (por exemplo, abrir a galeria)
        }
    }
}
