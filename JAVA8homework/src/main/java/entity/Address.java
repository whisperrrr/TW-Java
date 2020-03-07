package entity;

import java.util.Objects;

public class Address {

    private String masterNumber;

    private String country;

    private String city;

    private String street;

    // 添加的
    public String getMasterNumber() {
        return masterNumber;
    }
    // 添加的
    public String getCity() {
        return city;
    }
    // 添加的
    public String getStreet() {
        return street;
    }

    public Address(String masterNumber, String country, String city, String street) {
        this.masterNumber = masterNumber;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public void setMasterNumber(String masterNumber) {
        this.masterNumber = masterNumber;
    }

    // 新添加
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(masterNumber, address.masterNumber) &&
                Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterNumber, country, city, street);
    }
}


