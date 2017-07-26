package entity.Mao

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoUmPar extends Mao{
    MaoUmPar(List<Carta> paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.UM_PAR
    }
    @Override
    boolean check() {

        return(!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isTotalParesEquals(1)
                && isMaiorParLengthEquals(2))
    }

    @Override
    protected isPercorrerSomenteKickerNoDesempate() {
        return false
    }
}
