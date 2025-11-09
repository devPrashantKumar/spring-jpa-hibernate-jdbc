package com.thecodeexperience.JPADemo05.CO;

import com.thecodeexperience.JPADemo05.Entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddressCOWithoutStudent {
    private Long id;
    private String street;
    private String city;
    private String zipcode;
}
