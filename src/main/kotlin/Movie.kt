import java.time.LocalDate

data class Movie(
    val originalTitle: String,
    val country: String,
    val productionCompany: String,
    val runningTime: Int,
    val budget: Double,
    val releaseDate: LocalDate,
    val hasCertificate: Boolean
) : Comparable<Movie> {
    override fun compareTo(movie: Movie): Int {
        val compare = originalTitle.compareTo(movie.originalTitle)
        return if (compare != 0) compare else budget.compareTo(movie.budget) +
                country.compareTo(movie.country) +
                releaseDate.compareTo(movie.releaseDate)
    }
}