package com.nikola.sms_03.service;

import com.nikola.sms_03.example.Person;
import com.nikola.sms_03.example.PersonDB;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Nikola Karlikova on 28.03.2018.
 */
public class PersonService {
    List<Person> personList = PersonDB.getInstance();

    public List<Person> getAllPersons(){
        return personList;
    }

    public List<Person> searchPersonByName(String name){
        Comparator<Person> groupByNameSurname = Comparator.comparing(Person::getName).thenComparing(Person::getSurname);

        List<Person> result = personList.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name) || e.getSurname().equalsIgnoreCase(name))
                .sorted(groupByNameSurname)
                .collect(Collectors.toList());
        return result;
    }

    public Person getPerson(long id) throws Exception {
        Optional<Person> match
                = personList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The Employee id " + id + " not found");
        }
    }

}
