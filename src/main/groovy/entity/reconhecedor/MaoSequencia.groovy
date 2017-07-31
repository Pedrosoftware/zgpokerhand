package entity.reconhecedor

import entity.Carta
import entity.Categoria

/**
 * Created by pedro on 25/07/17.
 */
class MaoSequencia extends Reconhecedor{
    MaoSequencia() {
        this.categoria = Categoria.SEQUENCIA
    }
    @Override
    boolean reconhecer() {
        return (this.isSequencia(minhasCartas)
                && !this.isMesmoNaipe(minhasCartas)
                && this.isTotalParesEquals(minhasCartas,0))
    }
}
