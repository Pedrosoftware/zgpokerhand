package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoSequencia extends Mao{
    MaoSequencia(String paramCartas) {
        super(paramCartas)
    }
    @Override
    boolean check(String paramCartas) {
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
