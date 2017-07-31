package entity.reconhecedor

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoUmPar extends Reconhecedor{
    MaoUmPar() {
        this.categoria = Categoria.UM_PAR
    }
    @Override
    boolean reconhecer() {

        return(!this.isSequencia(minhasCartas)
                && !this.isMesmoNaipe(minhasCartas)
                && this.isTotalParesEquals(minhasCartas,1)
                && this.isMaiorParLengthEquals(minhasCartas,2))
    }

}
