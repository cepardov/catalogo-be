package cl.tienditadelulu.catalogobe.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatalogoCsvDto {

    @CsvBindByName(column = "id")
    private long sku; //SKU

    @CsvBindByName(column = "title")
    private String title; //150 max

    @CsvBindByName(column = "description")
    private String description; //5.000 max

    @CsvBindByName(column = "availability")
    private String availability; //in stock, available for order, out of stock

    @CsvBindByName(column = "condition")
    private String condition; //new, refurbished, used

    @CsvBindByName(column = "price")
    private String price; // 100 CLP

    @CsvBindByName(column = "sale_price")
    private String salePrice; // 100 CLP

    @CsvBindByName(column = "link")
    private String link;

    @CsvBindByName(column = "image_link")
    private String imageLink; //http://www.jaspersmarket.com/products/shirt.jpg

    @CsvBindByName(column = "additional_image_link")
    private String additionalImageLink; //http://www.jaspersmarket.com/products/shirt.jpg,http://www.jaspersmarket.com/products/shirt.jpg

    @CsvBindByName(column = "brand")
    private String brand; //100 max

    @CsvBindByName(column = "visibility")
    private String visibility; //published, hidden

    @CsvBindByName(column = "google_product_category")
    private String googleTaxonomy;

}
