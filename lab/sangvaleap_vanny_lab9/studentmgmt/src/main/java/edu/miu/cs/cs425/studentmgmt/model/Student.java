package edu.miu.cs.cs425.studentmgmt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @NotBlank(message = "Student number cannot be blank")
    private String studentNumber;
    @NotBlank(message = "Firstname cannot be blank")
    private String firstName;
    private String middleName;
    @NotBlank(message = "LastName cannot be blank")
    private String lastName;
    private double cgpa;
    @Temporal(TemporalType.DATE)
    private Date dateOfEnrollment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Transcript> transcripts = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Student(@NotBlank(message = "Student number cannot be blank") String studentNumber,
            @NotBlank(message = "Firstname cannot be blank") String firstName, String middleName,
            @NotBlank(message = "LastName cannot be blank") String lastName, double cgpa,
            Date dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public void addTranscript(Transcript transcript) {
        this.transcripts.add(transcript);
    }

}
