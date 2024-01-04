package org.example.parser.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.example.parser.jaxbAdapters.LocalDateTimeAdapter;
import org.example.parser.jsonAdapters.TimeAdapter;

import java.time.LocalDateTime;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlAttribute(name = "id")
    private Long id;
    private Double amount;
    private String status;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @JsonDeserialize(using = TimeAdapter.class)
    private LocalDateTime startDate;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @JsonDeserialize(using = TimeAdapter.class)
    private LocalDateTime endDate;

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    private List<Product> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
