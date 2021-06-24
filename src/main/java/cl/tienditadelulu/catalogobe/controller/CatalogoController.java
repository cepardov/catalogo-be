package cl.tienditadelulu.catalogobe.controller;

import cl.tienditadelulu.catalogobe.service.CatalogoService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/catalogo")
public class CatalogoController {

    final CatalogoService catalogoService;

    @GetMapping("/csv")
    public void obtenerCatalogo(@RequestParam(name = "product-active") boolean productActive, HttpServletResponse response) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        catalogoService.generaCatalogoCsv(productActive, response);
    }
}
