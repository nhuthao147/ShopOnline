package vn.iotstar.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBConnect;
import vn.iotstar.Dao.IProductWebDao;
import vn.iotstar.Models.CategoryModel;
import vn.iotstar.Models.ProductModel;
import vn.iotstar.Services.ICategoryService;
import vn.iotstar.Services.Impl.CategoryServiceImpl;

public class ProductWebDaoImpl extends DBConnect implements IProductWebDao {

	@Override
	public List<ProductModel> findLastProduct() {
		List<ProductModel> categories = new ArrayList<ProductModel>(); // tao mot list danh sach
		String sql = "SELECT TOP (4) *\r\n"
				+ "  FROM [ShopOnline].[dbo].[Product]\r\n"
				+ "  ORDER BY productId desc;";
		try {
			Connection conn = super.getConnection(); // ket noi database
			PreparedStatement ps = conn.prepareStatement(sql); // nem cau sql vao cho phat bieu preparestatement
			ResultSet rs = ps.executeQuery(); // executeUpdate voi cau lenh thay doi database (thuc thi cau sql tra ve ResultSet))

			while (rs.next()) { // doc tung hang trong bang RS dua vao Model
				ProductModel category = new ProductModel(); // khoi tao doi tuong CategoryModel


				category.setProductId(rs.getInt("productId")); // dua du lieu CateID trong RS sag CateID cua model
				category.setProductName(rs.getString("productName"));
				category.setProductCode(rs.getLong("productCode"));
				category.setCategoryid(rs.getInt("categoryId"));
				category.setDescription(rs.getString("description"));
				category.setPrice(rs.getDouble("price"));
				category.setAmount(rs.getInt("amount"));
				category.setStock(rs.getInt("stock"));
				category.setImage(rs.getString("images"));
				category.setWhislist(rs.getInt("wishlist"));
				category.setStatus(rs.getInt("status"));
				category.setCrateDate(rs.getDate("createDate"));
				category.setSellerid(rs.getInt("sellerId"));


				categories.add(category); // them vao danh sach List
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories; // tra ve danh sach
	}

	@Override
	public List<ProductModel> findBestProduct() {
		List<ProductModel> categories = new ArrayList<ProductModel>(); // tao mot list danh sach
		String sql = "SELECT TOP (4) *\r\n"
				+ "  FROM [ShopOnline].[dbo].[Product]\r\n"
				+ "  ORDER BY amount desc;";
		try {
			Connection conn = super.getConnection(); // ket noi database
			PreparedStatement ps = conn.prepareStatement(sql); // nem cau sql vao cho phat bieu preparestatement
			ResultSet rs = ps.executeQuery(); // executeUpdate voi cau lenh thay doi database (thuc thi cau sql tra ve ResultSet))

			while (rs.next()) { // doc tung hang trong bang RS dua vao Model
				ProductModel category = new ProductModel(); // khoi tao doi tuong CategoryModel


				category.setProductId(rs.getInt("productId")); // dua du lieu CateID trong RS sag CateID cua model
				category.setProductName(rs.getString("productName"));
				category.setProductCode(rs.getLong("productCode"));
				category.setCategoryid(rs.getInt("categoryId"));
				category.setDescription(rs.getString("description"));
				category.setPrice(rs.getDouble("price"));
				category.setAmount(rs.getInt("amount"));
				category.setStock(rs.getInt("stock"));
				category.setImage(rs.getString("images"));
				category.setWhislist(rs.getInt("wishlist"));
				category.setStatus(rs.getInt("status"));
				category.setCrateDate(rs.getDate("createDate"));
				category.setSellerid(rs.getInt("sellerId"));


				categories.add(category); // them vao danh sach List
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories; // tra ve danh sach
	}

	@Override
	public ProductModel findTopProduct() {
		ProductModel product = new ProductModel(); // tao mot list danh sach
		String sql = "SELECT TOP (1) *\r\n"
				+ "  FROM [ShopOnline].[dbo].[Product]\r\n"
				+ "  ORDER BY amount desc;";
		try {
			Connection conn = super.getConnection(); // ket noi database
			PreparedStatement ps = conn.prepareStatement(sql); // nem cau sql vao cho phat bieu preparestatement
			ResultSet rs = ps.executeQuery(); // executeUpdate voi cau lenh thay doi database (thuc thi cau sql tra ve ResultSet))

			while (rs.next()) { // doc tung hang trong bang RS dua vao Model

				product.setProductId(rs.getInt("productId")); // dua du lieu CateID trong RS sag CateID cua model
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getLong("productCode"));
				product.setCategoryid(rs.getInt("categoryId"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImage(rs.getString("images"));
				product.setWhislist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCrateDate(rs.getDate("createDate"));
				product.setSellerid(rs.getInt("sellerId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product; // tra ve danh sach
	}

	@Override
	public ProductModel get(int id) {
		String sql = "SELECT * FROM [ShopOnline].[dbo].[Product] WHERE productId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId")); // dua du lieu CateID trong RS sag CateID cua model
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getLong("productCode"));
				product.setCategoryid(rs.getInt("categoryId"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImage(rs.getString("images"));
				product.setWhislist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCrateDate(rs.getDate("createDate"));
				product.setSellerid(rs.getInt("sellerId"));
				return product;
			}} catch (Exception e) {
				e.printStackTrace();}
		return null;
	}

	@Override
	public List<ProductModel> findProductByCategoryId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel findById(int id) {
		String sql ="Select Product.productId,Product.productName,Product.productCode,Product.description,Product.amount,Product.price,Product.images,Product.create"
				+ "Date,Product.stock,\r\n"
				+ "Product.wishlist,Product.status, Category.categoryId, Category.categoryName\r\n"
				+ "from Product\r\n"
				+ "INNER JOIN Category ON Product.categoryId = Category.categoryId\r\n"
				+ "where productId =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ICategoryService categoryService = new CategoryServiceImpl();
			while (rs.next()) {
				CategoryModel category = categoryService.findById(rs.getInt("categoryid"));

				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId")); // dua du lieu CateID trong RS sag CateID cua model
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getLong("productCode"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImage(rs.getString("images"));
				product.setWhislist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCrateDate(rs.getDate("createDate"));

				product.setCategory(category);
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return null;}

	@Override
	public List<ProductModel> findAllPage(int indexp) {
		List<ProductModel> categories = new ArrayList<ProductModel>(); // tao mot list danh sach
		String sql = "select Product.productId,Product.productName,Product.productCode,Product.description,Product.amount,Product.price,Product.images,Product.createDate,Product.stock,\r\n"
				+ " Product.wishlist,Product.status, Category.categoryId, Category.categoryName\r\n"
				+ "from Product\r\n"
				+ "INNER JOIN Category ON Product.categoryId = Category.categoryId\r\n"
				+ "ORDER BY productid DESC OFFSET ? rows fetch next 3 rows only";

		try {
			Connection conn = super.getConnection(); // ket noi database
			PreparedStatement ps = conn.prepareStatement(sql); // nem cau sql vao cho phat bieu preparestatement
			ps.setInt(1, indexp);
			ResultSet rs = ps.executeQuery(); // executeUpdate voi cau lenh thay doi database (thuc thi cau sql tra ve ResultSet))

			while (rs.next()) { // doc tung hang trong bang RS dua vao Model
				ProductModel category = new ProductModel(); // khoi tao doi tuong CategoryModel


				category.setProductId(rs.getInt("productId")); // dua du lieu CateID trong RS sag CateID cua model
				category.setProductName(rs.getString("productName"));
				category.setProductCode(rs.getLong("productCode"));
				category.setDescription(rs.getString("description"));
				category.setPrice(rs.getDouble("price"));
				category.setAmount(rs.getInt("amount"));
				category.setStock(rs.getInt("stock"));
				category.setImage(rs.getString("images"));
				category.setWhislist(rs.getInt("wishlist"));
				category.setStatus(rs.getInt("status"));
				category.setCrateDate(rs.getDate("createDate"));


				categories.add(category); // them vao danh sach List
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories; // tra ve danh sach
	}

	@Override
	public int countAll() {
		String sql = "select count(*) from product";
		try {
			Connection conn = super.getConnection(); // ket noi database
			PreparedStatement ps = conn.prepareStatement(sql); // nem cau sql vao cho phat bieu preparestatement
			ResultSet rs = ps.executeQuery(); // executeUpdate voi cau lenh thay doi database (thuc thi cau sql tra ve ResultSet))

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public List<ProductModel> getTop3Product() {
		List<ProductModel> categories = new ArrayList<ProductModel>(); // tao mot list danh sach
		String sql = "SELECT TOP (3) *\r\n"
				+ "  FROM [ShopOnline].[dbo].[Product]\r\n";
		try {
			Connection conn = super.getConnection(); // ket noi database
			PreparedStatement ps = conn.prepareStatement(sql); // nem cau sql vao cho phat bieu preparestatement
			ResultSet rs = ps.executeQuery(); // executeUpdate voi cau lenh thay doi database (thuc thi cau sql tra ve ResultSet))

			while (rs.next()) { // doc tung hang trong bang RS dua vao Model
				ProductModel category = new ProductModel(); // khoi tao doi tuong CategoryModel


				category.setProductId(rs.getInt("productId")); // dua du lieu CateID trong RS sag CateID cua model
				category.setProductName(rs.getString("productName"));
				category.setProductCode(rs.getLong("productCode"));
				category.setCategoryid(rs.getInt("categoryId"));
				category.setDescription(rs.getString("description"));
				category.setPrice(rs.getDouble("price"));
				category.setAmount(rs.getInt("amount"));
				category.setStock(rs.getInt("stock"));
				category.setImage(rs.getString("images"));
				category.setWhislist(rs.getInt("wishlist"));
				category.setStatus(rs.getInt("status"));
				category.setCrateDate(rs.getDate("createDate"));
				category.setSellerid(rs.getInt("sellerId"));


				categories.add(category); // them vao danh sach List
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories; // tra ve danh sach
	}

	@Override
	public List<ProductModel> getNext3Product(int amount) {
		List<ProductModel> categories = new ArrayList<ProductModel>(); // tao mot list danh sach
		String sql = "SELECT * FROM product ORDER BY ProductID OFFSET ? \r\n"
				+ "ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			Connection conn = super.getConnection(); // ket noi database
			PreparedStatement ps = conn.prepareStatement(sql); // nem cau sql vao cho phat bieu preparestatement
			ps.setInt(1, amount);
			ResultSet rs = ps.executeQuery(); // executeUpdate voi cau lenh thay doi database (thuc thi cau sql tra ve ResultSet))

			while (rs.next()) { // doc tung hang trong bang RS dua vao Model
				ProductModel category = new ProductModel(); // khoi tao doi tuong CategoryModel


				category.setProductId(rs.getInt("productId")); // dua du lieu CateID trong RS sag CateID cua model
				category.setProductName(rs.getString("productName"));
				category.setProductCode(rs.getLong("productCode"));
				category.setCategoryid(rs.getInt("categoryId"));
				category.setDescription(rs.getString("description"));
				category.setPrice(rs.getDouble("price"));
				category.setAmount(rs.getInt("amount"));
				category.setStock(rs.getInt("stock"));
				category.setImage(rs.getString("images"));
				category.setWhislist(rs.getInt("wishlist"));
				category.setStatus(rs.getInt("status"));
				category.setCrateDate(rs.getDate("createDate"));
				category.setSellerid(rs.getInt("sellerId"));


				categories.add(category); // them vao danh sach List
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories; // tra ve danh sach
	}

}
