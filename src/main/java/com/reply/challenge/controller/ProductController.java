package com.reply.challenge.controller;

import com.reply.challenge.exception.CategoryNotFound;
import com.reply.challenge.model.Category;
import com.reply.challenge.model.Product;
import com.reply.challenge.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @Operation(
            summary = "Retrieving all products resources",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Json list of products resources in body of response.",
                            content = {@Content(mediaType = "application/json")}
                    )
            }
    )

    @GetMapping
    public ResponseEntity<List<Product>> getProduct() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAllProducts());
    }

    @Operation(
            summary = "Finds and returns a single product resource by the supplied id.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product resource successfully found and returned as json object in."
                                    + " Body of the response.",
                            content = {@Content(mediaType = "application/json")}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product resource not found.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductById(id));
    }

    @Operation(
            summary = "Finds and returns array of products resource by the supplied attribute which is name.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Products resource successfully found and returned as json object in."
                                    + " Body of the response.",
                            content = {@Content(mediaType = "application/json")}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Products with specific name not found.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

    @GetMapping("searchProductByName/{name}") //api/v1/products/searchProductByName/{name}
    private ResponseEntity<Product> getProductName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.searchProductByName(name));
    }

    @Operation(
            summary = "Finds and returns array of products resource by the supplied attribute which is category.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Products resource successfully found and returned as json object in."
                                    + " Body of the response.",
                            content = {@Content(mediaType = "application/json")}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Products with specific category not found.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

    @GetMapping("searchProductByCategory") //api/v1/products/searchProductByCategory{category}
    private ResponseEntity<List<Product>> getProductCategory(@RequestParam("category") String categoryString) {
        Category category;
        try {
            category = Category.valueOf(categoryString);
        } catch (IllegalArgumentException e) {
            throw new CategoryNotFound("Category " + categoryString + " not found.");
        }

        List<Product> products = productService.searchProductByCategory(category);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.searchProductByCategory(category));
    }

    @Operation(
            summary = "Creating a new product resource.",
            description = "Accepts and validates a products object passed via body of the request. Checks that the id "
                    + "is not already present in persistence context. Then saves new product resource. " + "Please note " +
                    " that you cannot add product price bigger than 1000.",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Product created.",
                            content = {@Content(mediaType = "application/json")},
                            headers = {@Header(
                                    name = "Location",
                                    description = "URI of new product resource."
                            )}
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Product with such name is already present.",
                            content = {@Content(mediaType = "text/plain")}
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Supplied product is invalid, returns CSV string with validation errors.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()         // http://localhost:80xx/api/v1/products
                .path("/{id}")                // http://localhost:80xx/api/v1/products/{id}
                .buildAndExpand(product.getId()) // http://localhost:80xx/api/v1/products/4
                .toUri();
        return ResponseEntity
                .created(location)
                .body(product);
    }

    @Operation(
            summary = "Updating a new product resource.",
            description = "Accepts and validates a product object passed via body of the request. Checks that the id "
                    + "is not already present in persistence context. Then saves updated product resource." + "Please note " +
                    " that you cannot add product price bigger than 1000.",
            method = "PUT",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product updated.",
                            content = {@Content(mediaType = "application/json")}

                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Supplied product is invalid, returns CSV string with validation errors.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product, @PathVariable int id) {
        return ResponseEntity.ok(productService.updateProductById(product, id));
    }

    @Operation(
            summary = "Deleting existing product resource.",
            description = "Accepts and validates a product object passed via body of the request. Checks id.",
            method = "DELETE",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product deleted.",
                            content = {@Content(mediaType = "application/json")}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product resource not found.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @Operation(
            summary = "Finds and returns an updated single product (price and amount in stock) resource by the supplied id.",
            method = "PATCH",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product resource successfully found and returned as json object in."
                                    + " Body of the response.",
                            content = {@Content(mediaType = "application/json")}
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Supplied price is invalid, returns CSV string with validation errors.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProductByPriceOrAmount(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }

        if (updatedProduct.getPrice() != null) {
            existingProduct.setPrice(updatedProduct.getPrice());
        }
        if (updatedProduct.getAmountInStock() != null) {
            existingProduct.setAmountInStock(updatedProduct.getAmountInStock());
        }

        return ResponseEntity.ok(productService.updateProductById(existingProduct, id));
    }

}
