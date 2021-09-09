package com.example.demo.dao;

import com.example.demo.model.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressDao {

    int insertAddress(Address address);

    List<Address> selectAllAddresses();

    Optional<Address> selectAddressById(UUID id);

    int deleteAddressById(UUID id);

    int updateAddressById(UUID id, Address address);

}
