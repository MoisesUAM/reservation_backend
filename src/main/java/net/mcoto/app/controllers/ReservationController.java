package net.mcoto.app.controllers;

import net.mcoto.app.entities.Reservation;
import net.mcoto.app.model_response.ResponseModel;
import net.mcoto.app.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public ResponseModel<Reservation> addReservation(@RequestBody Reservation reservation) {
        final Reservation reservationAdded = reservationService.addReservation(reservation);
        return new ResponseModel<>(HttpStatus.OK.value(), "Reservation added successfully", reservationAdded);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/query")
    public ResponseEntity<List<Reservation>> getReservationsByScheduleAndDepartureDate(
            @RequestParam Long schedule_id,
            @RequestParam String departureDate
    ) {
        return ResponseEntity.ok(reservationService.getReservationByScheduleAndDepartureDate(schedule_id, departureDate));
    }

    @GetMapping("/all/{mobile}")
    public ResponseEntity<List<Reservation>> getReservationsByMobile(@PathVariable(name = "mobile") String mobile) {
        return ResponseEntity.ok(reservationService.getReservationByMobile(mobile));
    }

}
