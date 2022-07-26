package pl.coderslab.charity.services;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import java.util.List;
import java.util.Optional;

@Component
public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    void save (Category category);
    void delete (Long id);
    void update (Category category);
}
