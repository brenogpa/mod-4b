package com.example.mod4b;

import com.example.mod4b.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class Controller {

    public ArrayList<Product> Products = new ArrayList<Product>();


    public Controller(){
        Products.add(new Product(1, "Product1", 100.00, 1));
    }


    @GetMapping("/product")
    public ArrayList<Product> GetProducts(){
        return Products;
    }
    
}
