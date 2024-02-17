package controller;

import model.Label;
import model.Status;
import repository.LabelRepository;

import java.util.List;

public class LabelController {
    private final LabelRepository labelRepository;


    public LabelController(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    public Label getLabelById(Long id) {
        return labelRepository.findById(id);
    }

    public void deleteLabelById(Long id) {
        labelRepository.deleteById(id);
    }

    public Label addLabel(String name, Status status) {
        Label label = new Label();
        label.setName(name);
        label.setStatus(status);
        return labelRepository.add(label);
    }

    public Label updateLabel(Label label) {
        return labelRepository.update(label);
    }
}
