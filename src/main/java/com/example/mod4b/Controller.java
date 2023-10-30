package com.example.mod4b;

import com.example.mod4b.models.Product;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class Controller {

    public ArrayList<Product> Products = new ArrayList<Product>();


    public Controller(){
        Products.add(new Product(1, "Product1", 100.00, 1));
    }


    @GetMapping("/product")
    public ResponseEntity<List<Product>> GetProducts(){
        try{
            return ResponseEntity.ok(Products);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Product>> GetProductById(@PathVariable int id){
        try{
            return ResponseEntity.ok(Products.stream().filter(x -> x.id == id).findFirst());
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
