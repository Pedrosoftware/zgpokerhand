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
    Result desempate(List<Carta> opponent) {
        return Result.DRAW
    }

    @Override
    boolean check(String paramCartas) {
        minhasCartas = this.convertToListCartas(paramCartas)
        minhasCartas = this.sortHand(minhasCartas)
        return(isSequency(minhasCartas)
                && isSameNaipe(minhasCartas)
                && minhasCartas.get(minhasCartas.size()-1).valor == Valor.AIS)
    }
}
