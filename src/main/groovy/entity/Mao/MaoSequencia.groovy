package entity.Mao

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoSequencia extends Mao{
    MaoSequencia(List<Carta> paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.SEQUENCIA
    }
    @Override
    boolean check() {
        return (isSequencia(minhasCartas) && !isMesmoNaipe(minhasCartas) && isTotalParesEquals(0))
    }
}
