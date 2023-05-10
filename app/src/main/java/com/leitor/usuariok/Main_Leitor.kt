package com.leitor.usuariok

import android.content.Intent
import android.net.MacAddress
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.gson.Gson
import com.leitor.usuariok.databinding.ActivityMainBinding
//import com.leitor.usuariok.databinding.ActivityMainBinding
import com.leitor.usuariok.databinding.ActivityMainLeitorBinding


class Main_Leitor : AppCompatActivity() {
    private lateinit var binding: ActivityMainLeitorBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
//g

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainLeitorBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //  setSupportActionBar(binding.toolbar)

        //    val navController = findNavController(R.id.nav_host_fragment_content_main_leitor)
        //  appBarConfiguration = AppBarConfiguration(navController.graph)
        //  setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener {
            val navegarSegundaTela = Intent(this, MainActivity::class.java)

            startActivity(navegarSegundaTela)

        }


    }
}