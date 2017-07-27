package entity.Mao

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoFullHouse extends Mao{

    MaoFullHouse(List<Carta> paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.FULL_HOUSE
    }

    @Override
    boolean check() {
        return(!comparador.isSequencia(minhasCartas)
                && !comparador.isMesmoNaipe(minhasCartas)
                && comparador.isMaiorParLengthEquals(minhasCartas,3)
                && comparador.isTotalParesEquals(minhasCartas,2))
    }

}
