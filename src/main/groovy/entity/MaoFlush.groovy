package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoFlush extends Mao {

    MaoFlush(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.FLUSH
    }

    @Override
    boolean check(String paramCartas) {
        return (!isSequency(minhasCartas)
                && isSameNaipe(minhasCartas)
                && isTotalParesEquals(0))
    }
}
