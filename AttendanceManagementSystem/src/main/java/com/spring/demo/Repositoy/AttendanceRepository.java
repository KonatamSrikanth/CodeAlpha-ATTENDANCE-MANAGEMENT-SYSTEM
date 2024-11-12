package com.spring.demo.Repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.Entity.AttendanceEntity;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity,Long>{

	 List<AttendanceEntity> findByStudentNumber(Long studentNumber);
	 List<AttendanceEntity> findByPresentTrue();
	 List<AttendanceEntity> findByPresentFalse();
}
