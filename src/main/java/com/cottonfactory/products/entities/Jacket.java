package com.cottonfactory.products.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Jacket {
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Id
    Long id;
    Season season;
    Size size;
    String color;
    Style style;
    Boolean adultSize;
    BigDecimal price;
    public Jacket() {

    }

    public Jacket(Season season, Size size, Style style, String color, Boolean adultSize, BigDecimal price) {
        this.season = season;
        this.size = size;
        this.style = style;
        this.color = color;
        this.adultSize = adultSize;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getAdultSize() {
        return adultSize;
    }

    public void setAdultSize(Boolean adultSize) {
        this.adultSize = adultSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Season getSeason() {
        return season;
    }

    public Size getSize() {
        return size;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

}
