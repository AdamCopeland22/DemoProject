package com.example.demo.dao;

import com.example.demo.model.Address;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeAddressDao")
public class FakeAddressDataAccessServieced implements AddressDao{

    private static List<Address> DB = new ArrayList<>();

    @Override
    public int insertAddress(Address address) {
        DB.add(new Address(address.getId(), address.getStreet(), address.getCity(), address.getState(), address.getPostalCode()));
        return 1;
    }

    @Override
    public List<Address> selectAllAddresses() {
        return DB;
    }

    @Override
    public Optional<Address> selectAddressById(UUID id) {
        return DB.stream().filter(address -> address.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteAddressById(UUID id) {
        Optional<Address> addressToDelete = selectAddressById(id);
        if (addressToDelete.isPresent()) {
            DB.remove(addressToDelete.get());
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public int updateAddressById(UUID id, Address address) {
        return selectAddressById(id).map(a -> {
            int indexOfAddressToUpdate = DB.indexOf(a);
            if(indexOfAddressToUpdate >= 0){
                DB.set(indexOfAddressToUpdate,  new Address(id, address.getStreet(), address.getCity(), address.getState(), address.getPostalCode()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
