package controller;

import model.Label;
import model.Post;
import model.Status;
import repository.PostRepository;
import repository.gson.GsonPostRepositoryImpl;

import java.util.List;

public class PostController {

    public final PostRepository postRepository;

    public PostController() {
        this.postRepository = new GsonPostRepositoryImpl();
    }

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> showAll() {
        return postRepository.findAll();
    }

    public Post showById(Long id) {
        return postRepository.findById(id);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public Post addPost(String title, String context, List<Label> labels, Status status) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(context);
        post.setLabels(labels);
        post.setStatus(status);

        return postRepository.add(post);
    }

    public Post update(Post post) {
        return postRepository.update(post);
    }
}
