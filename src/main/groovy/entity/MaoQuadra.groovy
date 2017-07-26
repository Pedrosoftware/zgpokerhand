package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoQuadra extends Mao{
    MaoQuadra(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.QUADRA
    }
    @Override
    boolean check(String paramCartas) {
        return(!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isMaiorParLengthEquals(4))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        if(minhasCartas.get(minhasCartas.size()-1).valor > opponent.get(minhasCartas.size()-1).valor){
            return Result.WIN
        }else if(minhasCartas.get(minhasCartas.size()-1).valor < opponent.get(minhasCartas.size()-1).valor){
            return Result.LOSS
        }
        return Result.DRAW
    }
}
