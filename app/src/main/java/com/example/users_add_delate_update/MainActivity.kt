package com.example.users_add_delate_update
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.users_add_delate_update.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}