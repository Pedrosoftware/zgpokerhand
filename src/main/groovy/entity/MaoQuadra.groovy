package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoQuadra extends Mao{

    @Override
    boolean check(String paramCartas) {
        this.cartas = this.convertToListCartas(paramCartas)
        cartas = this.sortHand(cartas)
        return(!isSequency(cartas)
                && !isSameNaipe(cartas)
                && isMaiorParLengthEquals(4))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        if(cartas.get(cartas.size()-1).valor > opponent.get(cartas.size()-1).valor){
            return Result.WIN
        }else if(cartas.get(cartas.size()-1).valor < opponent.get(cartas.size()-1).valor){
            return Result.LOSS
        }
        return Result.DRAW
    }
}
