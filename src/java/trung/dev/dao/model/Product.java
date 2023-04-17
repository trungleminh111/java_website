package trung.dev.dao.model;

import java.sql.Timestamp;

public class Product {

    private int id;
    private String name;
    private String description;
    private String img;

    private double price;
    private int quantity;
    private int view;
    private int categoryId;
    private Timestamp createdAt;

    public Product(String name, String description, String img, double price, int quantity, int view, int categoryId,
            Timestamp createdAt) {
        super();
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.view = view;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
    }

    public Product(int id, String name, String description, String img,
            double price, int quantity, int view, int categoryId,
            Timestamp createdAt) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.view = view;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String Created_at() {
        // TODO Auto-generated method stub
        return null;
    }

}
