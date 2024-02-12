package repository;

import model.Post;
import model.Status;
import model.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GsonWriterRepositoryImpl implements WriterRepository {
    List<Writer> writers = new ArrayList<>();

    private final Post post;

    public GsonWriterRepositoryImpl(Post post) {
        this.post = post;
    }

    @Override
    public List<Writer> findAll() {
        return writers;
    }

    @Override
    public Optional<Writer> findById(Long id) {
        return writers.stream().filter(e -> e.getId().equals(id)).findAny();
    }

    public void deleteById(Long id) {
        for (Writer el : writers) {
            if (el.getId().equals(id)) {
                el.setStatus(Status.DELETED);
            }
        }
    }

    @Override
    public void add(Writer writer) {
//        writer.addPost(post);

        writers.add(writer);
    }

    @Override
    public void update(Long ID, String s1, String s2) {
        Writer writer = findById(ID).get();
        writer.setFirstName(s1);
        writer.setLastName(s2);
        writers.add(writer);
    }
}
