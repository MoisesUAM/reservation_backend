package net.mcoto.app.repositories;

import net.mcoto.app.entities.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {

    Optional<BusRoute> findByRouteName(String routeName);
    @SuppressWarnings("SpringDataMethodInconsistencyInspection")
    Optional<BusRoute> findByCityFromAndAndCityTo(String cityFrom, String cityTo);
}
