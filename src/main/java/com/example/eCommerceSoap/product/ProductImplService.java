package com.example.eCommerceSoap.product;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import java.util.List;

@Endpoint
@CrossOrigin(origins = "*", allowedHeaders = "*")
@WebService
public class ProductImplService {
    private final  ProductService productService;
    @Autowired
    public ProductImplService(ProductService productService) {
        this.productService = productService;
    }

    @WebMethod()
    public String addProduct(@WebParam(name = "product") Product product) {
        productService.addProduct(product);

        return "Product added successfully.";
    }
    @WebMethod()
    public String updateProduct(@WebParam(name = "product") Product product, @WebParam(name = "id") Long id) {
        productService.updateProduct(product, id);

        return "Product added updated.";
    }
    @WebMethod()
    public String deleteProduct(@WebParam(name = "id") Long id) {
        productService.deleteProduct( id);

        return "Product added updated.";
    }
    @WebMethod()
    public List<Product> getAllProducts() {


        return productService.getAllProducts();
    }

}
