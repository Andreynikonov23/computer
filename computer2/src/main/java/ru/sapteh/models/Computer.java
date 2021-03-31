package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Computer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String processor;
    @Column
    private String videoCard;
    @Column
    private String ram;
    @Column
    private String motherboard;
    @Column
    private String cooler;
    @Column
    private String ssd_m2;
    @Column
    private String ssd;
    @Column
    private String corpus;
    @Column
    private String powerSupply;
    @Column
    private String monitor;
    @Column
    private String keyboard;
    @Column
    private String mouse;
    @Column
    private String other;
}
