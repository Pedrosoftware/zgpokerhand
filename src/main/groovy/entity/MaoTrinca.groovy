package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoTrinca extends Mao{
    @Override
    boolean check(String paramCartas) {
        this.cartas = this.convertToListCartas(paramCartas)
        cartas = this.sortHand(cartas)
        return (!isSequency(cartas)
                && !isSameNaipe(cartas)
                && isMaiorParLengthEquals(3)
                && isTotalParesEquals(1))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        if(this.getCartasSemPar(this.cartas) > this.getCartasSemPar(opponent)){
            return Result.WIN
        }else if(this.getCartasSemPar(this.cartas) < this.getCartasSemPar(opponent)){
            return Result.LOSS
        }
        return Result.DRAW
    }
}
