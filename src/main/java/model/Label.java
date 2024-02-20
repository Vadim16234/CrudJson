package model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    private Long id;
    private String name;
    private Status status;

}
