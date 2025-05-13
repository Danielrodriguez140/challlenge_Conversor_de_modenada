import API.Convertidor;

import java.io.IOException;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        Convertidor parDeMonedas = new Convertidor();
        Menu msjDeBienvenida = new Menu();
        int opcion = 1;

        while (opcion!=7){

            msjDeBienvenida.menuDeConvertivilidadDeMonedas();

            try{

                opcion = Integer.valueOf(lectura.nextLine());

                if(opcion<1 || opcion>7)   throw new IllegalStateException("Opcion incorrta");

                if(opcion==7) break;
                System.out.println("ingresa un valor a convertir: ");

                Double monto = Double.valueOf(lectura.nextLine());

                System.out.println(parDeMonedas.convertirMoneda(opcion,monto));
            }catch (IllegalStateException | NumberFormatException e){
                System.out.println(e.getMessage());
            }

        }



//        try{
//
//        }catch ()








    }
}
