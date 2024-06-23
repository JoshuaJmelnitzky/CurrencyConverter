import Models.Conversion;
import Models.HistoricalRecord;
import Utils.RequestApi;
import Utils.OptionMenu;
import Utils.ValidateNumber;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistoricalRecord historicalRecord = new HistoricalRecord();
        OptionMenu optionMenu = new OptionMenu();
        ValidateNumber validateNumber = new ValidateNumber();
        RequestApi requestApi = new RequestApi();
        int op = 0;

        do {
            optionMenu.currencyOptions();
            System.out.println("Ingrese el número de la opción que desea consultar: ");

            try {
                op = validateNumber.validate(1, scanner.nextInt(), 10);
                if (op == 9) {
                    System.out.println("Historial de conversiones:");
                    for (Conversion conversion : historicalRecord.getConversions()) {
                        System.out.println(conversion.getTime() + conversion.getBase_code() + " a " + conversion.getTarget_code() + " => " + "Tasa: " + conversion.getConversion_rate() + " Unidades consultadas: " + conversion.getQty() +  " Total: " + conversion.getTotal());
                    }
                    continue;
                }

                Conversion result = requestApi.getConversion(op);

                System.out.println("Ingrese el valor de cuanto desea convertir: ");

                float qty = scanner.nextFloat();
                float total = Float.parseFloat(result.getConversion_rate()) * qty;

                System.out.println(result.getTime() + "El valor " + qty + " [" + result.getBase_code() + "] corresponde al valor final de =>> " + total + " [" + result.getTarget_code() + "]");
                result.setTotal(total);
                result.setQty(qty);
                historicalRecord.addConversion(result);


            } catch (IOException | InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Se debe escribir un numero");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }while(op != 10);

        scanner.close();
    }
}
