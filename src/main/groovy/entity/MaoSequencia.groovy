package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoSequencia extends Mao{
    MaoSequencia(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.SEQUENCIA
    }
    @Override
    boolean check(String paramCartas) {
        return (isSequency(minhasCartas) && !isSameNaipe(minhasCartas) && isTotalParesEquals(0))
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
