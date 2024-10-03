package com.example.cp2_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.cp2_mobile.fragments.ContactListFragment
import com.example.cp2_mobile.fragments.FormFragment

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        // Carrega o FormFragment inicialmente
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FormFragment())
                .commit()
        }
    }

    fun showContactList(contactList: List<String>) {
        val contactListFragment = ContactListFragment()
        // Você pode passar a lista de contatos usando argumentos
        val args = Bundle()
        args.putStringArrayList("contacts", ArrayList(contactList))
        contactListFragment.arguments = args

        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, contactListFragment)
            .addToBackStack(null) // Adiciona a transação ao back stack
            .commit()
    }
}
