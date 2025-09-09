/**
 * Projeto: CityEvents
 * Disciplina: Atividade Pratique
 * Autor: Felipe Oliveira
 */

package utils;

import models.Event;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String FILE_NAME = "events.data";

    public static void saveEvents(List<Event> events) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Event e : events) {
                bw.write(e.toDataString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Event> loadEvents() {
        List<Event> events = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return events;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                Event e = Event.fromDataString(line);
                if(e != null) events.add(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }
}
