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
    Result desempate(List<Carta> opponent) {

        List<Carta> myCartas = getCartasSemPar(minhasCartas)
        List<Carta> opponentCartas = getCartasSemPar(opponent)

        for(int i = 0; i < myCartas.size(); i++){
            if(myCartas.get(i).valor > opponentCartas.get(i).valor){
                return Result.WIN
            }else if(myCartas.get(i).valor < opponentCartas.get(i).valor){
                return Result.LOSS
            }
        }
        return Result.DRAW
    }
}
