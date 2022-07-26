package pl.coderslab.charity.controller;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {
    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;

    public DataController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @GetMapping("/data")
    public String data(){

        Institution dbamOZdrowie = new Institution("Dbam o Zdrowie", "Cel i misja: Pomoc dzieciom z ubogich rodzin.");
        institutionService.save(dbamOZdrowie);
        Institution aKogo = new Institution("A kogo", "Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki.");
        institutionService.save(aKogo);
        Institution dlaDzieci = new Institution("Dla dzieci", "Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.");
        institutionService.save(dlaDzieci);
        Institution bezDomu = new Institution("Bez domu", "Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania");
        institutionService.save(bezDomu);

        categoryService.save(new Category("zabawki"));
        categoryService.save(new Category("jedzenie"));
        categoryService.save(new Category("ubrania"));
        categoryService.save(new Category("książki"));
        categoryService.save(new Category("inne"));

        List <Category> cat1 = new ArrayList<>();
        cat1.add(new Category("zabawki"));
        cat1.add(new Category("ubrania"));

//        donationService.save((new Donation("Warszawa",cat1, dlaDzieci,"ulica", "Warszawa", "00-06", new LocalDate(2022,7,23), new LocalTime(12,30))));
        return "redirect:";
    }
}
