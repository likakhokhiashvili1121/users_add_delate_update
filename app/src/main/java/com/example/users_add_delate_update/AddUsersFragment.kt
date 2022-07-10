package com.example.users_add_delate_update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.Navigation
import com.example.users_add_delate_update.databinding.FragmentAddUsersBinding

class AddUsersFragment : Fragment() {

    private lateinit var binding: FragmentAddUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddUsersBinding.inflate(layoutInflater, container, false)

        addUsers()

        return binding.root
    }

    private fun addUsers() {

        binding.BTNsend.setOnClickListener {
            val firstName = binding.ETaddFirstName.text.toString()
            val lastName = binding.ETAddLastName.text.toString()
            val email = binding.ETAddEmail.text.toString()

            val userData = UsersModel(firstName,lastName,email)
            setFragmentResult("addUser", bundleOf("userData" to userData))
            Navigation.findNavController(it).navigateUp()
        }
    }



}