package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table
public class Computer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String processor;
    @Column
    private String ram;
    @Column
    private String videoCard;
    @Column
    private String ssd;
    @Column
    private String motherboard;
}
