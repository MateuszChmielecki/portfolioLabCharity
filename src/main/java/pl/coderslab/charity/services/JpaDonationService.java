package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class JpaDonationService implements DonationService{
    private final DonationRepository donationRepository;

    public JpaDonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Optional<Donation> findById(Long id) {
        return donationRepository.findById(id);
    }

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void delete(Long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public void update(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public Long findQuantityBagsOfDonation() {
        return donationRepository.findQuantityBagsOfDonation();
    }

    @Override
    public Long findQuantityOfDonation() {
        return donationRepository.findQuantityOfDonation();
    }


}
