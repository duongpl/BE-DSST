package com.fpt.edu.schedule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "lecture_id_change")
    private Lecturer lecture_id_change;
    @ManyToOne
    @JoinColumn(name = "lecture_id_changed")
    private Lecturer lecture_id_changed;
    private Date change_time;
    @ManyToOne
    @JoinColumn(name = "semester")
    private Semester semester;
    @Type(type = "text")
    private String note;

}
