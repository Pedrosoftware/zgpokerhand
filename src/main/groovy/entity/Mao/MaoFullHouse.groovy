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
        return(!isSequencia(minhasCartas)
                && !isMesmoNaipe(minhasCartas)
                && isMaiorParLengthEquals(3)
                && isTotalParesEquals(2))
    }

}
