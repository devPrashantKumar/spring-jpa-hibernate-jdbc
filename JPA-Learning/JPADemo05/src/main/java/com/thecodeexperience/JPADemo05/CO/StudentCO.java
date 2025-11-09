package com.thecodeexperience.JPADemo05.CO;

import com.thecodeexperience.JPADemo05.Entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentCO {
    private Long id;
    private String name;
    private String email;
    private List<AddressCOWithoutStudent> addresses;
}
