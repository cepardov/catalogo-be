package cl.tienditadelulu.catalogobe.client;

import cl.tienditadelulu.catalogobe.dto.ProductsReqDto;
import cl.tienditadelulu.catalogobe.dto.ProductsResDto;

public interface ProductsRestClient {

    ProductsResDto obtenerCatalogo(ProductsReqDto productsReqDto);
}
