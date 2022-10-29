package edu.miu.cs.cs425.fairfieldlibrarywebapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libraryMemberId;
    @NotBlank(message = "Member number cannot be blank")
    @Column(unique = true)
    private String memberNumber;
    @NotBlank(message = "Firstname cannot be blank")
    private String firstname;
    @NotBlank(message = "Lastname cannot be blank")
    private String lastname;
    @NotBlank(message = "Phone cannot be blank")
    private String phone;
    @OneToOne
    private Address address;

    @ManyToOne
    @JoinColumn(name = "libraryMemberTypeId")
    private LibraryMemberType libraryMemberType;
}
