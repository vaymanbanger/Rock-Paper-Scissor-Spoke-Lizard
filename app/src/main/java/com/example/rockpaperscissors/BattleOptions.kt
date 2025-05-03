public enum class BattleOptions {
    ROCK {
        override val winsAgainst: List<BattleOptions>
            get() = listOf(SCISSORS, LIZARD)
    },
    PAPER {
        override val winsAgainst: List<BattleOptions>
            get() = listOf(ROCK, SPOCK)
    },
    SCISSORS {
        override val winsAgainst: List<BattleOptions>
            get() = listOf(PAPER, LIZARD)
    },
    LIZARD {
        override val winsAgainst: List<BattleOptions>
            get() = listOf(PAPER, SPOCK)
    },
    SPOCK {
        override val winsAgainst: List<BattleOptions>
            get() = listOf(SCISSORS, ROCK)
    },

    NONE {
        override val winsAgainst: List<BattleOptions>
            get() = listOf()
    };

    abstract val winsAgainst: List<BattleOptions>
}

public fun compareChoices(userChoice: BattleOptions, botChoice: BattleOptions): Int {
    return when {
        userChoice == botChoice -> 0
        botChoice in userChoice.winsAgainst -> 1
        else -> -1
    }
}