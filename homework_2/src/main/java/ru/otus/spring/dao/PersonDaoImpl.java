package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.dto.Person;

import java.util.Scanner;

@Component
public class PersonDaoImpl implements PersonDao {

    Person person;

    public PersonDaoImpl(Person person) {
        this.person = person;
    }

    public void setPersonData() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Укажите имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Укажите фамилию : ");
            String secondName = scanner.nextLine();
            //System.out.println("firstName: " + firstName + "secondName" + secondName);
            this.person.setPersonData(firstName,secondName);
    }



    public Person getPerson(){
        return this.person;
    }

//
//    PersonDaoImpl() {
//        this.person = getPerson();
//    }

}
