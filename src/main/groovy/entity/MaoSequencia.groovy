package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoSequencia extends Mao{
    MaoSequencia(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.SEQUENCIA
    }
    @Override
    boolean check(String paramCartas) {
        return (isSequency(minhasCartas) && !isSameNaipe(minhasCartas) && isTotalParesEquals(0))
    }
}
