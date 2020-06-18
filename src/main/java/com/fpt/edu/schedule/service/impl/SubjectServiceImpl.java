package com.fpt.edu.schedule.service.impl;

import com.fpt.edu.schedule.common.exception.InvalidRequestException;
import com.fpt.edu.schedule.model.Lecturer;
import com.fpt.edu.schedule.model.Subject;
import com.fpt.edu.schedule.model.Timetable;
import com.fpt.edu.schedule.repository.base.SemesterRepository;
import com.fpt.edu.schedule.repository.base.SubjectRepository;
import com.fpt.edu.schedule.repository.base.TimetableRepository;
import com.fpt.edu.schedule.service.base.LecturerService;
import com.fpt.edu.schedule.service.base.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    SubjectRepository subjectRepo;
    TimetableRepository timetableRepo;
    SemesterRepository semesterRepo;
    LecturerService lecturerService;

    @Override
    public void addSubject(Subject subject) {
        subjectRepo.save(subject);
    }

    @Override
    public Subject getSubjectByCode(String code) {
        return subjectRepo.findByCode(code);
    }

    @Override
    public List<Subject> getAllSubjectBySemester(int semesterId,String hodGoogleId) {
        Timetable timetable=timetableRepo.findBySemesterAndTempFalse(semesterRepo.findById(semesterId));

        if(timetable == null){
            throw new InvalidRequestException("Don't have subject for this semester !");
        }
        Lecturer hod = lecturerService.findByGoogleId(hodGoogleId);
        Set<Subject> subjectSet = timetable.getTimetableDetails().stream().filter(i->i.getSubject().getDepartment()
                .equals(hod.getDepartment())).map(i -> i.getSubject()).collect(Collectors.toSet());
        return new ArrayList<>(subjectSet);
    }


}
