package entity.reconhecedor

import entity.Carta
import entity.Categoria
import entity.Valor

/**
 * Created by pedro on 25/07/17.
 */
class MaoStraightFlush extends Reconhecedor{
    MaoStraightFlush() {
        this.categoria = Categoria.STRAIGHT_FLUSH
    }
    @Override
    boolean reconhecer() {
        return(this.isSequencia(minhasCartas)
                && this.isMesmoNaipe(minhasCartas)
                && minhasCartas.get(minhasCartas.size()-1).valor != Valor.AIS)
    }
}
