package com.example.demo.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Article;
import com.example.demo.entity.Facture;
import com.example.demo.entity.Order;
import com.paypal.api.payments.Payment;

@FeignClient(name = "PaypalService", url = "localhost:9090" )
public interface PaymentRestClient {
	@GetMapping("/")
	public String home ();
}

