package edu.miu.cs.cs425.eregistrar.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotBlank(message = "Student number cannot be blank")
    private String studentNumber;
    @NotBlank(message = "Firstname cannot be blank")
    private String firstName;
    private String middleName;
    @NotBlank(message = "LastName cannot be blank")
    private String lastName;
    private Double cgpa;
    // @Temporal(TemporalType.DATE)
    // private LocalDate dateOfEnrollment;
    private String dateOfEnrollment;

    private String isInternational;

}
