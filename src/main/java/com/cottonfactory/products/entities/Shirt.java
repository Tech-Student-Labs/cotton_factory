package com.cottonfactory.products.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Shirt {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private TYPE type;
    private int sleeve;
    private int neck;
    private String size;
    private String customSize;
    private String color;
    private boolean longSleeve;
    private BigDecimal price;

    public Shirt() {
    }

    public Shirt(TYPE type, int sleeve, int neck, String size, String customSize, String color, boolean longSleeve, BigDecimal price) {
        this.type=type;
        this.sleeve=sleeve;
        this.neck=neck;
        this.size=size;
        this.customSize=customSize;
        this.color=color;
        this.longSleeve=longSleeve;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public int getSleeve() {
        return sleeve;
    }

    public void setSleeve(int sleeve) {
        this.sleeve = sleeve;
    }

    public int getNeck() {
        return neck;
    }

    public void setNeck(int neck) {
        this.neck = neck;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCustomSize() {
        return customSize;
    }

    public void setCustomSize(String customSize) {
        this.customSize = customSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLongSleeve() {
        return longSleeve;
    }

    public void setLongSleeve(boolean longSleeve) {
        this.longSleeve = longSleeve;
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
        if (o == null || getClass() != o.getClass()) return false;
        Shirt shirt = (Shirt) o;
        return getSleeve() == shirt.getSleeve() &&
                getNeck() == shirt.getNeck() &&
                isLongSleeve() == shirt.isLongSleeve() &&
                Objects.equals(getId(), shirt.getId()) &&
                getType() == shirt.getType() &&
                Objects.equals(getSize(), shirt.getSize()) &&
                Objects.equals(getCustomSize(), shirt.getCustomSize()) &&
                Objects.equals(getColor(), shirt.getColor()) &&
                Objects.equals(getPrice(), shirt.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getSleeve(), getNeck(), getSize(), getCustomSize(), getColor(), isLongSleeve(), getPrice());
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id=" + id +
                ", type=" + type +
                ", sleeve=" + sleeve +
                ", neck=" + neck +
                ", size='" + size + '\'' +
                ", customSize='" + customSize + '\'' +
                ", color='" + color + '\'' +
                ", longSleeve=" + longSleeve +
                ", price=" + price +
                '}';
    }

    public enum TYPE{
        TEE, DRESS, POLO, HENLEY
    }
}
