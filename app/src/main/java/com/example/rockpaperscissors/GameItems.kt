public enum class GameItems {
    ROCK {
        override val defeats: List<GameItems>
            get() = listOf(SCISSORS, LIZARD)
    },
    PAPER {
        override val defeats: List<GameItems>
            get() = listOf(ROCK, SPOCK)
    },
    SCISSORS {
        override val defeats: List<GameItems>
            get() = listOf(PAPER, LIZARD)
    },
    LIZARD {
        override val defeats: List<GameItems>
            get() = listOf(PAPER, SPOCK)
    },
    SPOCK {
        override val defeats: List<GameItems>
            get() = listOf(SCISSORS, ROCK)
    },

    NONE {
        override val defeats: List<GameItems>
            get() = listOf()
    };

    abstract val defeats: List<GameItems>
}

public fun compareChoices(userChoice: GameItems, botChoice: GameItems): Int {
    return when {
        userChoice == botChoice -> 0
        botChoice in userChoice.defeats -> 1
        else -> -1
    }
}