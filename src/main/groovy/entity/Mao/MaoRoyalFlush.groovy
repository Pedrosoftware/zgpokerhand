package entity.Mao

import entity.Carta
import entity.Categoria
import entity.Valor

/**
 * Created by pedro on 25/07/17.
 */
class MaoRoyalFlush extends Mao{
    MaoRoyalFlush(List<Carta> paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.ROYAL_FLUSH
    }

    @Override
    boolean check() {
        return(comparador.isSequencia(minhasCartas)
                && comparador.isMesmoNaipe(minhasCartas)
                && minhasCartas.get(minhasCartas.size()-1).valor == Valor.AIS)
    }
}
