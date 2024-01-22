package ua.com.alevel.entity;

// DATA CLASS
public class Product extends BaseEntity {
    private String productName;
    private int productPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String fn) {
        this.productName = fn;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        if (productPrice > 0 ) {
            this.productPrice = productPrice;
        }
    }
}