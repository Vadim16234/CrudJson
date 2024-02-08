package model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Builder(toBuilder = true)
public class Writer {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Status status;

    public void addPost(Post post){
        if (post == null) {
            this.posts = new ArrayList<>();
        }
        this.posts.add(post);
    }
}
