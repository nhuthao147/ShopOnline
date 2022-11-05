package vn.iotstar.Models;

import java.util.Date;

public class ProductModel {

	public ProductModel(int productId, String productName, Long productCode, int categoryid, String description,
			Double price, int amount, int stock, String image, int whislist, int status, Date crateDate, int sellerid,
			CategoryModel category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.categoryid = categoryid;
		this.description = description;
		this.price = price;
		this.amount = amount;
		this.stock = stock;
		this.image = image;
		this.whislist = whislist;
		this.status = status;
		this.crateDate = crateDate;
		this.sellerid = sellerid;
		this.category = category;
	}

	public ProductModel() {}
	

	private int productId;
	private String productName;
	private Long productCode;
	private int categoryid;
	private String description;
	private Double price;
	private int amount;
	private int stock;
	private String image;
	private int whislist;
	private int status;
	private Date crateDate;
	private int sellerid;
	
	private CategoryModel category;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}
	
	public String getSpecialImage() {
		int index = image.lastIndexOf("/");
		String img = image.substring(index);
		return img;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public int getWhislist() {
		return whislist;
	}

	public void setWhislist(int whislist) {
		this.whislist = whislist;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCrateDate() {
		return crateDate;
	}
	
	public void setCrateDate(Date crateDate) {
		this.crateDate = crateDate;
	}

	public int getSellerid() {
		return sellerid;
	}

	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}
}
