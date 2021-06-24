package cl.tienditadelulu.catalogobe.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ProductosDto {

    private long id;
    private String ean13;
    private double price;
    private int active;
    private String condition;
    private String visibility;
    private Date availableDate;
    private String name;
    private String metaDescription;
    private int quantity;
    private String link;
    private List<PreciosEspecificosDto> preciosEspecificos;
    private List<ImagenesDto> imagenes;
}
