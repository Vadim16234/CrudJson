import com.google.gson.Gson;
import controller.WriterController;
import model.Status;
import model.Writer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Writer> writerCollection = new ArrayList<>();

        Writer writer = new Writer(1L, "Vadim", "Popov", Status.ACTIVE);
        Writer writer2 = new Writer(2L, "Dima", "Ivanov", Status.ACTIVE);

        writerCollection.add(writer);
        writerCollection.add(writer2);

        String jsonCollection = new Gson().toJson(writerCollection);


        try (FileWriter write = new FileWriter(
                "writers.json")) {

        } catch (IOException e) {
            System.out.println("Ошибка при сохранении " + e);
        }



//



//        List<Writer> writerCollection = new ArrayList<>();
//
//        Writer writer = new Writer(1L, "Vadim", "Popov", Status.ACTIVE);
//        Writer writer2 = new Writer(1L, "Dima", "Ivanov", Status.ACTIVE);
//
//        writerCollection.add(writer);
//        writerCollection.add(writer2);
//
//        String jsonCollection = new Gson().toJson(writerCollection);
//
//        System.out.println(jsonCollection);

    }
}
