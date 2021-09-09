package com.example.demo.service;

import com.example.demo.dao.AddressDao;
import com.example.demo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressDao addressDao;

    @Autowired
    public AddressService(@Qualifier("fakeAddressDao") AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public int addAddress(Address address) {
        return addressDao.insertAddress(address);
    }

    public List<Address> getAllAddresses(){
        return addressDao.selectAllAddresses();
    }

    public Optional<Address> getAddressById(UUID id){
        return addressDao.selectAddressById(id);
    }

    public int deleteAddress(UUID id){
        return addressDao.deleteAddressById(id);
    }

    public int updateAddress(UUID id, Address update){
        return addressDao.updateAddressById(id, update);
    }
}
