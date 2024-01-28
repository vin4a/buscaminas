public class Main {

    public static void main(String[] args) {


        int numFilas = 10;
        int numColumnas = 10;
        int numMinas = 1;


        Tablero tablero = new Tablero(numFilas,numColumnas);
        tablero.generarTablero();
        tablero.generarMinas(numMinas);
        tablero.imprimirTalblero();
        System.out.println("------------------------------------------------------");
        tablero.imprimirPistas();

        App app = new App(numFilas,numColumnas,numMinas);
        app.starter();
    }

}
