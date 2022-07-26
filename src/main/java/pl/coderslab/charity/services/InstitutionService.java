package pl.coderslab.charity.services;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Institution;
import java.util.List;
import java.util.Optional;

@Component
public interface InstitutionService {
    List<Institution> findAll();
    Optional<Institution> findById(Long id);
    void save (Institution institution);
    void delete (Long id);
    void update (Institution institution);
}
