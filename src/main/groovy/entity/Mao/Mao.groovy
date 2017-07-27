package entity.Mao

import entity.Carta
import entity.Categoria
import entity.Conversor
import entity.Grupo
import entity.Result

/**
 * Created by pedro on 19/07/17.
 */
abstract class Mao {

    protected Categoria categoria
    protected List<Carta> minhasCartas

    Mao(List<Carta> cartas) {
        minhasCartas = cartas
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

    protected static boolean isMesmoNaipe(List<Carta> paramCartas) {
        return paramCartas.groupBy { it.naipe }.size() == 1
    }

    protected static boolean isSequencia(List<Carta> paramCartas) {
        boolean isSequencia = true
        int numCartaAtual = (paramCartas.get(0).valor.ordinal() - 1)

        paramCartas.each {
            if (it.valor.ordinal() == (numCartaAtual + 1)) {
                numCartaAtual = it.valor.ordinal()
            } else {
                isSequencia = false
                return isSequencia
            }
        }
        return isSequencia
    }

    protected boolean isMaiorParLengthEquals(int qtd) {
        List<Grupo> grupos = Conversor.listaToGrupo(minhasCartas)
        if(grupos.size() > 0){
            return (grupos.get(0).qtd == qtd)
        }
        return (qtd == 0)
    }

    protected boolean isTotalParesEquals(int qtd) {
        return (Conversor.listaToGrupo(minhasCartas).size() == qtd)
    }
}