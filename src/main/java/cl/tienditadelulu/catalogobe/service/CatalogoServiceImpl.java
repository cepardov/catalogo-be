package cl.tienditadelulu.catalogobe.service;

import cl.tienditadelulu.catalogobe.client.ProductsRestClient;
import cl.tienditadelulu.catalogobe.configuration.ServiceConfiguration;
import cl.tienditadelulu.catalogobe.dto.CatalogoCsvDto;
import cl.tienditadelulu.catalogobe.dto.ProductsReqDto;
import cl.tienditadelulu.catalogobe.dto.ProductsResDto;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CatalogoServiceImpl implements CatalogoService{

    final ProductsRestClient productsRestClient;
    final ServiceConfiguration serviceConfiguration;

    @Override
    public void generaCatalogoCsv(boolean productActive, HttpServletResponse response) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        log.info("Se inicia obtencion de catalogo desde Faceboo a " + LocalDateTime.now());
        List<Long> blackListProductIds = serviceConfiguration.getProductBlackList().getProductIds();
        List<CatalogoCsvDto> catalogoCsvDtoList = new ArrayList<>();

        ProductsReqDto productsReqDto = ProductsReqDto.builder()
                .productActive(productActive)
                .build();

        ProductsResDto productsResDto = productsRestClient.obtenerCatalogo(productsReqDto);

        if (null != productsResDto && !productsResDto.getProductos().isEmpty()) {
            productsResDto.getProductos()
                    .forEach(productosDto -> {
                CatalogoCsvDto catalogoCsvDto = CatalogoCsvDto.builder()
                        .sku(productosDto.getId())
                        .title(productosDto.getName() == null ? "": productosDto.getName().replaceAll(",", " "))
                        .description(productosDto.getMetaDescription())
                        .availability(availability(productosDto.getQuantity()))
                        .condition(productosDto.getCondition())
                        .price((int) productosDto.getPrice() + " CLP")
                        .link(productosDto.getLink())
                        .imageLink(productosDto.getImagenes().get(0).getImageLink())
                        .brand(productosDto.getManufacturer())
                        .visibility(visibility(productosDto.getActive()))
                        .googleTaxonomy("Health & Beauty > Personal Care > Cosmetics")
                        .build();
                catalogoCsvDtoList.add(catalogoCsvDto);
            });

            blackListProductIds.forEach(prodductId -> catalogoCsvDtoList.removeIf(catalogoCsvDto -> catalogoCsvDto.getSku() == prodductId));

            String filename = "catalogo.csv";
            response.setContentType("text/csv");
            response.setCharacterEncoding("UTF-8");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
            StatefulBeanToCsv<CatalogoCsvDto> beanWriter = new StatefulBeanToCsvBuilder<CatalogoCsvDto>(response.getWriter()).build();
            beanWriter.write(catalogoCsvDtoList);
        }
    }

    private String visibility(int active) {
        if (active == 1) {
            return "published";
        } else {
            return "hidden";
        }
    }

    private String availability(int quantity) {
        if (quantity > 0) {
            return "in stock";
        } else {
            return "out of stock";
        }
    }
}
