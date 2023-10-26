package com.rollcall.service;

import com.rollcall.model.Employee;
import com.rollcall.model.Log;
import com.rollcall.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public ResponseEntity<Log> addLog(Log log, Employee employee) {

        if ((log.getId()==null) && (log.getEnterTime()==null)){
            log.setEmployee(employee);
            log.setEnterTime(LocalDateTime.now());
            Log result = (Log) logRepository.save(log);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else if (log.getEnterTime() != null) {
            log.setExitTime(LocalDateTime.now());
            Log result = (Log) logRepository.save(log);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        } else return (ResponseEntity<Log>) ResponseEntity.badRequest();
    }

    public ResponseEntity<List<Log>> getLogs(Employee employee){
        List<Log> result = new ArrayList<Log>();
        result.add((Log) logRepository.getById(employee.getId()));
        return (result != null) ? ResponseEntity.status(HttpStatus.FOUND).body(result) : (ResponseEntity<List<Log>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Log>> getAllLogs(){
        List<Log> result = logRepository.findAll();
        return (result != null) ? ResponseEntity.status(HttpStatus.FOUND).body(result) : (ResponseEntity<List<Log>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Log> editLog(Log log){
        if (log != null){
            Log result = (Log) logRepository.save(log);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }else return (ResponseEntity<Log>) ResponseEntity.status(HttpStatus.BAD_REQUEST);

    }
}