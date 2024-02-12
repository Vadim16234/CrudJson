package model;

import lombok.*;

@Getter
@Setter
@ToString
public class Label {
    private Long id;
    private String name;
    private Status status;

    public Label() {}

    public Label(Long id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
