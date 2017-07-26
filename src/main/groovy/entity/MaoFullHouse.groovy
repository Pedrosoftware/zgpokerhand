package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoFullHouse extends Mao{

    MaoFullHouse(String paramCartas) {
        super(paramCartas)
    }

    @Override
    boolean check(String paramCartas) {
        return(!isSequency(cartas)
                && !isSameNaipe(cartas)
                && isMaiorParLengthEquals(3)
                && isTotalParesEquals(2))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        return null
    }
}
