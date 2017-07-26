package entity.Mao

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoDoisPares extends Mao {

    MaoDoisPares(List<Carta> paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.DOIS_PARES
    }

    @Override
    boolean check() {
        return (!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isTotalParesEquals(2)
                && isMaiorParLengthEquals(2))
    }

    @Override
    protected isPercorrerSomenteKickerNoDesempate() {
        return false
    }
}
