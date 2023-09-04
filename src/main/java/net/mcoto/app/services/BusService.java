package net.mcoto.app.services;

import net.mcoto.app.entities.Bus;

import java.util.List;

public interface BusService {

    Bus addBus(Bus bus);

    List<Bus> getAllBus();
}
