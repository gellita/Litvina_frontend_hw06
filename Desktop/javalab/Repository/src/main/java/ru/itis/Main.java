package ru.itis;

import ru.itis.repositories.EventsRepository;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.impl.EventsRepositoryFileImpl;
import ru.itis.repositories.impl.UsersRepositoryFileImpl;
import ru.itis.services.AppService;

import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl("users.txt");
        EventsRepository eventsRepository = new EventsRepositoryFileImpl("events.txt","events_users.txt");
        AppService appService = new AppService(usersRepository,eventsRepository);
        appService.signUp("admin@gmail.com","adminPassword");
        appService.signUp("angelinka@gmail.com","password1234");
        appService.addEvent("жесткое мероприятие", LocalDate.now());
        appService.addEvent("вкусный обэд", LocalDate.now().plusDays(1));
        appService.addUserToEvent("angelinka@gmail.com","жесткое мероприятие");
        appService.addUserToEvent("angelinka@gmail.com","вкусный обэд");
        appService.addUserToEvent("admin@gmail.com","жесткое мероприятие");
        appService.addUserToEvent("admin@gmail.com","вкусный обэд");
        appService.getAllEventsByUser("angelinka@gmail.com");


    }
}
