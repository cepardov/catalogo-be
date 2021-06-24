package cl.tienditadelulu.catalogobe.service;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CatalogoService {

    void generaCatalogoCsv(boolean productActive, HttpServletResponse response) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;
}
