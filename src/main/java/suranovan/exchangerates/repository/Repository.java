package suranovan.exchangerates.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import suranovan.exchangerates.model.Valute;

import java.io.IOException;
import java.net.URL;

@org.springframework.stereotype.Repository
public class Repository {

    @Value("${valute.data.url}")
    private String valuteDataUrl;

    /**
     * Метод для сохранения актуальных данных с сайта.
     * Обращается к JSON файлу с данными и парсит их.
     * @return Возвращает мапу с данными {@link Valute)}.
     * @throws IOException
     */
    public Valute getDataFromUrl() throws IOException {
        URL fileURI = new URL(valuteDataUrl);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fileURI, Valute.class);
    }
}
