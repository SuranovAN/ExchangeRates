package suranovan.exchangerates.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import suranovan.exchangerates.model.Entity;
import suranovan.exchangerates.repository.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DataService {

    final Repository repository;

    public DataService(Repository repository) {
        this.repository = repository;
    }

    /**
     * Метод для поиска 5 валют с наибольшими изменениями за последний день.
     * @param limit для ограничения выводимого результата.
     * @return Лист с изменениями с валютой за сутки.
     * @throws IOException
     */
    public ResponseEntity<List<Double>> getExchangeRates(int limit) throws IOException {
        var data = repository.getDataFromUrl();
        double a = 0d;
        List<Double> list = new ArrayList<>();
        for (Map.Entry<String, Entity> entity : data.getEntityMap().entrySet()) {
            var rates = Math.abs(entity.getValue().value - entity.getValue().previous);
            list.add(rates);
        }

        return ResponseEntity.ok().body(
                list.stream().sorted(Comparator.reverseOrder()).limit(limit).collect(Collectors.toList()));
    }
}
