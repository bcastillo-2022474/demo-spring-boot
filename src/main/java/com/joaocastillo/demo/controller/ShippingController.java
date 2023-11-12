package com.joaocastillo.demo.controller;

import com.joaocastillo.demo.domain.ShippingRequest;
import com.joaocastillo.demo.domain.UserType;
import com.joaocastillo.demo.service.CountryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/shipping")
@RestController
public class ShippingController {

    private final CountryService countryService;

    public ShippingController(CountryService countryService) {
        this.countryService = countryService;
    }

    private double calculateCost(double weight, double rate, double height, double length, double width, double discount) {
        return (weight * rate) + 1.66 * height * length * width - discount * 0.5 * weight;
    }

    private double calculateDiscount(UserType userType) {
        if (userType == UserType.ADMIN) return 10.0;
        if (userType == UserType.COMMON) return 5.0;
        return 0.0;
    }

    @PostMapping("/calculate")
    public double calculateShipping(@RequestBody ShippingRequest request) {
        double rate = countryService.getRateForCountry(request.getDestinationCountry());
        double discount = request.getUser() == null ? 0.0 : calculateDiscount(request.getUser().getUserType());
        return calculateCost(request.getWeight(), rate, request.getHeight(), request.getLength(), request.getWidth(), discount);
    }
}
