package net.mcoto.app.repositories;

import net.mcoto.app.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    Optional<Costumer> findByMobileOrEmail(String mobile, String email);

    Optional<Costumer> findByMobile(String mobile);

    Optional<Costumer> findByEmail(String email);

    Boolean existsByMobile(String mobile);

    Boolean existsByEmail(String email);

    Boolean existsByMobileOrEmail(String mobile, String email);
}
