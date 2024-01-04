package org.example.parser.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlAttribute(name = "id")
    private Long id;
    private String firstName;
    private String lastName;


    @XmlElementWrapper(name = "details")
    @XmlElement(name = "detail")
    @JsonProperty("details")
    private List<Detail> detail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }
}
