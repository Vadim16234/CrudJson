package repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Status;
import model.Writer;
import repository.PostRepository;
import repository.WriterRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final String FILE_NAME = "src/main/resources/writers.json";

    private List<Writer> readFromWritersFile() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            Type typeToken = new TypeToken<List<Writer>>() {}.getType();
            List<Writer> listWriters = new Gson().fromJson(fileReader, typeToken);

            if (listWriters == null) {
                listWriters = new ArrayList<>();
            }
            return listWriters;

        } catch (IOException e) {
            System.out.println("Ошибка чтения данных из файла " + e);
            return Collections.emptyList(); // в случае возникновения исключения, вернется пустой неизменяемый лист
        }
    }

    private void writeInFile(List<Writer> listWriters) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            String jsonCollection = new Gson().toJson(listWriters);
            fileWriter.write(jsonCollection);
        } catch (IOException e) {
            System.out.println("Ошибка при записи " + e);
        }
    }

    private Long generatedId(List<Writer> writerList) {
        Long countMax = 1L;

        if (writerList == null) {
            return countMax;
        } else {
            for (Writer writer : writerList) {
                if (writer.getId() >= countMax) {
                    countMax = writer.getId() + 1L;
                }
            }
            return countMax;
        }
    }

    @Override
    public List<Writer> findAll() {
        return readFromWritersFile();
    }

    @Override
    public Writer findById(Long id) {
        return readFromWritersFile()
                .stream()
                .filter(writer -> writer.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        List<Writer> writers = readFromWritersFile();
        for (Writer el : writers) {
            if (el.getId().equals(id)) {
                el.setStatus(Status.DELETED);
            }
        }
        writeInFile(writers);
    }

    @Override
    public Writer add(Writer writer) {
        List<Writer> listWriters = readFromWritersFile();

        Long id = generatedId(listWriters);

        writer.setId(id);
        listWriters.add(writer);
        writeInFile(listWriters);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> listWriters = readFromWritersFile();

        for (Writer w : listWriters) {
            if (w.getId().equals(writer.getId())) {
                w.setFirstName(writer.getFirstName());
                w.setLastName(writer.getLastName());
            }
        }
        writeInFile(listWriters);

        return writer;
    }
}
