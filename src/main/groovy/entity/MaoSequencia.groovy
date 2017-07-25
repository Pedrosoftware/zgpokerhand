package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoSequencia extends Mao{
    @Override
    boolean check(String paramCartas) {
        this.cartas = this.convertToListCartas(paramCartas)
        cartas = this.sortHand(cartas)
        return (isSequency(cartas) && !isSameNaipe(cartas) && isTotalParesEquals(0))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        if(this.determinarCartaMaisAlta(cartas).ordinal() > this.determinarCartaMaisAlta(opponent).ordinal()){
            return Result.WIN
        }else if(this.determinarCartaMaisAlta(cartas).ordinal() < this.determinarCartaMaisAlta(opponent).ordinal()){
            return Result.LOSS
        }
        return Result.DRAW
    }
}
