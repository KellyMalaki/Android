package com.example.dinnerdecider2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dinnerdecider2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        lateinit var food: String
         var  imageToBeShown = 6
        binding.button.setOnClickListener {
        var choice: Int = Random.nextInt(0, 5)
            when(choice){
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
    }
}