package cl.tienditadelulu.catalogobe.client;

import cl.tienditadelulu.catalogobe.configuration.ServiceConfiguration;
import cl.tienditadelulu.catalogobe.dto.ProductsReqDto;
import cl.tienditadelulu.catalogobe.dto.ProductsResDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class ProductsRestClientImpl implements ProductsRestClient{

    final RestTemplate restTemplate;
    final ServiceConfiguration serviceConfiguration;

    @Override
    public ProductsResDto obtenerCatalogo(ProductsReqDto productsReqDto) {
        ResponseEntity<ProductsResDto> responseEntity = restTemplate.postForEntity(
                serviceConfiguration.getProductsUrl(), productsReqDto, ProductsResDto.class);
        return responseEntity.getBody();
    }
}
