class NormalScore(
    player1: Player,
    player2: Player
) : Score(player1, player2) {
    override fun isAvailable(): Boolean {
        return true
    }

    override fun getScore(): String {
        val minusResult = player1.score - player2.score

        return when {
            minusResult == 1 -> {
                ADVANTAGE_PLAYER_1
            }
            minusResult == -1 -> {
                ADVANTAGE_PLAYER_2
            }
            minusResult >= 2 -> {
                WIN_FOR_PLAYER_1
            }
            else -> {
                WIN_FOR_PLAYER_2
            }
        }
    }

    companion object {
        const val ADVANTAGE_PLAYER_1 = "Advantage player1"
        const val ADVANTAGE_PLAYER_2 = "Advantage player2"
        const val WIN_FOR_PLAYER_1 = "Win for player1"
        const val WIN_FOR_PLAYER_2 = "Win for player2"
    }
}