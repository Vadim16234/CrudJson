package view;

import model.Post;
import repository.GsonPostRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class PostView {

    private final GsonPostRepositoryImpl gsonPostRepository;

    public PostView(GsonPostRepositoryImpl gsonPostRepository) {
        this.gsonPostRepository = gsonPostRepository;
    }

    public List<Post> showAll() {
        return gsonPostRepository.findAll();
    }

    public Optional<Post> showById(Long id) {
        return gsonPostRepository.findById(id);
    }

    public void deleteById(Long id) {
        gsonPostRepository.deleteById(id);
    }

    public void addPost(Post post) {
        gsonPostRepository.add(post);
    }

    public void updatePost(Long id, String s1, String s2) {
        gsonPostRepository.update(id, s1, s2);
    }
}
