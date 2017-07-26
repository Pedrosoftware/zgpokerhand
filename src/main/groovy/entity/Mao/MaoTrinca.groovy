package entity.Mao

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoTrinca extends Mao{
    MaoTrinca(List<Carta> paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.TRINCA
    }
    @Override
    boolean check() {
        return (!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isMaiorParLengthEquals(3)
                && isTotalParesEquals(1))
    }
}
