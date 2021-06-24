package cl.tienditadelulu.catalogobe.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreciosEspecificosDto {

    private long id;
    private long idProducto;
    private double reduction;
    private String reductionType;
}
