package entity

/**
 * Created by pedro on 19/07/17.
 */
class Carta {

    private String valor
    private String naipe
    int numCarta

    Carta(String valor, char naipe) {
        this.valor = valor
        this.naipe = naipe
    }

    String getValor(){
        return valor
    }

    String getNaipe(){
        return naipe
    }
}
