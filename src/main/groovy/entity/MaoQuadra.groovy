package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoQuadra extends Mao{
    MaoQuadra(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.QUADRA
    }
    @Override
    boolean check(String paramCartas) {
        return(!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isMaiorParLengthEquals(4))
    }
}
