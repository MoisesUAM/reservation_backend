package net.mcoto.app.controllers;

import net.mcoto.app.entities.Bus;
import net.mcoto.app.model_response.ResponseModel;
import net.mcoto.app.services.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    private final BusService service;

    public BusController(BusService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseModel<Bus> addBus(@RequestBody Bus bus) {
        final Bus savedBus = service.addBus(bus);
        return new ResponseModel<>(HttpStatus.OK.value(), "Bus added successfully.", savedBus);
    }

    @GetMapping("/getAllBus")
    public ResponseEntity<List<Bus>> getAllBus() {
        return ResponseEntity.ok(service.getAllBus());
    }
}
