package net.mcoto.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @OneToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    @OneToOne()
    @JoinColumn(name = "schedule_id")
    private BusSchedule busSchedule;
    private int timestamp;
    private String departureDate;
    private int totalSeatBooked;
    private String seatNumbers;
    private String reservationStatus;
    private int totalPrice;

}
