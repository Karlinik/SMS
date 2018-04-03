package com.nikola.sms_03.example;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Nikola Karlikova on 28.03.2018.
 */
public class Person {
    private long id;
    private String name;
    private String surname;
    private String birthDate;
    private Role role;
    private String circle;
    private String email;
    private static final AtomicLong counter = new AtomicLong(100);


    public Person(long id, String name, String surname, String birthDate, Role role, String circle, String email) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.role = role;
        this.circle = circle;
        this.email = email;
        this.id = id;
    }

    public Person(String name, String surname, String birthDate, Role role, String circle, String email){
        long id = counter.incrementAndGet();
        new Person(id, name, surname, birthDate, role, circle, email);
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
}
