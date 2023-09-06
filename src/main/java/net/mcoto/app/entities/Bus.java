package net.mcoto.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id", nullable = false)
    private Long busId;
    @Column(name = "bus_name", nullable = false)
    private String busName;
    @Column(name = "bus_type", nullable = false)
    private String busType;
    @Column(name = "total_seat", nullable = false)
    private Integer totalSeat;
    @Column(name = "bus_number", nullable = false, unique = true)
    private String busNumber;

}
