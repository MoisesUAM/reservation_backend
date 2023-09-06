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
@Table(name = "tbl_bus_schedule")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @OneToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
    @OneToOne
    @JoinColumn(name = "route_id")
    private BusRoute busRoute;
    private String departureTime;
    private int ticketPrice;
    private int discount;
    private int processingFee;
}
