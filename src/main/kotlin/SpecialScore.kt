enum class SpecialScore(val score: Int, val displayName: String) {
    LOVE(0, "Love"),
    FIFTEEN(1, "Fifteen"),
    THIRTY(2, "Thirty"),
    FORTY(3, "Forty");

    companion object {
        fun getScore(score: Int): SpecialScore {
            return values().first { it.score == score }
        }
    }
}