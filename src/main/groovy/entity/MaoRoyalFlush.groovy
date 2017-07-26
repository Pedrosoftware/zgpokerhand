package entity;

import java.util.List;

/**
 * Created by pedro on 25/07/17.
 */
class MaoRoyalFlush extends Mao{
    MaoRoyalFlush(String paramCartas) {
        super(paramCartas)
    }
    @Override
    Result desempate(List<Carta> opponent) {
        return Result.WIN
    }

    @Override
    boolean check(String paramCartas) {
        cartas = this.convertToListCartas(paramCartas)
        cartas = this.sortHand(cartas)
        return(isSequency(cartas)
                && isSameNaipe(cartas)
                && cartas.get(cartas.size()-1).valor == Valor.AIS)
    }
}
