package com.spring.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.demo.Entity.AttendanceEntity;
import com.spring.demo.Service.AttendanceService;

@RestController
public class AttendanceController {

	
    @Autowired
    private AttendanceService attendanceService;

   

    @GetMapping("/allStudentList")
    public List<AttendanceEntity> getAllAttendanceRecords() {
        return attendanceService.getAllAttendanceRecords();
    }
    @GetMapping("/presentStudentList")
    public List<AttendanceEntity> getPresentStudents() {
        return attendanceService.getPresentStudents();
    }
    
    @GetMapping("/absentStudentList")
    public List<AttendanceEntity> getAbsentStudents() {
        return attendanceService.getAbsentStudents();
    }

    @GetMapping("/student/{studentNumber}")
    public List<AttendanceEntity> getAttendanceByStudentNumber(@PathVariable Long studentNumber) {
        return attendanceService.getAttendanceByStudentNumber(studentNumber);
    }
    
    @PostMapping("/addStudentData")
    public ResponseEntity<AttendanceEntity> createAttendance(@RequestBody AttendanceEntity attendance) {
        AttendanceEntity savedAttendance = attendanceService.saveAttendance(attendance);
        return ResponseEntity.ok(savedAttendance);
    }
  

    @PutMapping("update/{id}")
    public ResponseEntity<AttendanceEntity> updateAttendance(@PathVariable Long id, @RequestBody AttendanceEntity updatedAttendance) {
        try {
            AttendanceEntity attendance = attendanceService.updateAttendance(id, updatedAttendance);
            return ResponseEntity.ok(attendance);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}

