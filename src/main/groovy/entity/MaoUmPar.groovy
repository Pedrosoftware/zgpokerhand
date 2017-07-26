package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoUmPar extends Mao{
    MaoUmPar(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.UM_PAR
    }
    @Override
    boolean check(String paramCartas) {

        return(!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isTotalParesEquals(1)
                && isMaiorParLengthEquals(2))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        Valor cartaMeuPar = this.getCartasComPar(minhasCartas).get(0).valor
        Valor cartaParOponente = this.getCartasComPar(minhasCartas).get(0).valor

        if(cartaMeuPar > cartaParOponente){
            return Result.WIN
        }else if(cartaMeuPar < cartaParOponente){
            return Result.LOSS
        }

        List<Carta> myCartas = this.getCartasSemPar(minhasCartas)
        List<Carta> opponentCartas = this.getCartasSemPar(opponent)

        for(int i = 0; i < myCartas.size(); i++){
            cartaMeuPar = myCartas.get(i).valor
            cartaParOponente = opponentCartas.get(i).valor
            if(cartaMeuPar > cartaParOponente){
                return Result.WIN
            }else if(cartaMeuPar < cartaParOponente){
                return Result.LOSS
            }
        }
        return Result.DRAW
    }
}
