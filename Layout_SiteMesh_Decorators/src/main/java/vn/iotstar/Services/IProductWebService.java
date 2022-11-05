package vn.iotstar.Services;

import java.util.List;

import vn.iotstar.Models.ProductModel;

public interface IProductWebService {
	List<ProductModel> findLastProduct();
	List<ProductModel> findBestProduct();
	List<ProductModel> getTop3Product();
	List<ProductModel> getNext3Product(int amount);
	ProductModel findTopProduct();
	ProductModel get(int id);
	ProductModel findById(int id);
	List<ProductModel> findAllPage(int indexp);
	int countAll();
}
