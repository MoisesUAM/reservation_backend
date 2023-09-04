package net.mcoto.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusSchedule {
    private Long scheduleId;
    private Bus bus;
    private BusRoute busRoute;
    private String departureTime;
    private int ticketPrice;
    private int discount;
    private int processingFee;
}
