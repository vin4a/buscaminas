public class Casilla {

    int posFila;
    int posColumna;
    boolean mina;
    int minasAlrededor;

//----------------------------------------------------------------------------------------------------------------------


    //Constructor de las casillas
    //Pide posicion de Fila, posicion de Columnas, si HAY o NO mina y las casillas de alrededor
    public Casilla(int posFila, int posColumna, boolean mina) {
        this.posFila = posFila;
        this.posColumna = posColumna;
        this.minasAlrededor = 0;
        this.mina = mina;
    }

//----------------------------------------------------------------------------------------------------------------------

    //Hacemos los getters y setters
    public int getPosFila() {
        return posFila;
    }

//----------------------------------------------------------------------------------------------------------------------

    public void setPosFila(int posFila) {
        this.posFila = posFila;
    }

//----------------------------------------------------------------------------------------------------------------------

    public int getPosColumna() {
        return posColumna;
    }

//----------------------------------------------------------------------------------------------------------------------

    public void setPosColumna(int posColumna) {
        this.posColumna = posColumna;
    }

//----------------------------------------------------------------------------------------------------------------------

    public boolean getMina() {
        return mina;
    }


//----------------------------------------------------------------------------------------------------------------------

    public int getNumeroMinasAlrededor() {
        return this.minasAlrededor;
    }



//----------------------------------------------------------------------------------------------------------------------

    public void setMina(boolean mina) {
        this.mina = mina;
    }

//----------------------------------------------------------------------------------------------------------------------

    //Devuelve en forma de String si la casilla esta ocupada 'x' o si no está ocupada 'o'
    public String estadoCasilla(){

        String result;

        if(this.getMina()){
            result = "x";
        }else{
            result = "o";
        }
        return result;
    }



//----------------------------------------------------------------------------------------------------------------------

    public void incrementarMinasAlrededor(){
        this.minasAlrededor++;
    }

}
