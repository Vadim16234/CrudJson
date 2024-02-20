package repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Label;
import model.Status;
import repository.LabelRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final String FILE_NAME = "src/main/resources/labels.json";

    private List<Label> readFromLabelsFile() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            Type typeToken = new TypeToken<List<Label>>() {}.getType();
            List<Label> labelList = new Gson().fromJson(fileReader, typeToken);

            if (labelList == null) {
                labelList = new ArrayList<>();
            }
            return labelList;

        } catch (IOException e) {
            System.out.println("Ошибка чтения " + e);
            return Collections.emptyList();
        }
    }

    private void writeToLabelsFile(List<Label> labelList) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            String jsonLabels = new Gson().toJson(labelList);
            fileWriter.write(jsonLabels);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения " + e);
        }
    }

    private Long generatedId(List<Label> labelList) {
        Long lablesId = 1L;

        if (labelList == null) {
            return lablesId;
        } else {
            for (Label label : labelList) {
                if (label.getId() >= lablesId) {
                    lablesId = label.getId() + 1;
                }
            }
        }
        return lablesId;
    }

    @Override
    public List<Label> findAll() {
        return readFromLabelsFile();
    }

    @Override
    public Label findById(Long id) {
        return readFromLabelsFile()
                .stream()
                .filter(l -> l.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        List<Label> labelList = readFromLabelsFile();
        for (Label label : labelList) {
            if (label.getId().equals(id)) {
                label.setStatus(Status.DELETED);
            }
        }
        writeToLabelsFile(labelList);
    }

    @Override
    public Label add(Label label) {
        List<Label> labelList = readFromLabelsFile();

        Long labelId = generatedId(labelList);

        label.setId(labelId);
        labelList.add(label);
        writeToLabelsFile(labelList);

        return label;
    }

    @Override
    public Label update(Label label) {
        List<Label> labelList = readFromLabelsFile();

        for (Label l : labelList) {
            if (l.getId().equals(label.getId())) {
                l.setName(label.getName());
            }
        }
        writeToLabelsFile(labelList);

        return label;
    }
}