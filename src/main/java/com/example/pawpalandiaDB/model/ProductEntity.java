package com.example.pawpalandiaDB.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "code", length = 13, nullable = false, unique = true)
    private String code;
    
    @Column(name = "product_name", length = 50, nullable = false, unique = false)
    private String productName; 
    
    @Column(name = "description", length = 100, nullable = false, unique = false)
    private String description; 

    @Column(name = "url", length = 100, nullable = false, unique = false)
    private String url;

    @Column(name = "price", nullable = false, unique = false)
    private BigDecimal price;

    @Column(name = "price_pawpal", nullable = false, unique = false)
    private BigDecimal pricePawpal;

    @Column(name = "category", length = 50, nullable = false, unique = false)
    private String category;

    @Column(name = "is_inventoried", nullable = false, unique = false)
    private Boolean isInventoried;

    @Column(name = "quantity", nullable = false, unique = false)
    private Integer quantity;

    @Column(name = "quantity_minimum", nullable = false, unique = false)
    private Integer quantityMinimum;

    //Constructor JPA
    public ProductEntity() {

    }

    //Constructor
    public ProductEntity(Long idProduct, String code, String productName, String description, String url,
            BigDecimal price, BigDecimal pricePawpal, String category, Boolean isInventoried, Integer quantity,
            Integer quantityMinimum) {
        this.idProduct = idProduct;
        this.code = code;
        this.productName = productName;
        this.description = description;
        this.url = url;
        this.price = price;
        this.pricePawpal = pricePawpal;
        this.category = category;
        this.isInventoried = isInventoried;
        this.quantity = quantity;
        this.quantityMinimum = quantityMinimum;
    }

    //Getters and setters
    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPricePawpal() {
        return pricePawpal;
    }

    public void setPricePawpal(BigDecimal pricePawpal) {
        this.pricePawpal = pricePawpal;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsInventoried() {
        return isInventoried;
    }

    public void setIsInventoried(Boolean isInventoried) {
        this.isInventoried = isInventoried;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityMinimum() {
        return quantityMinimum;
    }

    public void setQuantityMinimum(Integer quantityMinimum) {
        this.quantityMinimum = quantityMinimum;
    }

    //toString
    @Override
    public String toString() {
        return "ProductEntity [idProduct=" + idProduct + ", code=" + code + ", productName=" + productName
                + ", description=" + description + ", url=" + url + ", price=" + price + ", pricePawpal=" + pricePawpal
                + ", category=" + category + ", isInventoried=" + isInventoried + ", quantity=" + quantity
                + ", quantityMinimum=" + quantityMinimum + "]";
    }

    //hashCode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((pricePawpal == null) ? 0 : pricePawpal.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((isInventoried == null) ? 0 : isInventoried.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((quantityMinimum == null) ? 0 : quantityMinimum.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductEntity other = (ProductEntity) obj;
        if (idProduct == null) {
            if (other.idProduct != null)
                return false;
        } else if (!idProduct.equals(other.idProduct))
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (pricePawpal == null) {
            if (other.pricePawpal != null)
                return false;
        } else if (!pricePawpal.equals(other.pricePawpal))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (isInventoried == null) {
            if (other.isInventoried != null)
                return false;
        } else if (!isInventoried.equals(other.isInventoried))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        if (quantityMinimum == null) {
            if (other.quantityMinimum != null)
                return false;
        } else if (!quantityMinimum.equals(other.quantityMinimum))
            return false;
        return true;
    }

    
    
    

}
