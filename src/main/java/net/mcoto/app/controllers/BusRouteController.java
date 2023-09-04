package net.mcoto.app.controllers;

import net.mcoto.app.entities.BusRoute;
import net.mcoto.app.model_response.ResponseModel;
import net.mcoto.app.services.BusRouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus_route")
public class BusRouteController {

    final private BusRouteService service;

    public BusRouteController(BusRouteService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseModel<BusRoute> addBusRoute(@RequestBody BusRoute busRoute) {
        final BusRoute savedBusRoute = service.addBusRoute(busRoute);
        return new ResponseModel<>(HttpStatus.OK.value(), "BusRoute added successfully.", savedBusRoute);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusRoute>> getAllBusRoute() {
        return  ResponseEntity.ok(service.getAllBusRoutes());
    }


    @GetMapping("/route_name/{routeName}")
    public ResponseEntity<BusRoute> getRouteByRouteName(@PathVariable String routeName) {
        return ResponseEntity.ok(service.getRouteByRouteName(routeName));
    }

    @GetMapping("/query")
    public ResponseEntity<BusRoute> getRouteByCityFromAndCityTo(
            @RequestParam String cityFrom,
            @RequestParam String cityTo) {
        return ResponseEntity.ok(service.getRouteByCityFromAndCityTo(cityFrom, cityTo));
    }


}
