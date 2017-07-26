package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoStraightFlush extends Mao{
    MaoStraightFlush(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.STRAIGHT_FLUSH
    }
    @Override
    boolean check(String paramCartas) {
        return(isSequency(minhasCartas)
                && isSameNaipe(minhasCartas)
                && minhasCartas.get(minhasCartas.size()-1).valor != Valor.AIS)
    }
}
