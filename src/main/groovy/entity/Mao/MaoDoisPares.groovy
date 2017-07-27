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
        return (!comparador.isSequencia(minhasCartas)
                && !comparador.isMesmoNaipe(minhasCartas)
                && comparador.isTotalParesEquals(minhasCartas, 2)
                && comparador.isMaiorParLengthEquals(minhasCartas,2))
    }

}
