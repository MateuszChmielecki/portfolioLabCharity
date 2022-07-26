package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;


@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;

    public HomeController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institution",institutionService.findAll());
        model.addAttribute("quantityBagsDonation", donationService.findQuantityBagsOfDonation());
        model.addAttribute("quantityOfDonation", donationService.findQuantityOfDonation());
        return "index";
    }
}
