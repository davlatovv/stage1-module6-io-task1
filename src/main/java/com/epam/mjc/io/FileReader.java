package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            if ((line = reader.readLine()) != null) {
                profile.setName(line.replace("Name: ", ""));
                String line1 = reader.readLine();
                profile.setAge(Integer.valueOf(line1.replace("Age: ", "")));
                String line2 = reader.readLine();
                profile.setEmail(line2.replace("Email: ", ""));
                String line3 = reader.readLine();
                profile.setPhone(Long.parseLong(line3.replace("Phone: ", "")));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }
}


