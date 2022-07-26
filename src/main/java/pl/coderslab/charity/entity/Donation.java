package pl.coderslab.charity.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.validation.AddressValidationGroup;
import pl.coderslab.charity.validation.CategoryValidationGroup;
import pl.coderslab.charity.validation.InstitutionValidationGroup;
import pl.coderslab.charity.validation.QuantityValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(groups = {QuantityValidationGroup.class})
    private Integer quantity;
    @ManyToMany
    @NotEmpty(groups = {CategoryValidationGroup.class})
    private List<Category> categories;
    @ManyToOne
    @NotNull(groups = {InstitutionValidationGroup.class})
    private Institution institution;
    @NotBlank(groups = {AddressValidationGroup.class})
    private String street;
    @NotBlank(groups = {AddressValidationGroup.class})
    private String city;
    @Length(max = 6)
    @NotBlank(groups = {AddressValidationGroup.class})
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(groups = {AddressValidationGroup.class})
    private LocalDate pickUpDate;
    @NotNull(groups = {AddressValidationGroup.class})
    private LocalTime pickUpTime;
    private String pickUpComment;

    public Donation() {
    }

    public Donation(Integer quantity, List<Category> categories, Institution institution, String street, String city, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime) {
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }
}
