package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.dto.Person;
import ru.otus.spring.service.IOService;


@Component
public class PersonDaoImpl implements PersonDao {

    Person person;

    private final IOService ioService;

    public PersonDaoImpl(IOService ioService) {
        this.ioService = ioService;
    }

    public Person getPerson() {
        if (this.person == null) {
            String firstName = ioService.readStringWithPrompt("Укажите имя: ");
            String secondName = ioService.readStringWithPrompt("Укажите фамилию : ");
            this.person = new Person(firstName, secondName);
        }
        return this.person;
    }
}
