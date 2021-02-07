package com.example.dinnerdecider2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dinnerdecider2.databinding.ActivityMainBinding
import kotlin.properties.Delegates
import kotlin.random.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var choice: Int = 10
    lateinit var food: String
    var  imageToBeShown = 6
    private fun decide(a : Int){
        when(a){
            0 -> {
                food = "Chips"
                imageToBeShown = R.drawable.chips
            }
            1 -> {
                food = "Rice"
                imageToBeShown = R.drawable.rice
            }
            2 -> {
                food = "Ugali"
                imageToBeShown = R.drawable.ugali
            }
            3 -> {
                food = "Matoke"
                imageToBeShown = R.drawable.matoke
            }
            4 -> {
                food = "Chapati"
                imageToBeShown = R.drawable.chapati
            }
            5 -> {
                food = "Pilau"
                imageToBeShown = R.drawable.pilau
            }
            else -> {
                food = "We couldn't decide"
                imageToBeShown = R.drawable.error
            }
        }
        binding.textView.text = food
        binding.background.setBackgroundResource(imageToBeShown)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
         choice = Random.nextInt(0, 5)
            decide(choice)

        }
        binding.exit.setOnClickListener {
            exitProcess(-1)
        }
        binding.save.setOnClickListener {
            if (choice == 10) {
                Toast.makeText(this, "Decide first", Toast.LENGTH_SHORT).show()
            } else {
                var savedfood = choice
                val sharedPreferences = getSharedPreferences("Shared1", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.apply {
                    putInt("One", savedfood)
                }.apply()
                Toast.makeText(this, "The choice has been saved", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("Shared1", Context.MODE_PRIVATE)
        choice = sharedPreferences.getInt("One", 10)

        if (choice != 10 ){
            decide(choice)
            Toast.makeText(this, "Resuming the choice that was saved", Toast.LENGTH_SHORT).show()
        }
    }
}