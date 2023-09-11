package net.mcoto.app.services.impl;

import net.mcoto.app.entities.BusSchedule;
import net.mcoto.app.entities.Costumer;
import net.mcoto.app.entities.Reservation;
import net.mcoto.app.model_response.ReservationApiException;
import net.mcoto.app.repositories.BusScheduleRepository;
import net.mcoto.app.repositories.CostumerRepository;
import net.mcoto.app.repositories.ReservationRepository;
import net.mcoto.app.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CostumerRepository costumerRepository;
    private final BusScheduleRepository busScheduleRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, CostumerRepository costumerRepository, BusScheduleRepository busScheduleRepository) {
        this.reservationRepository = reservationRepository;
        this.costumerRepository = costumerRepository;
        this.busScheduleRepository = busScheduleRepository;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        final Costumer costumer;
        final boolean doesCostumerExist = costumerRepository.existsByMobileOrEmail(reservation.getCostumer().getMobile(), reservation.getCostumer().getEmail());
        if (doesCostumerExist) {
            costumer = costumerRepository.findByMobileOrEmail(reservation.getCostumer().getMobile(), reservation.getCostumer().getEmail()).orElseThrow();
        } else {
            costumer = costumerRepository.save(reservation.getCostumer());
        }
        reservation.setCostumer(costumer);
        return reservationRepository.save(reservation);

    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationByScheduleAndDepartureDate(Long schedule_id, String departureDate) {
        final BusSchedule busSchedule = busScheduleRepository.findById(schedule_id).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Schedule not found"));
        return reservationRepository.findByBusScheduleAndDepartureDate(busSchedule, departureDate).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "No reservation found"));
    }

    @Override
    public List<Reservation> getReservationByMobile(String mobile) {
        final Costumer costumer = costumerRepository.findByMobile(mobile).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Costumer mobile not found"));
        return reservationRepository.findByCostumer(costumer).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "No reservation found"));
    }
}
