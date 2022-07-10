package com.example.users_add_delate_update

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.users_add_delate_update.databinding.UserActivityLayoutBinding

class usersRecyclerAdapter(
    private val usersList: MutableList<UsersModel>,
    private val userRemoveListener: UserRemoveListener
) :
    RecyclerView.Adapter<usersRecyclerAdapter.usersViewholder>() {

    inner class usersViewholder(private val binding: UserActivityLayoutBinding) :
        RecyclerView.ViewHolder(binding.root),View.OnClickListener {

        val nameTV = binding.TVname
        val lastNameTV = binding.TVlastName
        val emailTV = binding.TVemail
        val removeBtn = binding.IBremove
        val editBtn = binding.IBedit

        fun bind() {
            val model = usersList[adapterPosition]
            nameTV.text = model.firstName
            lastNameTV.text = model.lastName
            emailTV.text = model.email

            removeBtn.setOnClickListener {
                usersList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
            editBtn.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            userRemoveListener.editUser(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): usersViewholder {
        val itemView =
            UserActivityLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = usersViewholder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: usersViewholder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = usersList.size

}