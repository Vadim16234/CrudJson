package view;

import model.Writer;
import repository.GsonWriterRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class WriterView {

    private final GsonWriterRepositoryImpl gsonWriterRepository;

    public WriterView(GsonWriterRepositoryImpl gsonWriterRepository) {
        this.gsonWriterRepository = gsonWriterRepository;
    }

    public List<Writer> findAll() {
        return gsonWriterRepository.findAll();
    }

    public Optional<Writer> findById(Long id) {
        return gsonWriterRepository.findById(id);
    }

    public void deleteById(Long id) {
        gsonWriterRepository.deleteById();
    }

    public void addWriter(Writer writer) {
        gsonWriterRepository.add(writer);
    }

    public void update(Long id, String s1, String s2) {
        gsonWriterRepository.update(id, s1, s2);
    }
}
