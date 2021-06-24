package cl.tienditadelulu.catalogobe.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductsReqDto {

    private boolean productActive;
}
