package ru.itis.repositories.impl;

import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.io.*;

public class UsersRepositoryFileImpl implements UsersRepository {
    private final String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(User model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            writer.write(model.getId() + " | "+model.getEmail() + " | " + model.getPassword());
            writer.newLine();
        } catch (IOException e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public User findByEmail(String emailUser) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine())!= null){
                String[] field = line.split(" \\| ");
                if (emailUser.equals(field[1])) {
                    return User.builder()
                            .id(field[0])
                            .email(field[1])
                            .password(field[2])
                            .build();
                }

            }

        } catch(IOException e){
            throw new IllegalArgumentException();
        }
        return null;
    }
}


