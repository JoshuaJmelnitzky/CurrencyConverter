package Utils;

import Models.Conversion;
import Models.CurrencyPair;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestApi {

    public Conversion getConversion (int op) throws IOException, InterruptedException {
        String apiKey = "85cdf36b7616c8cc01c62c43";
        CurrencyPair currencyPair = getCurrencyPair(op);
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+currencyPair.source()+"/"+currencyPair.target();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Conversion conversion = new Gson().fromJson(json, Conversion.class);
        conversion.setTime(conversion.currentTime());
        return conversion;
    }

    public CurrencyPair getCurrencyPair (int op) {
        return switch (op) {
            case 1 -> new CurrencyPair("USD", "ARS");
            case 2 -> new CurrencyPair("ARS", "USD");
            case 3 -> new CurrencyPair("USD", "BRL");
            case 4 -> new CurrencyPair("BRL", "USD");
            case 5 -> new CurrencyPair("USD", "COP");
            case 6 -> new CurrencyPair("COP", "USD");
            case 7 -> new CurrencyPair("USD", "CUP");
            case 8 -> new CurrencyPair("CUP", "USD");
            default -> throw new IllegalArgumentException("Opción no válida");
        };
    }
}
