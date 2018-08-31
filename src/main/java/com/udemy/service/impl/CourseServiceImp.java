package com.udemy.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseServiceImp")
public class CourseServiceImp  implements CourseService{
	
	public static final Log LOG = LogFactory.getLog(CourseServiceImp.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	

	@Override
	public List<Course> listAllCourse() {
		LOG.info("Call: " + "listAllCourse()");
		courseJpaRepository.findAll();
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("Call: " + "addCourse()");
		return courseJpaRepository.save(course);
	}

	@Override
	public int rermoveCourse(int id) {
		LOG.info("Call: " + "rermoveCourse()");
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		LOG.info("Call: " + "updateCourse()");
		return courseJpaRepository.save(course);
	}
	
	

}
