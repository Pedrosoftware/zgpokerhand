package entity.reconhecedor

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoCartaAlta extends Reconhecedor{

    MaoCartaAlta() {
        this.categoria = Categoria.CARTA_ALTA
    }

    @Override
    boolean reconhecer() {
        return(!this.isSequencia(minhasCartas)
                && !this.isMesmoNaipe(minhasCartas)
                && this.isTotalParesEquals(minhasCartas, 0)
                && this.isMaiorParLengthEquals(minhasCartas, 0))
    }
}
