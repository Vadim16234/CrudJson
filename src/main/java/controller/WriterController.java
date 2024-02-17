package controller;

import model.Post;
import model.Status;
import model.Writer;
import repository.WriterRepository;

import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository;

    public WriterController(WriterRepository gsonWriterRepository) {
        this.writerRepository = gsonWriterRepository;
    }

    public List<Writer> showAll() {
        return writerRepository.findAll();
    }

    public Writer showById(Long id) {
        return writerRepository.findById(id);
    }

    public void deleteById(Long id) {
        writerRepository.deleteById(id);
    }

    public Writer addWriter(String firstName, String lastname, List<Post> posts, Status status) {
        Writer writer = new Writer();
        writer.setFirstName(firstName);
        writer.setLastName(lastname);
        writer.setPosts(posts);
        writer.setStatus(status);

        return writerRepository.add(writer);
    }

    public Writer update(Writer writer) {
        return writerRepository.update(writer);

    }
}
