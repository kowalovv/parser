package org.example.parser.data;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

    @XmlAttribute(name = "id")
    private Long id;
    private String name;

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;



    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
