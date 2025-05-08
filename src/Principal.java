import API.Convertidor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        Convertidor parDeMonedas = new Convertidor();
        Menu msjDeBienvenida = new Menu();

//        try{
//
//        }catch ()


        msjDeBienvenida.menuDeConvertivilidadDeMonedas();
        int opcion = Integer.valueOf(lectura.nextLine());
        System.out.println("ingresa un valor a convertir: ");
        Double monto = Double.valueOf(lectura.nextLine());

        System.out.println(parDeMonedas.convertirMoneda(opcion,monto));






    }
}
