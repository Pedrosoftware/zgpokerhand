package entity.reconhecedor

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoFullHouse extends Reconhecedor{

    MaoFullHouse() {
        this.categoria = Categoria.FULL_HOUSE
    }

    @Override
    boolean reconhecer() {
        return(!this.isSequencia(minhasCartas)
                && !this.isMesmoNaipe(minhasCartas)
                && this.isMaiorParLengthEquals(minhasCartas,3)
                && this.isTotalParesEquals(minhasCartas,2))
    }

}
