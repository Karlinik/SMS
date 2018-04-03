package com.nikola.sms_03.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikola Karlikova on 28.03.2018.
 */
public class PersonDB {
    private static List<Person> list = new ArrayList();

    public PersonDB(){}

    static{
        list.add(new Person("John","Smith","12-12-1980", Role.STUDENT,"Sales","john.smith@abc.com"));
        list.add(new Person("Laura","Adams","02-11-1979", Role.STUDENT,"IT","laura.adams@abc.com"));
        list.add(new Person("Peter","Williams","22-10-1966", Role.TEACHER,"HR","peter.williams@abc.com"));
        list.add(new Person("Joana","Sanders","11-11-1976", Role.TEACHER,"Marketing","joana.sanders@abc.com"));
        list.add(new Person("John","Drake","18-08-1988", Role.STUDENT,"Finance","john.drake@abc.com"));
        list.add(new Person("Samuel","Williams","22-03-1985", Role.OTHER,"Finance","samuel.williams@abc.com"));
    }

    public static List<Person> getInstance(){
        return list;
    }
}
