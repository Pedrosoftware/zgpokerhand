package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoDoisPares extends Mao {

    MaoDoisPares(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.DOIS_PARES
    }

    @Override
    boolean check(String paramCartas) {
        return (!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isTotalParesEquals(2)
                && isMaiorParLengthEquals(2))
    }

    @Override
    protected isPercorrerSomenteKickerNoDesempate() {
        return false
    }
}
