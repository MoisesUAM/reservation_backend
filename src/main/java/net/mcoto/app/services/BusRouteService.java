package net.mcoto.app.services;

import net.mcoto.app.entities.BusRoute;

import java.util.List;

public interface BusRouteService {

    BusRoute addBusRoute(BusRoute busRoute);
    List<BusRoute> getAllBusRoutes();
    BusRoute getRouteByRouteName(String routeName);
    BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo);
}
