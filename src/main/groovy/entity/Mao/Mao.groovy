package entity.Mao

import entity.Carta
import entity.Categoria
import entity.Comparador
import entity.Conversor
import entity.Grupo
import entity.Result

/**
 * Created by pedro on 19/07/17.
 */
abstract class Mao {

    protected Categoria categoria
    protected List<Carta> minhasCartas
    protected Comparador comparador

    Mao(List<Carta> cartas) {
        minhasCartas = cartas
        comparador = new Comparador()
    }

    Result compareWith(Mao opponent) {
        int minhaForca = this.categoria.ordinal()
        int oponenteForca = opponent.categoria.ordinal()

        if (minhaForca > oponenteForca) {
            return Result.WIN
        } else if (minhaForca < oponenteForca) {
            return Result.LOSS
        }
        return this.desempate(opponent.minhasCartas)
    }

    abstract boolean check()

    private Result desempate(List<Carta> cartasOponente) {
        List<Carta> myCartas = Conversor.listaCompletaToListaSemDuplicidade(minhasCartas)
        List<Carta> opponentCartas = Conversor.listaCompletaToListaSemDuplicidade(cartasOponente)

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