package ru.itis.repositories.impl;

import ru.itis.models.Event;
import ru.itis.models.User;
import ru.itis.repositories.EventsRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventsRepositoryFileImpl implements EventsRepository {
    private final String eventFileName;
    private final String eventsAndUsersFileName;

    public EventsRepositoryFileImpl(String eventFileName, String eventsAndUsersFileName) {
        this.eventFileName = eventFileName;
        this.eventsAndUsersFileName = eventsAndUsersFileName;
    }

    @Override
    public void save(Event model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eventFileName,true))) {
            writer.write(model.getId() + "|"+model.getName() + "|" + model.getDate());
            writer.newLine();
        } catch (IOException e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Event findByName(String nameEvent) {
        try(BufferedReader br = new BufferedReader(new FileReader(eventFileName))){
            String line;
            while ((line = br.readLine())!=null){
                String[] field = line.split("\\|");
                if (nameEvent.equals(field[1])) {
                    return Event.builder()
                            .id(field[0])
                            .name(field[1])
                            .date(LocalDate.parse(field[2]))
                            .build();
                }

            }
        }catch (IOException e){
            throw new IllegalArgumentException();
        }

        return null;
    }

    @Override
    public void saveUserToEvent(User user, Event event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eventsAndUsersFileName, true))){
            writer.write(user.getId() + " | " + event.getId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }


    }

    @Override
    public List<Event> findAllByMembersContains(User user) {
        List<Event> eventsNameList = new ArrayList<>();
        List<String> eventsIdList = findEventsByUserId(user.getId());
        try (BufferedReader br = new BufferedReader(new FileReader(eventFileName))){
            String line;
            while((line= br.readLine())!=null){
                String[] field = line.split("\\|");
                if(eventsIdList.contains(field[0])){
                    eventsNameList.add(Event.builder()
                                    .id(field[0])
                                    .date(LocalDate.parse(field[1]))
                                    .name(field[2])
                                    .build());
                }

            }

        }catch (IOException e){
            throw new IllegalArgumentException();
        }
        return eventsNameList;
    }
    public List<String> findEventsByUserId(String userId){
        List<String> eventsId = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(eventsAndUsersFileName))) {
            String line;
            while((line = br.readLine())!=null){
                String[] field = line.split("\\|");
                if(userId.equals(field[0])){
                    eventsId.add(field[1]);
                }
            }

        }catch (IOException e){
            throw new IllegalArgumentException();
        }
        return eventsId;
    }
}
