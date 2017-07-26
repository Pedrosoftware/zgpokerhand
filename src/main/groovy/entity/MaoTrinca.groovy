package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoTrinca extends Mao{
    MaoTrinca(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.TRINCA
    }
    @Override
    boolean check(String paramCartas) {
        return (!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isMaiorParLengthEquals(3)
                && isTotalParesEquals(1))
    }
}
