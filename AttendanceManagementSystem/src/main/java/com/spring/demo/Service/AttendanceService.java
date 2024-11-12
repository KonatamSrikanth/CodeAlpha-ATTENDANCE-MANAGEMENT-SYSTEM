package com.spring.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.Entity.AttendanceEntity;
import com.spring.demo.Repositoy.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public AttendanceEntity saveAttendance(AttendanceEntity attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<AttendanceEntity> getAllAttendanceRecords() {
        return attendanceRepository.findAll();
    }
    public List<AttendanceEntity> getPresentStudents() {
        return attendanceRepository.findByPresentTrue(); 
    }

    public List<AttendanceEntity> getAbsentStudents() {
        return attendanceRepository.findByPresentFalse(); 
    }
    
    public List<AttendanceEntity> getAttendanceByStudentNumber(Long studentNumber) {
        return attendanceRepository.findByStudentNumber(studentNumber);
    }



    public AttendanceEntity updateAttendance(Long id, AttendanceEntity updatedAttendance) {
        Optional<AttendanceEntity> existingAttendance = attendanceRepository.findById(id);
        if (existingAttendance.isPresent()) {
            AttendanceEntity attendance = existingAttendance.get();
            attendance.setStudentNumber(updatedAttendance.getStudentNumber());
            attendance.setStudentName(updatedAttendance.getStudentName());
            attendance.setDate(updatedAttendance.getDate());
            attendance.setPresent(updatedAttendance.isPresent());
            return attendanceRepository.save(attendance);
        } else {
            throw new RuntimeException("Attendance record not found with ID: " + id);
        }
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}


