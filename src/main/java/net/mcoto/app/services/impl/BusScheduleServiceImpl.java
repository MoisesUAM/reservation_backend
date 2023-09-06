package net.mcoto.app.services.impl;

import net.mcoto.app.entities.BusRoute;
import net.mcoto.app.entities.BusSchedule;
import net.mcoto.app.model_response.ReservationApiException;
import net.mcoto.app.repositories.BusRouteRepository;
import net.mcoto.app.repositories.BusScheduleRepository;
import net.mcoto.app.services.BusScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleServiceImpl implements BusScheduleService
{
    final private BusScheduleRepository busScheduleRepository;
    final private BusRouteRepository busRouteRepository;


    public BusScheduleServiceImpl(BusScheduleRepository busScheduleRepository, BusRouteRepository busRouteRepository) {
        this.busScheduleRepository = busScheduleRepository;
        this.busRouteRepository = busRouteRepository;
    }

    @Override
    public BusSchedule addBusSchedule(BusSchedule busSchedule) throws ReservationApiException{
       final boolean routeScheduleExist =   busScheduleRepository.
                                          existsByBusAndBusRouteAndDepartureTime(
                                                  busSchedule.getBus(),
                                                  busSchedule.getBusRoute(),
                                                  busSchedule.getDepartureTime());
       if (routeScheduleExist) {
           throw new ReservationApiException(HttpStatus.CONFLICT,"This Schedule is Already exists");
       }
        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> getAllBusSchedules() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getSchedulesByRoute(String routeName) {
        final BusRoute busRoute = busRouteRepository.findByRouteName(routeName).orElseThrow(() -> new ReservationApiException(HttpStatus.NOT_FOUND, "Route not found"));
        return busScheduleRepository.findByBusRoute(busRoute).orElseThrow(() -> new ReservationApiException(HttpStatus.NOT_FOUND, "Schedule not found"));
    }
}
