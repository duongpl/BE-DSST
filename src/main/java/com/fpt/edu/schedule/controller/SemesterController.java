package com.fpt.edu.schedule.controller;

import com.fpt.edu.schedule.model.Semester;
import com.fpt.edu.schedule.repository.base.QueryParam;
import com.fpt.edu.schedule.service.base.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/semesters")
public class SemesterController {
    SemesterService semesterService;
    @PostMapping("/filter")
    public ResponseEntity getSemesterByCriteria(@RequestBody QueryParam queryParam) {

            List<Semester> expectedList =semesterService.findByCriteria(queryParam);
            return new ResponseEntity(expectedList, HttpStatus.OK);

    }
}
