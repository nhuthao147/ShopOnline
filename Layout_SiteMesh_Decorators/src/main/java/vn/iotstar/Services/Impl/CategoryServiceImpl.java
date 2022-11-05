package vn.iotstar.Services.Impl;

import java.io.File;
import java.util.List;

import vn.iotstar.Dao.ICategoryDao;
import vn.iotstar.Dao.Impl.CategoryDaoImpl;
import vn.iotstar.Models.CategoryModel;
import vn.iotstar.Services.ICategoryService;
import vn.iotstar.util.Constant;

public class CategoryServiceImpl implements ICategoryService {

	ICategoryDao cateDao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findALL() {
		// TODO Auto-generated method stub
		return cateDao.findALL();
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
	}

	@Override
	public void edit(CategoryModel newCategory) {
		CategoryModel oldCategory = cateDao.get(newCategory.getCateid());
		oldCategory.setCatename(newCategory.getCatename());
		if (newCategory.getImage() != null) {
			// XOA ANH CU DI
			String fileName = oldCategory.getImage();
			final String dir = Constant.DIR;
			File file = new File(dir + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setImage(newCategory.getImage());
		}
		cateDao.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
	}

	@Override
	public CategoryModel get(int id) {
		return cateDao.get(id);
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}
}
