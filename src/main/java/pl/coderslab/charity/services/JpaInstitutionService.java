package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import java.util.List;
import java.util.Optional;

@Service
public class JpaInstitutionService implements InstitutionService{
    private final InstitutionRepository institutionRepository;

    public JpaInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Optional<Institution> findById(Long id) {
        return institutionRepository.findById(id);
    }

    @Override
    public void save(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public void delete(Long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public void update(Institution institution) {
        institutionRepository.save(institution);
    }
}
