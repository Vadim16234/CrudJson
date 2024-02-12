package controller;

import model.Writer;
import view.WriterView;

import java.util.List;
import java.util.Optional;

public class WriterController {
    private final WriterView writerView;

    public WriterController(WriterView writerView) {
        this.writerView = writerView;
    }

    public List<Writer> showAll() {
        return writerView.findAll();
    }

    public Optional<Writer> showById(Long id) {
        return writerView.findById(id);
    }

    public void deleteById(Long id) {
        writerView.deleteById(id);
    }

    public void addWriter(Writer writer) {
        writerView.addWriter(writer);
    }

    public void update(Long id, String s1, String s2) {
        writerView.update(id, s1, s2);
    }
}
