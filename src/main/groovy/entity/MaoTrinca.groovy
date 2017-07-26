package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoTrinca extends Mao{
    MaoTrinca(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.TRINCA
    }
    @Override
    boolean check(String paramCartas) {
        return (!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isMaiorParLengthEquals(3)
                && isTotalParesEquals(1))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        Valor minhaCarta = getCartasSemPar(minhasCartas).get(0).valor
        Valor cartaOponente = getCartasSemPar(opponent).get(0).valor
        if(minhaCarta > cartaOponente){
            return Result.WIN
        }else if(minhaCarta < cartaOponente){
            return Result.LOSS
        }
        return Result.DRAW
    }
}
