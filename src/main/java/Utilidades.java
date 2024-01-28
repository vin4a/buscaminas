import java.util.Random;

public class Utilidades {


    public static int generarNumAleatorioRango(int rangoInicial, int rangoFinal){
        Random random = new Random();
        return rangoInicial + random.nextInt(rangoFinal - rangoInicial);
    }



}
