package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Builder(toBuilder = true)
public class Label {
    private Long id;
    private String name;
    private Status status;

}
