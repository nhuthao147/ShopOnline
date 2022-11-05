package vn.iotstar.Services.Impl;

import java.util.List;

import vn.iotstar.Dao.IProductWebDao;
import vn.iotstar.Dao.Impl.ProductWebDaoImpl;
import vn.iotstar.Models.ProductModel;
import vn.iotstar.Services.IProductWebService;

public class ProductWebServiceImpl implements IProductWebService{

	IProductWebDao productWebDao = new ProductWebDaoImpl();
	@Override
	public List<ProductModel> findLastProduct() {
		return productWebDao.findLastProduct();
	}

	@Override
	public List<ProductModel> findBestProduct() {
		return productWebDao.findBestProduct();
	}

	@Override
	public ProductModel findTopProduct() {
		return productWebDao.findTopProduct();
	}

	@Override
	public ProductModel get(int id) {
		return productWebDao.get(id);
	}

	@Override
	public ProductModel findById(int id) {
		return productWebDao.findById(id);
	}

	@Override
	public List<ProductModel> findAllPage(int indexp) {
		return productWebDao.findAllPage(indexp);

	}

	@Override
	public int countAll() {
		return productWebDao.countAll();

	}

	@Override
	public List<ProductModel> getNext3Product(int amount) {
		// TODO Auto-generated method stub
		return productWebDao.getNext3Product(amount);
	}

	@Override
	public List<ProductModel> getTop3Product() {
		return productWebDao.getTop3Product();
	}

}
