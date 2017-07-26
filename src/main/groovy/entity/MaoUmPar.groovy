package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoUmPar extends Mao{
    MaoUmPar(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.UM_PAR
    }
    @Override
    boolean check(String paramCartas) {

        return(!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isTotalParesEquals(1)
                && isMaiorParLengthEquals(2))
    }

    @Override
    protected isPercorrerSomenteKickerNoDesempate() {
        return false
    }
}
