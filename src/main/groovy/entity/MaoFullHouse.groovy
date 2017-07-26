package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoFullHouse extends Mao{

    MaoFullHouse(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.FULL_HOUSE
    }

    @Override
    boolean check(String paramCartas) {
        return(!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isMaiorParLengthEquals(3)
                && isTotalParesEquals(2))
    }

    @Override
    protected isPercorrerSomenteKickerNoDesempate() {
        return false
    }
}
