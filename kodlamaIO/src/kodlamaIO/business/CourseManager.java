package kodlamaIO.business;

import kodlamaIO.core.logging.Logger;
import kodlamaIO.dataAccess.CourseDao;
import kodlamaIO.entities.Course;

public class CourseManager {
	private CourseDao courseDao;
	private Logger[] loggers;

	public CourseManager(CourseDao courseDao,Logger[] loggers) {
		this.courseDao = courseDao;
		this.loggers = loggers;
	}
	
	public void add(Course course) throws Exception{
		if(course.getPrice() < 0) {
			throw new Exception("Kurs fiyati 10'dan dusuk olamaz.");
		}
		
		
		 if(course.getName().equals(course.getName())) {
			 throw new Exception("Bu isimde bir kurs zaten var!");
			 }
		 
		courseDao.add(course);
		
		for(Logger logger : loggers) {
			logger.log(course.getName());
		}
		
	}
	
	
}
