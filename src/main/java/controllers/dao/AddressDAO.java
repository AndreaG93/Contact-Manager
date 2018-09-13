package controllers.dao;

import entity.address.Address;

public interface AddressDAO {

    int insert(Address obj);

    void delete(Address obj);

    void update(Address obj);

    Address get(int id);
}
