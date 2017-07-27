package entity.Mao

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoCartaAlta extends Mao{

    MaoCartaAlta(List<Carta> paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.CARTA_ALTA
    }

    @Override
    boolean check() {
        return(!comparador.isSequencia(minhasCartas)
                && !comparador.isMesmoNaipe(minhasCartas)
                && comparador.isTotalParesEquals(minhasCartas, 0)
                && comparador.isMaiorParLengthEquals(minhasCartas, 0))
    }

}
