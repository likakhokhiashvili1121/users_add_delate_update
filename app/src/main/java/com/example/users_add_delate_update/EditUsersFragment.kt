package com.example.users_add_delate_update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.Navigation
import com.example.users_add_delate_update.databinding.FragmentEditUsersBinding

class EditUsersFragment : Fragment() {

    private lateinit var binding: FragmentEditUsersBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEditUsersBinding.inflate(inflater, container, false)

        editUsers()

        return binding.root
    }

    private fun editUsers() {

        binding.BTNsave.setOnClickListener {
            val editFirstName = binding.ETeditFirstName.text.toString()
            val editLastName = binding.ETeditLastName.text.toString()
            val editEmail = binding.ETeditEmail.text.toString()
            val editUser = UsersModel(editFirstName, editLastName, editEmail)
            setFragmentResult("editItems", bundleOf("list" to editUser))
            Navigation.findNavController(it).navigateUp()
        }
    }

}