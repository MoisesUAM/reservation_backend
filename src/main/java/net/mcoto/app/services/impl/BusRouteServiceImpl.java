package net.mcoto.app.services.impl;

import net.mcoto.app.entities.BusRoute;
import net.mcoto.app.model_response.ReservationApiException;
import net.mcoto.app.repositories.BusRouteRepository;
import net.mcoto.app.services.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    final private BusRouteRepository busRouteRepository;

    @Autowired
    public BusRouteServiceImpl(BusRouteRepository busRouteRepository) {
        this.busRouteRepository = busRouteRepository;
    }

    @Override
    public BusRoute addBusRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteByRouteName(String routeName) {
        return busRouteRepository.findByRouteName(routeName).orElseThrow(() ->
                new ReservationApiException(HttpStatus.BAD_REQUEST, "Route not found"));
    }

    @Override
    public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return busRouteRepository.findByCityFromAndAndCityTo(cityFrom, cityTo).orElseThrow(() ->
                new ReservationApiException(HttpStatus.BAD_REQUEST, "Route not found"));
    }
}
