package entities;

import java.util.Objects;

public class Product {
    protected int code;
    protected String name;
    protected Double price;
    protected Double totalPrice;

    public Product() {
    }

    public Product(Integer code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
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


    @Override
    public String toString() {
        return "\n Produto: " + name +
                ", Código de referência: " + code +
                ", Preço unitário: " + price +
                 '}';
    }

}
