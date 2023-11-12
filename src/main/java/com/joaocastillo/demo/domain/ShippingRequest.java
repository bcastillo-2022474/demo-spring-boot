package com.joaocastillo.demo.domain;

import lombok.Getter;

@Getter
public class ShippingRequest {
    private double weight;
    private double width;
    private double height;
    private double length;
    private String destinationCountry;
    private String originCountry;
    private User user;
}
