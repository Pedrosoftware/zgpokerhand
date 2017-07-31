package entity.reconhecedor

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoTrinca extends Reconhecedor{
    MaoTrinca() {
        this.categoria = Categoria.TRINCA
    }
    @Override
    boolean reconhecer() {
        return (!this.isSequencia(minhasCartas)
                && !this.isMesmoNaipe(minhasCartas)
                && this.isMaiorParLengthEquals(minhasCartas,3)
                && this.isTotalParesEquals(minhasCartas,1))
    }
}
