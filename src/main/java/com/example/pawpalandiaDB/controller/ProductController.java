package com.example.pawpalandiaDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawpalandiaDB.exceptions.ProductNotFoundException;
import com.example.pawpalandiaDB.model.ProductEntity;
import com.example.pawpalandiaDB.service.ProductService;

@RestController
@RequestMapping("/api/v4")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Método para mapear products
    @GetMapping("/products")
    public List<ProductEntity> getProducts() {
        return this.productService.getAll();
    }

    //Método para mapear getById() usando un PathVariable
    @GetMapping("/products/{id}")
    public ProductEntity findById(@PathVariable(name = "id") Long id) {
        return this.productService.getById(id);
    }

    //Método para crear un nuevo producto
    @PostMapping("/post-product")
    public ProductEntity newProduct(@RequestBody ProductEntity product){
        return this.productService.createProduct(product);
    }

    //Método para eliminar un producto mediante id
    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        this.productService.deleteUser(id);
    }

    //Método para actualizar un producto mediante mapeo en PUT
    
    @PutMapping("update-product/{id}")
	public ResponseEntity <ProductEntity> updateProduct(@RequestBody ProductEntity user, @PathVariable(name = "id") Long id){
		try{
			return ResponseEntity.ok(this.productService.updateUser(user, id));
		} catch(ProductNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
