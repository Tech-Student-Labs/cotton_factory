package com.cottonfactory.products.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Pants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int inseam;
    private int waist;
    private String size;
    private String color;
    private String designer;
    private BigDecimal price;

    public Pants() {
    }

    public Pants(int inseam, int waist, String size, String color, String designer, BigDecimal price) {
        this.inseam = inseam;
        this.waist = waist;
        this.size = size;
        this.color = color;
        this.designer = designer;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInseam() {
        return inseam;
    }

    public void setInseam(int inseam) {
        this.inseam = inseam;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pants{" +
                "id=" + id +
                ", inseam=" + inseam +
                ", waist=" + waist +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", designer='" + designer + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pants pants = (Pants) o;
        return inseam == pants.inseam &&
                waist == pants.waist &&
                Objects.equals(id, pants.id) &&
                Objects.equals(size, pants.size) &&
                Objects.equals(color, pants.color) &&
                Objects.equals(designer, pants.designer) &&
                Objects.equals(price, pants.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inseam, waist, size, color, designer, price);
    }

}
