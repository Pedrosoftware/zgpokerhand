package entity.reconhecedor

import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoQuadra extends Reconhecedor{

    MaoQuadra() {
        this.categoria = Categoria.QUADRA
    }
    @Override
    boolean reconhecer() {
        return(!this.isSequencia(minhasCartas)
                && !this.isMesmoNaipe(minhasCartas)
                && this.isMaiorParLengthEquals(minhasCartas,4))
    }
}
