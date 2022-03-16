package entities;

public class Product {
    protected Integer code;
    protected String name;
    protected Double price;
    protected Double quantity;
    protected Double totalPrice;

    public Product() {
    }

    public Product(Integer code, String name, Double price, Double quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return price * quantity;
        }

    @Override
    public String toString() {
        return "\n Produto: " + name +
                ", Código de referência: " + code +
                ", Preço unitário: " + price +
                ", Quantidade disponível: " + quantity + '}';
    }
}
