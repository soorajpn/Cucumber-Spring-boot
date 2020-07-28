package com.sooraj.study.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.sooraj.study.domain.Stock} entity.
 */
public class StockDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private Long noOfStock;


    private Long productId;

    private Long storeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNoOfStock() {
        return noOfStock;
    }

    public void setNoOfStock(Long noOfStock) {
        this.noOfStock = noOfStock;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StockDTO stockDTO = (StockDTO) o;
        if (stockDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stockDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StockDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", noOfStock=" + getNoOfStock() +
            ", productId=" + getProductId() +
            ", storeId=" + getStoreId() +
            "}";
    }
}
