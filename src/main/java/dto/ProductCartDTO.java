package dto;

/**
 * Created by ks on 06/09/15.
 */
public class ProductCartDTO {

    private int productId;

    private String productName;

    private String category;

    private int price;

    private int qty;

    public ProductCartDTO(int productId, String productName, String category, int price, int qty) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.qty = qty;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public int getProductId() {
        return productId;
    }
}
