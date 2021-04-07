package com.pibox.knwh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wh_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Company name is required")
    private String title;

    @NotBlank(message = "Country name is required")
    private String country;

    @NotBlank(message = "City name is required")
    private String city;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Zip Code is required")
    @Size(min = 5, max = 8, message = "Please use 5 to 8 characters")
    private String zipCode;

    @NotBlank(message = "Phone number is required")
    @Size(min = 8, max = 15, message = "Please use 8 to 15 numbers")
    private String phoneNumber;

    @Email
    private String email;

    @NotBlank(message = "VAT number is required")
    @Size(min = 8, max = 15, message = "Please use 8 to 15 characters")
    private String vatNumber;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date updatedAt;

    public Company(@NotBlank String title, @NotBlank String country, @NotBlank String city, @NotBlank String address,
                   @NotBlank String zipCode, @NotBlank String phoneNumber, @Email String email, @NotBlank String vatNumber) {
        this.title = title;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vatNumber = vatNumber;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
