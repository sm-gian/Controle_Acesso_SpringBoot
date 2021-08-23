package com.dio.live.controller;

import com.dio.live.controller.service.WorkDayService;
import com.dio.live.model.WorkDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workday")
public class WorkDayController {

    @Autowired
    WorkDayService workDayService;

    @GetMapping
    public List<WorkDay> getWorkDays(){
        return workDayService.findAll();
    }

    @GetMapping("/{workDayId}")
    public ResponseEntity<WorkDay> getById(@PathVariable("workDayId") Long workDayId){
        return workDayService.getById(workDayId);
    }

    @PostMapping
    public WorkDay createWorkDay(@Valid @RequestBody WorkDay workDay){
        return workDayService.save(workDay);
    }

    @PutMapping
    public ResponseEntity<WorkDay> updateWorkDay(@Valid @RequestBody WorkDay workDay){
        return workDayService.update(workDay.getId(), workDay);
    }

    @PutMapping("/{workDayId}")
    public ResponseEntity<WorkDay> updateWorkDay(@PathVariable("workDayId") Long workDayId, @Valid @RequestBody WorkDay workDay){
        return workDayService.update(workDayId,workDay);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkDay(@RequestBody WorkDay workDay){
        return workDayService.delete(workDay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        return workDayService.deleteById(id);
    }


}
