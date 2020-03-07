package entity;

import java.util.List;
import java.util.Optional;

public class Person {

  private String masterNumber;
  private Address address;

  private List<Telephone> telephones;

  private List<Email> emails;

  public Person() {
  }

  public Person(String masterNumber, List<Telephone> telephones, Address address,
                List<Email> emails) {
    this.masterNumber = masterNumber;
    this.address = address;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Optional<SimpleAddress> getSimpleAddress() {
    //TODO: return Optional<SimpleAddress>
    return null;
  }

  public Address getAddress() {
    return address;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }
}
