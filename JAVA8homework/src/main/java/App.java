import entity.MasterNumber;
import entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        //TODO: print Person data that masterNumber is 1 and 2
        // print Person data that masterNumber is 3
        Stream<Person> personStream1 = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("1"), new MasterNumber("2")));
        printPerson(personStream1);

        Stream<Person> personStream2 = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("3")));
        printPerson(personStream2);
    }

    public static void printPerson(Stream<Person> personStream) {
        List<Person> collect = personStream.collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println(" There's no Person Data in the database");
        } else {
            collect.forEach(System.out::println);
        }
    }

}
