package entity.Mao

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoQuadra extends Mao{
    MaoQuadra(List<Carta> paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.QUADRA
    }
    @Override
    boolean check() {
        return(!isSequencia(minhasCartas)
                && !isMesmoNaipe(minhasCartas)
                && isMaiorParLengthEquals(4))
    }
}
