package com.example.rockpaperscissors

import GameItems
import android.view.View
import compareChoices
import kotlin.random.Random

public class Game {

    public fun determineTheWinner(UseItem : GameItems, BotItem : GameItems)  : Int{
        return compareChoices(UseItem, BotItem)
    }

    public fun getItemForBot() : GameItems{
        var result  = Random.nextInt(0, 5)
        return getItemByNumber(result)
    }

    public fun getItemByNumber(Number: Int) : GameItems{
        return when (Number){
            0 -> GameItems.ROCK
            1 -> GameItems.PAPER
            2 -> GameItems.SCISSORS
            3 -> GameItems.LIZARD
            4 -> GameItems.SPOCK
            else -> GameItems.NONE
        }
    }
}