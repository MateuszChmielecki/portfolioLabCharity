package pl.coderslab.charity.services;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Donation;

import java.util.List;
import java.util.Optional;

@Component
public interface DonationService {
    List<Donation> findAll();
    Optional<Donation> findById(Long id);
    void save (Donation donation);
    void delete (Long id);
    void update (Donation donation);
    Long findQuantityBagsOfDonation();
    Long findQuantityOfDonation();
}
