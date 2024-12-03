package com.example.pawpalandiaDB.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pawpalandiaDB.exceptions.ProductNotFoundException;
import com.example.pawpalandiaDB.model.ProductEntity;
import com.example.pawpalandiaDB.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    //Inyectar en el constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Método para obtener todos los productos
    public List<ProductEntity> getAll() { 
        return productRepository.findAll(); 
    }

    //Método para obtener un producto por id
    public ProductEntity getById(Long id) {
		return this.productRepository.findById(id)
				.orElseThrow(()-> new ProductNotFoundException(id));
	}

    //Método para registrar un nuevo producto
    public ProductEntity createProduct(ProductEntity newProduct) {
		return this.productRepository.save(newProduct);
	} 

    //Método para eliminar un producto mediante id
    public void deleteUser(Long id) {
		if (this.productRepository.existsById(id)) {
			this.productRepository.deleteById(id);
		} else {
			throw new ProductNotFoundException(id);
		}
	}

    //Método para actualizar un producto usando mapeo en PUT
    public ProductEntity updateUser(ProductEntity product, Long id) {
        return this.productRepository.findById(id).map(productMap ->{
            productMap.setCode(product.getCode());
            productMap.setProductName(product.getProductName());
            productMap.setDescription(product.getDescription());
            productMap.setUrl(product.getUrl());
            productMap.setPrice(product.getPrice());
            productMap.setPricePawpal(product.getPricePawpal());
            productMap.setCategory(product.getCategory());
            productMap.setIsInventoried(product.getIsInventoried());
            productMap.setQuantity(product.getQuantity());
            productMap.setQuantityMinimum(product.getQuantityMinimum());
            return this.productRepository.save(productMap);
        })
        .orElseThrow(()->new ProductNotFoundException(id));
    }
}
