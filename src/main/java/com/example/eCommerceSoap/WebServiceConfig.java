package com.example.eCommerceSoap;



import com.example.eCommerceSoap.product.ProductImplService;
import com.example.eCommerceSoap.product.ProductRepository;
import com.example.eCommerceSoap.product.ProductService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {
    private final ProductRepository productRepository;

    public WebServiceConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public ProductImplService myWebService() {
        ProductService p = new ProductService(productRepository) ;
        return new ProductImplService(p);
    }

    @Bean
    public Endpoint endpoint() {
        return Endpoint.publish("http://localhost:8081/myWebService", myWebService());

    }

    @Bean
    public SpringBus bus() {
        return new SpringBus();
    }
}
