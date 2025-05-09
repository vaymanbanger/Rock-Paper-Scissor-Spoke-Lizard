package com.example.rockpaperscissors

import kotlin.random.Random

public class BattleLogic {

    public fun determineTheWinner(UseItem : BattleOptions, BotItem : BattleOptions)  : Int{
        return compareChoices(UseItem, BotItem)
    }

    fun generateAiSelection(): BattleOptions {
        val randomValue = Random.nextInt(0, 5)
        return when (randomValue) {
            0 -> BattleOptions.ROCK
            1 -> BattleOptions.PAPER
            2 -> BattleOptions.SCISSORS
            3 -> BattleOptions.LIZARD
            4 -> BattleOptions.SPOCK
            else -> BattleOptions.NONE
        }
    }
}