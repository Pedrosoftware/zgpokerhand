package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoUmPar extends Mao{

    @Override
    boolean check(String paramCartas) {
        cartas = convertToListCartas(paramCartas)
        cartas = this.sortHand(cartas)
        return(!isSequency(cartas)
                && !isSameNaipe(cartas)
                && isTotalParesEquals(1)
                && isMaiorParLengthEquals(2))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        if(getCartasSemPar(cartas).get(0).valor.ordinal() > getCartasSemPar(opponent).get(0).valor.ordinal()){
            return Result.WIN
        }else if(getCartasSemPar(cartas).get(0).valor.ordinal() < getCartasSemPar(opponent).get(0).valor.ordinal()){
            return Result.LOSS
        }
        return Result.DRAW
    }
}
