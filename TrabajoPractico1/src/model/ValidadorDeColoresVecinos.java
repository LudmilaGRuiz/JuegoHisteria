package model;

public class ValidadorDeColoresVecinos {

    public ValidadorDeColoresVecinos() {
    }


    public Boolean validar(Celda[][] grilla, Celda celda) {
        return esValidoVertical(grilla, celda) && esValidoHorizontal(grilla, celda);
    }

    private Boolean esValidoHorizontal(Celda[][] grilla, Celda celda)
    {
        int x = celda.getCoordX();
        int y = celda.getCoordY();

        boolean validaDerecha = y+1 < grilla[0].length;
        boolean validaIzquierda = y -1 >= 0;

        boolean esValido = true;

        if(validaDerecha)
        { // si se cumple que este dentro de la matriz
            Celda celdaDerecha = grilla[x][y+1];
            esValido &= !celdaDerecha.getColor().equals(celda.getColor());

        }
        if(validaIzquierda)
        {
            Celda celdaIzquierda= grilla[x][y-1];
            esValido &= !celdaIzquierda.getColor().equals(celda.getColor());
        }

        return esValido;
    }

    private Boolean esValidoVertical(Celda[][] grilla, Celda celda)
    {
        // TODO validar en caso de los extremos no nos tire un indexOutOfBounds (grilla.lenght)
        int x = celda.getCoordX();
        int y = celda.getCoordY();

        boolean validaArriba = x - 1 >= 0;
        boolean validaAbajo = x + 1 < grilla.length;

        boolean esValido= true;

        if(validaArriba)
        {
            Celda celdaArriba = grilla[x - 1][y];
            esValido &= !celdaArriba.getColor().equals(celda.getColor());
        }
        if(validaAbajo)
        {
            Celda celdaAbajo = grilla[x+ 1][y];
            esValido &= !celdaAbajo.getColor().equals(celda.getColor());
        }

        return  esValido;

    }


}
