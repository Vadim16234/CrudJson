package model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Writer implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private transient List<Post> posts;
    private Status status;

    public void addPost(Post post){
        if (post == null) {
            this.posts = new ArrayList<>();
        }
        this.posts.add(post);
    }

    public Writer() {}

    public Writer(Long id, String firstName, String lastName, List<Post> posts, Status status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
        this.status = status;
    }
}
