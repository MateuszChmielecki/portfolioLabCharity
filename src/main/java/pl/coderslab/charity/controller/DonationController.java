package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.validation.AddressValidationGroup;
import pl.coderslab.charity.validation.CategoryValidationGroup;
import pl.coderslab.charity.validation.InstitutionValidationGroup;
import pl.coderslab.charity.validation.QuantityValidationGroup;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Controller
public class DonationController {
    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;

    public DonationController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @GetMapping("/form1")
    public String form1(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("donation", new Donation());
        return "form1";
    }

    @PostMapping("/form1")
    public String form1Post(HttpSession session, @Validated({CategoryValidationGroup.class}) Donation donation, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/form1#maincontent";
        }
        session.setAttribute("categories", donation.getCategories());
        return "redirect:/form2#maincontent";
    }
    @GetMapping("/form2")
    public String form2(Model model){
        model.addAttribute("donation", new Donation());
        return "form2";
    }
    @PostMapping("/form2")
    public String form2Post(HttpSession session, @Validated({QuantityValidationGroup.class}) Donation donation, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/form2#maincontent";
        }
        session.setAttribute("quantity", donation.getQuantity());
        return "redirect:/form3#maincontent";
    }
    @GetMapping("/form3")
    public String form3(Model model){

        model.addAttribute("institutions", institutionService.findAll());
        return "form3";
    }
    @PostMapping("/form3")
    public String form3Post(Model model, HttpSession session, @Validated({InstitutionValidationGroup.class}) Donation donation,BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/form3#maincontent";
        }
        session.setAttribute("institutions", donation.getInstitution());
        return "redirect:/form4#maincontent";
    }
    @GetMapping("/form4")
    public String form4(Model model){
        model.addAttribute("donation", new Donation());
        return "form4";
    }

    @PostMapping("/form4")
    public String form4Post(Model model, HttpSession session, @Validated({AddressValidationGroup.class}) Donation donation, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/form4#maincontent";
        }
        session.setAttribute("street", donation.getStreet());
        session.setAttribute("city", donation.getCity());
        session.setAttribute("zipCode", donation.getZipCode());
        session.setAttribute("pickUpDate", donation.getPickUpDate());
        session.setAttribute("pickUpTime", donation.getPickUpTime());
        session.setAttribute("pickUpComment", donation.getPickUpComment());
        return "redirect:/form5#maincontent";
    }
    @GetMapping("/form5")
    public String form5(Model model, HttpSession session, Donation donation){
//            List<Category> categories = new ArrayList<>();
//            categories.addAll((Collection<? extends Category>) session.getAttribute("categories"));
            donation.setCategories((List<Category>) session.getAttribute("categories"));
            donation.setQuantity((Integer) session.getAttribute("quantity"));
            donation.setInstitution((Institution) session.getAttribute("institutions"));
            donation.setStreet((String) session.getAttribute("street"));
            donation.setCity((String) session.getAttribute("city"));
            donation.setZipCode((String) session.getAttribute("zipCode"));
            donation.setPickUpDate((LocalDate) session.getAttribute("pickUpDate"));
            donation.setPickUpTime((LocalTime) session.getAttribute("pickUpTime"));
            donation.setPickUpComment((String) session.getAttribute("pickUpComment"));
            model.addAttribute("donation", donation);
            session.setAttribute("doantion",donation);
            return "form5";
    }
    @PostMapping("/form5")
    public String form5Post(HttpSession session){
        donationService.save((Donation) session.getAttribute("doantion"));
        session.invalidate();
        return "redirect:/";
    }
}
