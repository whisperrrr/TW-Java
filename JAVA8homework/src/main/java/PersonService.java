import entity.MasterNumber;
import entity.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonService {

    private Map<List<String>, Optional<PersonSet>> people;

    public PersonService() {
        this.people = new HashMap<>();
        people.put(Arrays.asList("1"), Optional.of(PersonSetDataProvider.providePersonSetWithNumber1()));
        people.put(Arrays.asList("1", "2"), Optional.of(PersonSetDataProvider.providePersonSetWithNumber1And2()));
    }

    public Stream<Person> getPersonByMasterNumbers(List<MasterNumber> numbers) {
        //TODO: Add the code to return people by numbers
        // Use groupToPeople() method
        List<String> personList = numbers.stream()
                .map(MasterNumber::getNumber)
                .collect(Collectors.toList());

        if (people.containsKey(personList)) {
            return people.get(personList).get().groupToPeople();
        }
        return Stream.empty();

//        原方法：用List<MasterNumber> 直接做(稍麻烦)
//        List<List<String>> validedKey = people.keySet().stream()
//                .filter(ele -> isEqual(ele, numbers))
//                .collect(Collectors.toList());
//
//        if (validedKey.size() != 0) {
//           return people.get(validedKey.get(0)).get().groupToPeople();
//        }
//        return Stream.empty();
    }
}

//    // 新添加，判断key值和需求list是否相等
//    // 转成stream流进行排序然后转成字符串进行比较
//    public boolean isEqual(List<String> keys, List<MasterNumber> numbers) {
//        return numbers.stream()
//                .map(MasterNumber::getNumber).sorted().collect(Collectors.joining())
//                .equals(keys.stream().sorted().collect(Collectors.joining()));
//    }
//}
