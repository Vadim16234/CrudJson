package controller;

import model.Post;
import model.Status;
import model.Writer;
import repository.WriterRepository;

import java.util.List;

public class WriterController {
    private final WriterRepository gsonWriterRepository;

    public WriterController(WriterRepository gsonWriterRepository) {
        this.gsonWriterRepository = gsonWriterRepository;
    }

    public List<Writer> showAll() {
        return gsonWriterRepository.findAll();
    }

    public Writer showById(Long id) {
        return gsonWriterRepository.findById(id);
    }

    public void deleteById(Long id) {
        gsonWriterRepository.deleteById(id);
    }

    public Writer addWriter(String firstName, String lastname, List<Post> posts, Status status) {
        Writer writer = new Writer();
        writer.setFirstName(firstName);
        writer.setLastName(lastname);
        writer.setPosts(posts);
        writer.setStatus(status);

        return gsonWriterRepository.add(writer);
    }

    public Writer update(Long id, String firstName, String lastname, List<Post> posts, Status status) {
        Writer writer = showById(id);
        writer.setFirstName(firstName);
        writer.setLastName(lastname);
        writer.setPosts(posts);
        writer.setStatus(status);
        return gsonWriterRepository.update(writer);

    }
}
