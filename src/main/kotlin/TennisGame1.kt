class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName == "player1")
            player1Score += 1
        else
            player2Score += 1
    }

    enum class Score(val score: Int, val displayName: String) {
        LOVE(0, "Love"),
        FIFTEEN(1, "Fifteen"),
        THIRTY(2, "Thirty"),
        FORTY(3, "Forty");

        companion object {
            fun getScore(score: Int): Score {
                return values().first { it.score == score }
            }
        }
    }

    companion object {
        const val DEUCE = "Deuce"
        const val ADVANTAGE_PLAYER_1 = "Advantage player1"
        const val ADVANTAGE_PLAYER_2 = "Advantage player2"
        const val WIN_FOR_PLAYER_1 = "Win for player1"
        const val WIN_FOR_PLAYER_2 = "Win for player2"
    }

    private fun checkDeuce(score1: Int, score2: Int): Boolean {
        if (score1 < 3 || score2 < 3) return false

        return score1 == score2
    }

    override fun getScore(): String {
        if (checkDeuce(player1Score, player2Score)) {
            return DEUCE
        }

        val isNotCheckPoint = player1Score < 4 && player2Score < 4
        if (isNotCheckPoint) {
            return getNotCheckPointScore(player1Score, player2Score)
        }
        return getResultScore(player1Score, player2Score)
    }

    private fun getNotCheckPointScore(score1: Int, score2: Int): String {
        val score1 = Score.getScore(score1)
        val score2 = Score.getScore(score2)
        return score1.displayName + "-" +
            if (score1 == score2) "All" else score2.displayName
    }

    private fun getResultScore(score1: Int, score2: Int): String {
        val minusResult = score1 - score2

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
}
