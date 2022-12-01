package kodlamaIO.business;

import kodlamaIO.core.logging.Logger;
import kodlamaIO.dataAccess.CategoryDao;
import kodlamaIO.entities.Category;

public class CategoryManager {

	private CategoryDao categoryDao;
	private Logger[] loggers;

	public CategoryManager(CategoryDao categoryDao,Logger[] loggers) {
		this.categoryDao = categoryDao;
		this.loggers = loggers;
	}
	
	public void add(Category category) throws Exception {
		if(category.getName().equals(category.getName())) {
			throw new Exception("Bu isimde zaten bir kategori var!");
		}
		
		categoryDao.add(category);
		
		for(Logger logger : loggers) {
			logger.log(category.getName());
		}
	}
	
}
