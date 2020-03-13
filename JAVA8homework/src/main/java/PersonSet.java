import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSet {
    private List<MasterNumber> masterNumbers;

    private List<Address> addresses;

    private List<Telephone> telephones;

    private List<Email> emails;

    public PersonSet(List<MasterNumber> masterNumbers,
                     List<Telephone> telephones,
                     List<Address> addresses,
                     List<Email> emails) {
        this.masterNumbers = masterNumbers;
        this.addresses = addresses;
        this.telephones = telephones;
        this.emails = emails;
    }

    public Stream<Person> groupToPeople() {
        // TODO: group the data to Stream<Person>
        // Can use Collectors.groupingBy method
        // Can add helper method
//        // Plan A:
//        Map<String, List<Address>> addressMap = addresses.stream().collect(Collectors.groupingBy(Address::getMasterNumber));
//        List<Address> nullAddress = new ArrayList<>();
//        nullAddress.add(null);

        Map<String, List<Email>> emailsMap = emails.stream().collect(Collectors.groupingBy(Email::getMasterNumber));
        Map<String, Address> addressMap = addresses.stream().collect(Collectors.toMap(Address::getMasterNumber, ele -> ele));
        Map<String, List<Telephone>> telephonesMap = telephones.stream().collect(Collectors.groupingBy(Telephone::getMasterNumber));

        return masterNumbers.stream().map(MasterNumber::getNumber)
                .map(masterNumber -> new Person(masterNumber,
                        telephonesMap.getOrDefault(masterNumber, new ArrayList<>()),
                        addressMap.getOrDefault(masterNumber, null),
                        emailsMap.getOrDefault(masterNumber, new ArrayList<>())));
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setMasterNumbers(List<MasterNumber> masterNumbers) {
        this.masterNumbers = masterNumbers;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }
}
