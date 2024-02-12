package controller;

import model.Post;
import view.PostView;

import java.util.List;
import java.util.Optional;

public class PostController {

    private final PostView postView;

    public PostController(PostView postView) {
        this.postView = postView;
    }


    public List<Post> getAll() {
        return postView.showAll();
    }

    public Optional<Post> getById(Long id) {
        return postView.showById(id);
    }

    public void deletePostById(Long id) {
        postView.deleteById(id);
    }

    public void addPost(Post post) {
        postView.addPost(post);
    }

    public void updatePostById(Long id, String s1, String s2) {
        postView.updatePost(id, s1, s2);
    }
}
