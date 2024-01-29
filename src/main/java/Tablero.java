import java.lang.Math.*;

public class Tablero {

    //Crearemos una varible matriz llamada 'casillas' de tipo Casillas, pero no la inicializamos
    Casilla[][] casillas;
    int numFilas;
    int numColumnas;
    int totalCasillas = getNumColumnas() * getNumFilas();

//----------------------------------------------------------------------------------------------------------------------


    //Constructor del tablero
    //Cuando hagamos Tablero tablero = new Tablero(numFilas,numColumnas) llenaremos las fils y cols
    public Tablero( int numFilas, int numColumnas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
    }

//----------------------------------------------------------------------------------------------------------------------


    //Creamos el tablero, hay que recordar que teniamos una matriz vacia y rellenamos con los objetos casillas
    public void generarTablero(){
        this.casillas = new Casilla[numFilas][numColumnas]; //La variable matriz casillas la inicializamos
        for(int filas = 0; filas < numFilas; filas++){
            for (int columnas = 0; columnas < numColumnas; columnas++){
                casillas[filas][columnas] = new Casilla(filas,columnas,false);
                //Recorremos cada casilla e inicializamos los objetos casillas
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    //Pide número de minas como argumento
    //Usando la clase Random, se generara una columna y una fila aleatoria para colocar dicha mina
    //Se comprobará que esa casilla no está ocupada antes de poner una mina

    public void generarMinas(int numeroMinas){
        assert numeroMinas >= 1 && numeroMinas < this.totalCasillas;

        int contador = 0;

        //Usamos un while para que no recorra el programa entero
        while (contador < numeroMinas){

            int randPosFilas = Utilidades.generarNumAleatorioRango(0, this.numFilas);
            int randPosColumna = Utilidades.generarNumAleatorioRango(0, this.numColumnas);

            //Comprueba, solo pondrá mina si previamente no habia antes
            //Subiremos el contador porque se ha colocado una mina efectivamente
            if(!casillas[randPosFilas][randPosColumna].getMina()){
                casillas[randPosFilas][randPosColumna].setMina(true);
                contador++;
            }

        }
        //Luego de crear el tablero y ponerle las minas, actualizamos los números alrededor
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


        //Este método devuelve un Array de 8 elementos porque son 8 los que rodean una casilla
        Casilla[] casillaAlrededor = new Casilla[8];

        for(int i = 0; i < 8; i++){

            int tmpPosFila = posFila;
            int tmpPosColumna = posColumna;

            //El switch nos devuelve las posiciones de fils y cols
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


            //Luego si no se sale del rango, ni es 0, la metemos al Array, sino se mete un null al Array
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

                if(casillas[i][j].getMina()){ //if TRUE creamos la lista de sus 8 casillas de alrededor
                    Casilla[] casillasAlrededor = this.obtenerCasillasAlrededor(i,j);

                    //Lo que busca este metodo es incrementar los valores de las casillas de al rededor
                    //Si no es null, incrementa el valor de la mina que en un inicio era 0
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
