package net.mcoto.app.repositories;

import net.mcoto.app.entities.Bus;
import net.mcoto.app.entities.BusRoute;
import net.mcoto.app.entities.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long>
{
    Optional<List<BusSchedule>> findByBusRoute(BusRoute busRoute);
    Boolean existsByBusAndBusRouteAndDepartureTime(Bus bus, BusRoute busRoute, String departureTime);
}
