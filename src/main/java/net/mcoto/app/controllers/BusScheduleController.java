package net.mcoto.app.controllers;

import net.mcoto.app.entities.BusSchedule;
import net.mcoto.app.model_response.ResponseModel;
import net.mcoto.app.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus_schedule")
public class BusScheduleController {

    private final BusScheduleService service;

    @Autowired
    public BusScheduleController(BusScheduleService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseModel<BusSchedule> addBusSchedule(@RequestBody BusSchedule busSchedule) {
        final BusSchedule savedBusSchedule = service.addBusSchedule(busSchedule);
        return new ResponseModel<>(HttpStatus.OK.value(), "BusSchedule added successfully.", savedBusSchedule);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> getAllBusSchedule() {
        return ResponseEntity.ok(service.getAllBusSchedules());
    }

    @GetMapping("/{routName}")
    public ResponseEntity<List<BusSchedule>> getBusScheduleByRouteName(@PathVariable String routName) {
        return ResponseEntity.ok(service.getSchedulesByRoute(routName));
    }

}
