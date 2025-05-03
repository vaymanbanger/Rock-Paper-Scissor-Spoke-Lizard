package com.example.rockpaperscissors

import BattleOptions
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.rockpaperscissors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val battleLogic : BattleLogic = BattleLogic()
    var userChoice : BattleOptions = BattleOptions.NONE
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
            binding.lizardButton.id -> BattleOptions.LIZARD
            binding.rockButton.id -> BattleOptions.ROCK
            binding.paperButton.id -> BattleOptions.PAPER
            binding.spockButton.id -> BattleOptions.SPOCK
            binding.scissorsButton.id -> BattleOptions.SCISSORS
            else -> BattleOptions.NONE
        }
    }

    public fun startGame(control : View){
        if (userChoice == BattleOptions.NONE){
            binding.tvGameResult.text = "Сделайте свой выбор"
            return
        }
        val botChoice = battleLogic.generateAiSelection()
        val result = battleLogic.determineTheWinner(userChoice, botChoice)
        binding.tvPayerChoice.text = "Вы выбрали $userChoice"
        binding.tvBotChoice.text = "$botChoice выбрал противник"
        binding.tvGameResult.text = when(result){
            1 -> "Вы выиграли"
            0 -> "Ничья"
            -1 -> "Вы проиграли"
            else -> "Программная ошибка"
        }
    }
}