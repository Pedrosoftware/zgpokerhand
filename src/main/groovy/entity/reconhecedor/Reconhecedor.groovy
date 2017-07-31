package entity.reconhecedor

import entity.Carta
import entity.Categoria
import entity.Conversor
import entity.Grupo

/**
 * Created by pedro on 27/07/17.
 */
abstract class Reconhecedor {

    protected List<Carta> minhasCartas
    protected Categoria categoria

    abstract boolean reconhecer()

    boolean isMesmoNaipe(List<Carta> paramCartas) {
        return paramCartas.groupBy { it.naipe }.size() == 1
    }

    boolean isSequencia(List<Carta> paramCartas) {
        int numCartaAtual = (paramCartas.get(0).valor.ordinal() - 1)

        for(carta in paramCartas){
            if (carta.valor.ordinal() == (numCartaAtual + 1)) {
                numCartaAtual = carta.valor.ordinal()
            } else {
                return false
            }
        }
        return true
    }

    boolean isMaiorParLengthEquals(List<Carta> cartas, int qtd) {
        List<Grupo> grupos = Conversor.listaToGrupo(cartas)
        if(grupos.size() > 0){
            return (grupos.get(0).qtd == qtd)
        }
        return (qtd == 0)
    }

    boolean isTotalParesEquals(List<Carta> cartas, int qtd) {
        return (Conversor.listaToGrupo(cartas).size() == qtd)
    }

    void setCartas(List<Carta> cartas){
        this.minhasCartas = cartas
    }

    Categoria getCategoria(){
        return this.categoria
    }
}
