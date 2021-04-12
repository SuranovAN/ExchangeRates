package suranovan.exchangerates.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suranovan.exchangerates.service.DataService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/some")
public class MainController {

    @Value("${top.exchange.rates}")
    private int limit;

    final DataService service;

    public MainController(DataService service) {
        this.service = service;
    }

    /**
     * Метод для вывода пять валют, курс которых изменился сильнее всего за прошедшие сутки.
     * @return лист с изменениями валют.
     * @throws IOException
     */
    @GetMapping("/someEndpoint")
    public ResponseEntity<List<String>> getTopFiveValuteExchangeRates() throws IOException {
        return service.getExchangeRates(limit);
    }
}
