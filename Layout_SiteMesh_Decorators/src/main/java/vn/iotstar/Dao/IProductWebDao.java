package vn.iotstar.Dao;
import java.util.List;

import vn.iotstar.Models.ProductModel;

public interface IProductWebDao {
	List<ProductModel> findLastProduct();
	List<ProductModel> findBestProduct();
	List<ProductModel> findProductByCategoryId();
	List<ProductModel> findAllPage(int indexp);
	int countAll();
	ProductModel findTopProduct();
	ProductModel get(int id);
	ProductModel findById(int id);
	List<ProductModel> getNext3Product(int amount);
	List<ProductModel> getTop3Product();
}
