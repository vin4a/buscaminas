import java.lang.Math.*;

public class Tablero {

    Casilla[][] casillas;
    int numFilas;
    int numColumnas;
    int totalCasillas = getNumColumnas() * getNumFilas();

//----------------------------------------------------------------------------------------------------------------------

    public Tablero( int numFilas, int numColumnas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
    }

//----------------------------------------------------------------------------------------------------------------------

    public void generarTablero(){
        this.casillas = new Casilla[numFilas][numColumnas];
        for(int filas = 0; filas < numFilas; filas++){
            for (int columnas = 0; columnas < numColumnas; columnas++){
                casillas[filas][columnas] = new Casilla(filas,columnas,false);
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    //Pide número de minas como argumento
    //Usando la clase Math.rand, se generara una columna y una fila aleatoria para colocar dicha mina
    //Se comprobará que esa casilla no está ocupada antes de desanotar una mina

    public void generarMinas(int numeroMinas){
        assert numeroMinas >= 1 && numeroMinas < this.totalCasillas;

        int contador = 0;

        while (contador < numeroMinas){

            int randPosFilas = Utilidades.generarNumAleatorioRango(0, this.numFilas);
            int randPosColumna = Utilidades.generarNumAleatorioRango(0, this.numColumnas);

            if(!casillas[randPosFilas][randPosColumna].getMina()){
                casillas[randPosFilas][randPosColumna].setMina(true);
                contador++;
            }

        }
        this.actualizarNumeroMinasAlrededor();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void imprimirTalblero(){

        for(int fila = 0; fila < getNumFilas(); fila++){
            for (int columna = 0; columna < getNumColumnas(); columna++){
                System.out.print(casillas[fila][columna].estadoCasilla() + "   "); //importante ver que es print normal
            }
            System.out.println(""); // importante que se añade el salto de linea
        }
    }



//----------------------------------------------------------------------------------------------------------------------

    public void imprimirPistas(){

        for(int fila = 0; fila < getNumFilas(); fila++){
            for (int columna = 0; columna < getNumColumnas(); columna++){
                System.out.print(casillas[fila][columna].getNumeroMinasAlrededor() + "   "); //importante ver que es print normal
            }
            System.out.println(""); // importante que se añade el salto de linea
        }
    }



//----------------------------------------------------------------------------------------------------------------------

    private Casilla[] obtenerCasillasAlrededor(int posFila, int posColumna){

        Casilla[] casillaAlrededor = new Casilla[8];

        for(int i = 0; i < 8; i++){

            int tmpPosFila = posFila;
            int tmpPosColumna = posColumna;

            switch (i){
                case 0:
                        tmpPosFila--;
                    break;
                case 1:
                        tmpPosFila--; tmpPosColumna++;
                    break;
                case 2:
                        tmpPosColumna++;
                    break;
                case 3:
                        tmpPosFila++; tmpPosColumna++;
                    break;
                case 4:
                        tmpPosFila++;
                    break;
                case 5:
                        tmpPosFila++; tmpPosColumna--;
                    break;
                case 6:
                        tmpPosColumna--;
                    break;
                case 7:
                        tmpPosFila--; tmpPosColumna--;
                    break;

            }

            if(tmpPosFila >= 0 && tmpPosFila < this.numFilas && tmpPosColumna >= 0 && tmpPosColumna < this.numColumnas){
                casillaAlrededor[i] = this.casillas[tmpPosFila][tmpPosColumna];
            }
        }

        return casillaAlrededor;
    }

//----------------------------------------------------------------------------------------------------------------------

    private void actualizarNumeroMinasAlrededor(){

        for (int i = 0; i < this.numFilas; i++){
            for (int j = 0; j < this.numColumnas; j++){

                if(casillas[i][j].getMina()){
                    Casilla[] casillasAlrededor = this.obtenerCasillasAlrededor(i,j);

                    for(int k = 0; k < casillasAlrededor.length; k++){
                        if(casillasAlrededor[k] != null){
                            casillasAlrededor[k].incrementarMinasAlrededor();
                        }
                    }


                }
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    public int getNumFilas() {
        return numFilas;
    }

//----------------------------------------------------------------------------------------------------------------------


    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

//----------------------------------------------------------------------------------------------------------------------


    public int getNumColumnas() {
        return numColumnas;
    }

//----------------------------------------------------------------------------------------------------------------------


    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

//----------------------------------------------------------------------------------------------------------------------

}
