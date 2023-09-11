package net.mcoto.app.repositories;

import net.mcoto.app.entities.BusSchedule;
import net.mcoto.app.entities.Costumer;
import net.mcoto.app.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<List<Reservation>> findByCostumer(Costumer costumer);

    Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule, String departureDate);
}
