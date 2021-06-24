package cl.tienditadelulu.catalogobe.configuration;

import cl.tienditadelulu.catalogobe.dto.ProductBlackListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties("service")
public class ServiceConfiguration {

    private String productsUrl;
    private ProductBlackListDto productBlackList;
}
