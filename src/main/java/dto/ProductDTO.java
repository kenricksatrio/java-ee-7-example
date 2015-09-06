package dto;

public class ProductDTO {

    private Integer id;

    private String name;

    private int price;

    private ProductCategoryDTO category;

    public ProductDTO() { }

    public ProductDTO(Integer id, String name, int price, ProductCategoryDTO category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ProductCategoryDTO getCategory() {
        return category;
    }
}
