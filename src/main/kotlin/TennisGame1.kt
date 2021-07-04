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

        fun getScore(score: Int): Score {
            return values().first { it.score == score }
        }
    }

    companion object {
        const val DEUCE = "Deuce"
        const val ADVANTAGE_PLAYER_1 = "Advantage player1"
        const val ADVANTAGE_PLAYER_2 = "Advantage player2"
        const val WIN_FOR_PLAYER_1 = "Win for player1"
        const val WIN_FOR_PLAYER_2 = "Win for player2"
    }

    override fun getScore(): String {

        var score = ""
        var tempScore = 0

        if (player1Score >= 4 || player2Score >= 4) {
            val minusResult = player1Score - player2Score
            score = when {
                minusResult == 0  -> {
                    DEUCE
                }
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
        } else {
            for (i in 1..2) {
                if (i == 1)
                    tempScore = player1Score
                else {
                    score += "-"
                    tempScore = player2Score
                }
                when (tempScore) {
                    0 -> score += "Love"
                    1 -> score += "Fifteen"
                    2 -> score += "Thirty"
                    3 -> score += "Forty"
                }
            }
        }
        return score
    }
}
