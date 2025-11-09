package com.thecodeexperience.JPADemo04.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Unidirectional OneToOne mapping

    //@JsonManagedReference
    // by default orphan removal is false
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "address_fk", referencedColumnName = "id")
    private List<Address> addresses;
}
