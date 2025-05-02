package com.example.rockpaperscissors

import GameItems
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.rockpaperscissors.databinding.ActivityMainBinding

class ЧЁMainActivity : AppCompatActivity() {
    val game : Game = Game()
    var userChoice : GameItems = GameItems.NONE
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvPayerChoice.setTextColor(ContextCompat.getColor(this, R.color.user_choice))
        binding.tvBotChoice.setTextColor(ContextCompat.getColor(this, R.color.bot_choice))
    }

    public fun setUserChoice(control : View){
        userChoice = when(control.id){
            binding.lizardButton.id -> GameItems.LIZARD
            binding.rockButton.id -> GameItems.ROCK
            binding.paperButton.id -> GameItems.PAPER
            binding.spockButton.id -> GameItems.SPOCK
            binding.scissorsButton.id -> GameItems.SCISSORS
            else -> GameItems.NONE
        }
    }

    public fun startGame(control : View){
        if (userChoice == GameItems.NONE){
            binding.tvGameResult.text = "Сделайте свой выбор"
            return
        }
        val botChoice = game.getItemForBot()
        val result = game.determineTheWinner(userChoice, botChoice)
        binding.tvPayerChoice.text = "Вы выбрали $userChoice"
        binding.tvBotChoice.text = "$botChoice выбрал противник"
        binding.tvGameResult.text = when(result){
            1 -> "Вы выйграли"
            0 -> "Ничья"
            -1 -> "Вы проиграли"
            else -> "Программная ошибка"
        }
    }
}