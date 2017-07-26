package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoCartaAlta extends Mao{

    MaoCartaAlta(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.CARTA_ALTA
    }

    @Override
    boolean check(String paramCartas) {
        return(!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isTotalParesEquals(0)
                && isMaiorParLengthEquals(1))
    }

    @Override
    protected isPercorrerSomenteKickerNoDesempate() {
        return false
    }
}
