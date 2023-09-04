package net.mcoto.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Long reservationId;
    private Costumer costumer;
    private BusSchedule busSchedule;
    private int timestamp;
    private String departureDate;
    private int totalSeatBooked;
    private String seatNumbers;
    private String reservationStatus;
    private int totalPrice;
    
}
