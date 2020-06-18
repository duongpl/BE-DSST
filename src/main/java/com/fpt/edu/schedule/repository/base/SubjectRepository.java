package com.fpt.edu.schedule.repository.base;

import com.fpt.edu.schedule.model.Subject;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SubjectRepository extends Repository<Subject,Integer> {
    void save(Subject subject);

    Subject findByCode(String code);

    List<Subject> findAll();

    List<Subject> findAllByDepartment(String department);


}
