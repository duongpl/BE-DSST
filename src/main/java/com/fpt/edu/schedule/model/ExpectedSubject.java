package com.fpt.edu.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ExpectedSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int levelOfPrefer;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "expected_id")
    private Expected expected;
    @JsonProperty("name")
    private String subjectCode;

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public ExpectedSubject(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public ExpectedSubject(String subjectCode,int levelOfPrefer, Expected expected) {
        this.levelOfPrefer = levelOfPrefer;
        this.expected = expected;
        this.subjectCode =subjectCode;
    }
}
