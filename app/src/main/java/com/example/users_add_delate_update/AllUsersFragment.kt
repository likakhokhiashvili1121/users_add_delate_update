package com.example.users_add_delate_update

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.users_add_delate_update.databinding.FragmentAllUsersBinding

class AllUsersFragment : Fragment() {

    private lateinit var binding: FragmentAllUsersBinding

    private val usersList = mutableListOf<UsersModel>()
    private lateinit var recyclerAdapter: usersRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("addUser") { requestKey, bundle ->
            val name: UsersModel = bundle.getParcelable<Parcelable>("userData") as UsersModel
            usersList.add(name)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAllUsersBinding.inflate(inflater, container, false)

        addbtn()
        init()

        return binding.root
    }

    fun addbtn() {
        binding.addButton.setOnClickListener() {
            Navigation.findNavController(it)
                .navigate(R.id.action_allUsersFragment_to_addUsersFragment)
        }
    }

    fun init() {

        recyclerAdapter = usersRecyclerAdapter(usersList, object : UserRemoveListener {

            override fun editUser(position: Int) {
                setFragmentResultListener("editItems") { requestKey, bundle ->
                    val user: UsersModel = bundle.getParcelable<Parcelable>("list") as UsersModel
                    usersList.removeAt(position)
                    usersList.add(position, user)
                }
                view?.let { Navigation.findNavController(it).navigate(R.id.editUsersFragment) }
            }
        })
        binding.usersRecycler.layoutManager = LinearLayoutManager(context)
        binding.usersRecycler.adapter = recyclerAdapter

    }

}