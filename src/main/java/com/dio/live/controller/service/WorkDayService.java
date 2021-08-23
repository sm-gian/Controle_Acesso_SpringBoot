package com.dio.live.controller.service;

import com.dio.live.controller.repository.WorkDayRepository;
import com.dio.live.model.WorkDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkDayService {

    final WorkDayRepository workDayRepository;

    @Autowired
    public WorkDayService(WorkDayRepository workDayRepository){
        this.workDayRepository = workDayRepository;
    }

    public WorkDay save(WorkDay workDay){
        return workDayRepository.save(workDay);
    }

    public ResponseEntity<WorkDay> update(Long workDayId, WorkDay newWorkDay){
        Optional<WorkDay> oldWorkDay = workDayRepository.findById(workDayId);

        if(oldWorkDay.isPresent()){
            oldWorkDay.get().setDescription(newWorkDay.getDescription());
            return new ResponseEntity<>(workDayRepository.save(oldWorkDay.get()), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<WorkDay> getById(Long workdayId){
        Optional<WorkDay> wday = workDayRepository.findById(workdayId);
        return wday.map(workDay -> new ResponseEntity<>(workDay, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Void> delete (WorkDay workDay){
        if(workDayRepository.existsById(workDay.getId())){
            workDayRepository.deleteById(workDay.getId());
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        else return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Void> deleteById(Long workDayId){
        if(workDayRepository.existsById(workDayId)){
            workDayRepository.deleteById(workDayId);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        else return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    public List<WorkDay> findAll() {
        return workDayRepository.findAll();
    }
}
