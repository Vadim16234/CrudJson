package repository;

import model.Label;
import model.Post;

import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {

    public GsonPostRepositoryImpl(Label label) {
//        this.label = label;
    }

    public GsonPostRepositoryImpl() {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post findById(Long ID) {
//        return posts.stream().filter(e -> e.getId().equals(ID)).findAny();
        return null;
    }

    @Override
    public void deleteById(Long ID) {
//        for (Post el : posts) {
//            if (el.getId().equals(ID)) {
//                el.setStatus(Status.DELETED);
//            }
//        }
    }

    @Override
    public Post add(Post post) {
//        posts.add(post);
        return post;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

//    @Override
    public void update(Long ID, String s1, String s2) {
//        Post post = findById(ID).get();
//        post.setTitle(s1);
//        post.setContent(s2);
//        posts.add(post);
    }
}
