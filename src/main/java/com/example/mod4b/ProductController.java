package com.example.mod4b;

import com.example.mod4b.models.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    public ArrayList<Product> products = new ArrayList<Product>();


    public ProductController(){
        products.add(new Product(1, "Product1", 100.00, 1));
    }


    @GetMapping
    public ResponseEntity<List<Product>> GetProducts(){
        try{
            return ResponseEntity.ok(products);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> GetProductById(@PathVariable int id){
        try{
            return ResponseEntity.ok(products.stream().filter(x -> x.id == id).findFirst());
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Product> AddProduct(@RequestBody Product product){
        try{
            products.add(product);
            return  ResponseEntity.ok(product);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> UpdateProduct(@RequestBody Product product, @PathVariable int id){
        try{
            Product p = products.stream().filter(x -> x.id == id).findAny().get();
            p.description = product.description;
            p.price = product.price;
            p.stock = product.stock;
            return ResponseEntity.ok(p);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> DeleteProduct(@PathVariable int id){
        try{
            Product p = products.stream().filter(x -> x.id == id).findAny().get();
            products.remove(p);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
