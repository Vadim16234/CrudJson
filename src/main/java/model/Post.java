package model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Builder(toBuilder = true)
public class Post {
    private Long id;
    private String title;
    private String content;
    private List<Label> lables;
    private Status status;
}
