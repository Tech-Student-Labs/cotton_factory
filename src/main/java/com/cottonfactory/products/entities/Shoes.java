package com.cottonfactory.products.entities;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
@Table(name = "cotton_factory")
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String size;
    String height;
    String type;
    String material;
    String designer;
    Boolean laced;
    BigDecimal price;
    public Shoes() {
    }
    public Shoes(String size, String height, String type, String material, String designer, Boolean laced, BigDecimal price) {
        this.size = size;
        this.height = height;
        this.type = type;
        this.material = material;
        this.designer = designer;
        this.laced = laced;
        this.price = price;
    }
    public Shoes(Long id, String size, String height, String type, String material, String designer, Boolean laced, BigDecimal price) {
        this.id = id;
        this.size = size;
        this.height = height;
        this.type = type;
        this.material = material;
        this.designer = designer;
        this.laced = laced;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getDesigner() {
        return designer;
    }
    public void setDesigner(String designer) {
        this.designer = designer;
    }
    public Boolean getLaced() {
        return laced;
    }
    public void setLaced(Boolean laced) {
        this.laced = laced;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shoes)) return false;
        Shoes shoes = (Shoes) o;
        return Objects.equals(id, shoes.id) &&
                Objects.equals(size, shoes.size) &&
                Objects.equals(height, shoes.height) &&
                Objects.equals(type, shoes.type) &&
                Objects.equals(material, shoes.material) &&
                Objects.equals(designer, shoes.designer) &&
                Objects.equals(laced, shoes.laced) &&
                Objects.equals(price, shoes.price);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, size, height, type, material, designer, laced, price);
    }
}
