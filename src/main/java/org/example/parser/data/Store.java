package org.example.parser.data;


import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "store")
@XmlAccessorType(XmlAccessType.FIELD)
public class Store {

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order")
    private List<Order> orders;



    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}






