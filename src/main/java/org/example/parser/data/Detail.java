package org.example.parser.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Detail {

    @XmlAttribute(name = "id")
    private Long id;
    private String address;


    @XmlElement(name = "phoneNumber")
    @JsonProperty("phoneNumber")
    private String numberPhone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return numberPhone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.numberPhone = phoneNumber;
    }
}
