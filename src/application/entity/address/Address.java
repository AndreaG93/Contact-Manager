package application.entity.address;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class is used to represent an address.
 *
 * @author Andrea Graziani
 */
@SuppressWarnings("serial")
@Entity
@Table
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id", unique = true)
    private int id;

    @Column(name = "address_address")
    private String address;

    @Column(name = "address_postcode")
    private String postcode;

    @Column(name = "address_town")
    private String town;

    @Column(name = "address_province")
    private String province;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
