package com.example.rockpaperscissors

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

        fun getRussianName(choice: BattleOptions): String {
            return when(choice) {
                BattleOptions.ROCK -> "Камень"
                BattleOptions.PAPER -> "Бумага"
                BattleOptions.SCISSORS -> "Ножницы"
                BattleOptions.LIZARD -> "Ящерица"
                BattleOptions.SPOCK -> "Спок"
                else -> "Неизвестно"
            }
        }

        binding.tvPayerChoice.text = "Вы выбрали ${getRussianName(userChoice)}"
        binding.tvBotChoice.text = "Он выбрал ${getRussianName(botChoice)}"
        binding.tvGameResult.text = when(result){
            1 -> "Вы выиграли"
            0 -> "Ничья"
            -1 -> "Вы проиграли"
            else -> "Программная ошибка"
        }

        binding.ivPlayerChoice.setImageResource(getDrawableResId(userChoice))
        binding.ivBotChoice.setImageResource(getDrawableResId(botChoice))
    }

    private fun getDrawableResId(choice: BattleOptions): Int {
        return when(choice) {
            BattleOptions.ROCK -> R.drawable.rock
            BattleOptions.PAPER -> R.drawable.paper
            BattleOptions.SCISSORS -> R.drawable.scissors
            BattleOptions.LIZARD -> R.drawable.lizard
            BattleOptions.SPOCK -> R.drawable.spock
            else -> R.drawable.ic_launcher_background
        }
    }
}