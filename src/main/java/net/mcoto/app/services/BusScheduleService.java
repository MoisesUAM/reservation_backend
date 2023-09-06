package net.mcoto.app.services;

import net.mcoto.app.entities.BusSchedule;

import java.util.List;

public interface BusScheduleService {

    BusSchedule addBusSchedule(BusSchedule busSchedule);
    List<BusSchedule> getAllBusSchedules();
    List<BusSchedule> getSchedulesByRoute(String routeName);

}
