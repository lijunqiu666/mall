package whut.mall.entity;

public class ProductQuery {
    private Long StockID;
    private String image;

    public ProductQuery() {
    }

    public ProductQuery(Long stockID, String image) {
        StockID = stockID;
        this.image = image;
    }

    public Long getStockID() {
        return StockID;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "ProductQuery{" +
                "StockID=" + StockID +
                ", image='" + image + '\'' +
                '}';
    }

    public void setStockID(Long stockID) {
        StockID = stockID;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
