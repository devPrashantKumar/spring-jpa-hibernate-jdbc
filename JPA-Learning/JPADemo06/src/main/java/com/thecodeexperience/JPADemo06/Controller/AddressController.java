package com.thecodeexperience.JPADemo06.Controller;

import com.thecodeexperience.JPADemo06.Entity.Address;
import com.thecodeexperience.JPADemo06.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // ✅ Create a new address with address
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.updateAddress(address));
    }

    // ✅ Get all addresss
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresss() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    // ✅ Get a single address by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Delete a address
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
