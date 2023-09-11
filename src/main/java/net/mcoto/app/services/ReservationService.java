package net.mcoto.app.services;

import net.mcoto.app.entities.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation addReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    List<Reservation> getReservationByScheduleAndDepartureDate(Long schedule_id, String departureDate);

    List<Reservation> getReservationByMobile(String mobile);
}
