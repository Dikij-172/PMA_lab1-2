import java.time.LocalDate

data class Cinema(
    val name: String,
    val address: String,
    val launchDate: LocalDate,
    val numOfSeats: Int,
    val numOfScreens: Int,
    val soundTechnology: String,
    val is3DAvailable: Boolean,
    val movies: List<Movie>
) : Comparable<Cinema> {
    override fun compareTo(cinema: Cinema): Int {
        val compare = name.compareTo(cinema.name)
        return if (compare != 0) compare else address.compareTo(cinema.address)
    }
}