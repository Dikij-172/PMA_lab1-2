package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.CinemaRequest
import ua.kpi.its.lab.rest.dto.CinemaResponse
import ua.kpi.its.lab.rest.entity.Cinema
import ua.kpi.its.lab.rest.repository.CinemaRepository
import ua.kpi.its.lab.rest.svc.CinemaService

@Service
class CinemaServiceImpl(private val cinemaRepository: CinemaRepository) : CinemaService {
    override fun createCinema(cinemaRequest: CinemaRequest): CinemaResponse {
        val cinema = Cinema(name = cinemaRequest.name, address = cinemaRequest.address, numOfSeats = cinemaRequest.numOfSeats)
        val savedCinema = cinemaRepository.save(cinema)
        return CinemaResponse.fromEntity(savedCinema)
    }

    override fun getCinemaById(id: Long): CinemaResponse {
        val cinema = cinemaRepository.findById(id).orElseThrow()
        return CinemaResponse.fromEntity(cinema)
    }

    override fun updateCinemaById(id: Long, cinemaRequest: CinemaRequest): CinemaResponse {
        val cinema = cinemaRepository.findById(id).orElseThrow()
        cinema.model = cinemaRequest.name
        cinema.manufacturer = cinemaRequest.address
        val updatedCinema = cinemaRepository.save(cinema)
        return CinemaResponse.fromEntity(updatedCinema)
    }

    override fun deleteCinemaById(id: Long): Boolean {
        cinemaRepository.deleteById(id)
        return true
    }
}