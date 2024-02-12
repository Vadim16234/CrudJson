package model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Post implements Serializable {
    private Long id;
    private String title;
    private String content;
    private transient List<Label> lables;
    private Status status;

    public Post() {}

    public Post(Long id, String title, String content, List<Label> lables, Status status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.lables = lables;
        this.status = status;
    }

    public void addLable(Label label){
        if (label == null) {
            this.lables = new ArrayList<>();
        }
        this.lables.add(label);
    }
}
