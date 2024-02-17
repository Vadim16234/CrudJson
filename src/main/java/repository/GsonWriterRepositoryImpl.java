package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Post;
import model.Status;
import model.Writer;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GsonWriterRepositoryImpl implements WriterRepository {
    public GsonWriterRepositoryImpl() {
    }

    private final String FILE_NAME = "writers.json";
    private final Gson gson = new Gson();
    private final PostRepository postRepository = new GsonPostRepositoryImpl();

    public List<Writer> readFrowWritersFile() {
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

    public void writeInFile(List<Writer> listWriters) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            String jsonCollection = new Gson().toJson(listWriters);
            fileWriter.write(jsonCollection);
        } catch (IOException e) {
            System.out.println("Ошибка при записи " + e);
        }
    }

    public Long generatedId(List<Writer> writerList) {
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
        return readFrowWritersFile();
    }

    @Override
    public Writer findById(Long id) {
        return readFrowWritersFile()
                .stream()
                .filter(writer -> writer.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        List<Writer> writers = readFrowWritersFile();
        for (Writer el : writers) {
            if (el.getId().equals(id)) {
                el.setStatus(Status.DELETED);
            }
        }
        writeInFile(writers);
    }

    @Override
    public Writer add(Writer writer) {
        List<Writer> listWriters = readFrowWritersFile();

        Long id = generatedId(listWriters);

        writer.setId(id);
        listWriters.add(writer);
        writeInFile(listWriters);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> listWriters = readFrowWritersFile();

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
