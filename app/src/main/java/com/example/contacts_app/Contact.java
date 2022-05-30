package com.example.contacts_app;

import java.io.Serializable;

public class Contact implements Serializable {
    String name,phone,city,contactCreated;
    int imageResource;

    public Contact(String name, String phone, String city, String contactCreated, int imageResource) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.contactCreated = contactCreated;
        this.imageResource = imageResource;
    }
}
