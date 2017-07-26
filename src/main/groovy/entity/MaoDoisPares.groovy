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
    Result desempate(List<Carta> opponent) {

        Result resultado = desempatar(getCartasComPar(minhasCartas), getCartasComPar(opponent))
        if (resultado != null) {
            return resultado
        }
        resultado = desempatar(getCartasSemPar(minhasCartas), getCartasSemPar(opponent))
        if (resultado != null) {
            return resultado
        }
        return Result.DRAW
    }

    private Result desempatar(List<Carta> myCartas, List<Carta> opponentCartas) {
        for (int i = 0; i < myCartas.size(); i++) {
            if (myCartas.get(i).valor > opponentCartas.get(i).valor) {
                return Result.WIN
            } else if (myCartas.get(i).valor < opponentCartas.get(i).valor) {
                return Result.LOSS
            }
        }
        return null
    }
}
