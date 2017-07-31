package entity.reconhecedor

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoDoisPares extends Reconhecedor {

    MaoDoisPares() {
        this.categoria = Categoria.DOIS_PARES
    }

    @Override
    boolean reconhecer() {
        return (!this.isSequencia(minhasCartas)
                && !this.isMesmoNaipe(minhasCartas)
                && this.isTotalParesEquals(minhasCartas, 2)
                && this.isMaiorParLengthEquals(minhasCartas,2))
    }

}
