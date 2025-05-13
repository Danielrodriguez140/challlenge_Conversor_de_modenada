package API;

import Key.Key;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Convertidor {

    public String convertirMoneda(int opcion, Double monto) throws IOException {

        Key clave = new Key();

        String url_str = switch (opcion){
            case 1 -> "https://v6.exchangerate-api.com/v6/"+clave.getClave()+"/pair/USD/ARS/"+monto;
            case 2 -> "https://v6.exchangerate-api.com/v6/"+clave.getClave()+"/pair/ARS/USD/"+monto;
            case 3 -> "https://v6.exchangerate-api.com/v6/"+clave.getClave()+"/pair/USD/BRL/"+monto;
            case 4 -> "https://v6.exchangerate-api.com/v6/"+clave.getClave()+"/pair/BRL/USD/"+monto;
            case 5 -> "https://v6.exchangerate-api.com/v6/"+clave.getClave()+"/pair/USD/COP/"+monto;
            case 6 -> "https://v6.exchangerate-api.com/v6/"+clave.getClave()+"/pair/COP/USD/"+monto;
            default -> throw new IllegalStateException("Opcion incorrta");
          };





        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("conversion_result").getAsString();
        String moneda1 = jsonobj.get("base_code").getAsString();
        String moneda2 = jsonobj.get("target_code").getAsString();


        return "el valor de "+monto+"["+moneda1+"]"+" corresponde al valor final de ===>> "+req_result+" ["+moneda2+"]";


    }
}
