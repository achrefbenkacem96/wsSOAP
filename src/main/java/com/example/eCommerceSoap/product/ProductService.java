package com.example.eCommerceSoap.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product request) {
        productRepository.save(request);
    }
    @Transactional
    public void updateProduct(Product product, Long id) {
        Product updateProduct = productRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("product with id " + id + " does not exist")
        );

        if (product.getTitle() != null && product.getTitle().length() > 0 && !Objects.equals(updateProduct.getTitle(), product.getTitle())) {
            updateProduct.setTitle(product.getTitle());
        }
        if (product.getPrice() > 0 && !Objects.equals(updateProduct.getPrice(), product.getPrice())) {
            updateProduct.setPrice(product.getPrice());
        }
        if (product.getImage() != null && product.getImage().length() > 0 && !Objects.equals(updateProduct.getImage(), product.getImage())) {
            updateProduct.setImage(product.getImage());
        }
        if (product.getDescription() != null && product.getDescription().length() > 0 && !Objects.equals(updateProduct.getDescription(), product.getDescription())) {
            updateProduct.setDescription(product.getDescription());
        }
        if (product.getCategory() != null && product.getCategory().length() > 0 && !Objects.equals(updateProduct.getCategory(), product.getCategory())) {
            updateProduct.setCategory(product.getCategory());
        }
        if (product.getRating() != null) {
            Rating rating = updateProduct.getRating();
            if (product.getRating().getRate() > 0 && !Objects.equals(rating.getRate(), product.getRating().getRate())) {
                rating.setRate(product.getRating().getRate());
            }
            if (product.getRating().getCount() > 0 && !Objects.equals(rating.getCount(), product.getRating().getCount())) {
                rating.setCount(product.getRating().getCount());
            }
            updateProduct.setRating(rating);

        }
        productRepository.save(updateProduct);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Product with id " + id + " does not exist"));

        productRepository.delete(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
