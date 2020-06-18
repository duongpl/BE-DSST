package com.fpt.edu.schedule.controller;

import com.fpt.edu.schedule.model.ClassName;
import com.fpt.edu.schedule.repository.base.QueryParam;
import com.fpt.edu.schedule.service.base.ClassNameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {
    ClassNameService classNameService;
    @PostMapping("/filter")
    public ResponseEntity getExpectedByCriteria(@RequestBody QueryParam queryParam,
                                                @RequestParam(value = "semesterId", defaultValue = "") String semesterId,
                                                @RequestHeader("GoogleId") String lecturerId) {


            List<ClassName> classNames = classNameService.findByCriteria(queryParam,semesterId,lecturerId);
            return new ResponseEntity(classNames, HttpStatus.OK);

    }
}
