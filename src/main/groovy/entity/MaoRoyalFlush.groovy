package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoRoyalFlush extends Mao{
    MaoRoyalFlush(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.ROYAL_FLUSH
    }

    @Override
    boolean check(String paramCartas) {
        return(isSequency(minhasCartas)
                && isSameNaipe(minhasCartas)
                && minhasCartas.get(minhasCartas.size()-1).valor == Valor.AIS)
    }
}
