package com.rollcall.controller;

import com.rollcall.model.Log;
import com.rollcall.model.Employee;
import com.rollcall.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {this.logService = logService;}

    @PostMapping(value = "/main/log/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Log> addLog (@RequestBody Log log, Employee employee) {return logService.addLog(log, employee);}

    @GetMapping(value = "/main/log/getlogs", produces = "application/json")
    public ResponseEntity<List<Log>> getLogs (@RequestParam Employee employee) {return logService.getLogs(employee);}

    @GetMapping(value = "/main/log/getalllogs", produces = "application/json")
    public ResponseEntity<List<Log>> getAllLogs () {return logService.getAllLogs();}

    @PutMapping(value = "/main/log/editlog", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Log> editLog (@RequestBody Log log) {return logService.editLog(log);}
}