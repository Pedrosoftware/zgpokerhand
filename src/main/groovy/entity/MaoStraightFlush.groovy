package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoStraightFlush extends Mao{
    MaoStraightFlush(String paramCartas) {
        super(paramCartas)
    }
    @Override
    boolean check(String paramCartas) {
        return(isSequency(cartas)
                && isSameNaipe(cartas)
                && cartas.get(cartas.size()-1).valor != Valor.AIS)
    }

    @Override
    Result desempate(List<Carta> opponent) {
        Valor minhaCarta = determinarCartaMaisAlta(cartas)
        Valor cartaOponente = determinarCartaMaisAlta(opponent)
        if(minhaCarta > cartaOponente){
            return Result.WIN
        }else if(minhaCarta < cartaOponente){
            return Result.LOSS
        }
        return Result.DRAW
    }
}
