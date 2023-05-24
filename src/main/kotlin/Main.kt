import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.time.LocalDate

fun main() {
    val context = AnnotationConfigApplicationContext(AppConfig::class.java)
    val cinemaContainer = context.getBean(Container::class.java) as CinemaContainer

    val movies = listOf(
        Movie("Плем'я", "Ukraine", "Гармата фільм", 132, 16.3, LocalDate.of(2014, 5, 21), false),
        Movie(
            "Земля блакитна, ніби апельсин",
            "Ukraine",
            "Альбатрос Комунікос",
            74,
            5.65,
            LocalDate.of(2020, 1, 24),
            false
        ),
        Movie("Памфір", "Ukraine", "-", 102, 39.8, LocalDate.of(2022, 12, 30), false),
    )

    cinemaContainer.add(
        Cinema(
            "Multiplex",
            "Кільцева дорога, 1, Київ",
            LocalDate.of(2015, 1, 1),
            600,
            5,
            "Dolby Atmos",
            true,
            movies
        ),
    )

    cinemaContainer.add(
        Cinema(
            "Miromax",
            "Михайла Гришка, 3А, Київ",
            LocalDate.of(2014, 1, 1),
            300,
            4,
            "Dolby Atmos",
            true,
            movies
        ),
    )
}