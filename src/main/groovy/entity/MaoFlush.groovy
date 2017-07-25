package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoFlush extends Mao {
    @Override
    boolean check(String paramCartas) {
        cartas = convertToListCartas(paramCartas)
        cartas = this.sortHand(cartas)
        return (!isSequency(cartas) && isSameNaipe(cartas) && isTotalParesEquals(0))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        if(determinarCartaMaisAlta(cartas).ordinal() > determinarCartaMaisAlta(opponent).ordinal()){
            return Result.WIN
        }else if(determinarCartaMaisAlta(cartas).ordinal() > determinarCartaMaisAlta(opponent).ordinal()){
            return Result.LOSS
        }
        return Result.DRAW
    }
}
