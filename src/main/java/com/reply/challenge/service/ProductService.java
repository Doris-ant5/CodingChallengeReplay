package com.reply.challenge.service;

import com.reply.challenge.exception.InvalidPriceException;
import com.reply.challenge.exception.ProductNameExistsException;
import com.reply.challenge.exception.ProductResourceNotFoundException;
import com.reply.challenge.model.Category;
import com.reply.challenge.model.Product;
import com.reply.challenge.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepo;
    public ProductService(ProductRepository productRepo) {
        super();
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductResourceNotFoundException(getNotFoundProductIdErrorMessage(id));
        }
        return productOptional.get();
    }

    public Product searchProductByName (String name) {
        Optional<Product> productOptional = productRepo.findProductByName(name);
        if(productOptional.isEmpty()) {
            throw new ProductResourceNotFoundException(getNotFoundNameErrorMessage(name));
        }
        return productOptional.get();
    }

    public List<Product> searchProductByCategory (Category category) {
        List<Product> products = productRepo.findProductsByCategory(category);
        if(products.isEmpty()) {
            throw new ProductResourceNotFoundException(getNotFoundCategoryErrorMessage(category.toString()));
        }
        return products;
    }

    public Product addProduct(Product product) {
        Optional<Product> productOptional = productRepo.findProductByName(product.getName());
        if (productOptional.isPresent()) {
            throw new ProductNameExistsException("Product with name of " + product.getName() + " already exists.");
        }
        return productRepo.save(product);
    }

    public void deleteProductById(int id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductResourceNotFoundException(getNotFoundProductIdErrorMessage(id));
        }
        productRepo.deleteById(id);
    }

    public Product updateProductById (Product product, int id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductResourceNotFoundException(getNotFoundProductIdErrorMessage(id));
        }
        validateProductPrice(product);
        product.setId(id);
        return productRepo.save(product);
    }

    public void validateProductPrice(Product product) throws InvalidPriceException {
        if (product.getPrice() != null && product.getPrice() > 1000) {
            throw new InvalidPriceException("The price of the product must not be more than 1,000.");
        }
    }

    private String getNotFoundCategoryErrorMessage(String category) {
        return "Product with category " + category + " not found.";
    }

    private String getNotFoundNameErrorMessage(String name) {
        return "Product with name " + name + " not found.";
    }

    private String getNotFoundProductIdErrorMessage(int id) {
        return "Product with id " + id + " not found.";
    }
    
}
