package net.mcoto.app.services.impl;

import net.mcoto.app.entities.Bus;
import net.mcoto.app.repositories.BusRepository;
import net.mcoto.app.services.BusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository repository;

    public BusServiceImpl(BusRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bus addBus(Bus bus) {
        return repository.save(bus);
    }

    @Override
    public List<Bus> getAllBus() {
        return repository.findAll();
    }
}
