package com.example.demo.api;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/address")
@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping
    public void addAdderess(@RequestBody Address address){
        addressService.addAddress(address);
    }

    @GetMapping
    public List<Address> getAllAddress(){
        return addressService.getAllAddresses();
    }

    @GetMapping(path = "{id}")
    public Address getAddressById(@PathVariable("id") UUID id){
        return addressService.getAddressById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAddressById(@PathVariable("id") UUID id){
        addressService.deleteAddress(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Address update){
        addressService.updateAddress(id,update);
    }
}
