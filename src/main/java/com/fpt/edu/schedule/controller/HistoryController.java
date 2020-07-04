package com.fpt.edu.schedule.controller;


import com.fpt.edu.schedule.model.History;
import com.fpt.edu.schedule.repository.base.QueryParam;
import com.fpt.edu.schedule.service.base.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {
    HistoryService historyService;

    @PostMapping("/filter")
    public ResponseEntity<History> getHistorybyCriteria(QueryParam queryParam){
        return new ResponseEntity(historyService.findByCriteria(queryParam), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addHistory(@RequestBody History history){
        return new ResponseEntity(historyService.addHistory(history),HttpStatus.OK);
    }

}
