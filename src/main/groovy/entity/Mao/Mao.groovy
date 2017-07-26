package entity.Mao

import entity.Carta
import entity.Categoria
import entity.Conversor
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

    protected isPercorrerSomenteKickerNoDesempate(){
        return true
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

    private Result desempate(List<Carta> opponent) {
        List<Carta> myCartas
        List<Carta> opponentCartas
        if(isPercorrerSomenteKickerNoDesempate()){
            myCartas = getCartasSemGrupo(minhasCartas)
            opponentCartas = getCartasSemGrupo(opponent)
        }else{
            myCartas = getCartasDoMaiorGrupoAteKickerSemRepeticao(minhasCartas)
            opponentCartas = getCartasDoMaiorGrupoAteKickerSemRepeticao(opponent)
        }

        for(int i = 0; i < myCartas.size(); i++){
            if(myCartas.get(i).valor > opponentCartas.get(i).valor){
                return Result.WIN
            }else if(myCartas.get(i).valor < opponentCartas.get(i).valor){
                return Result.LOSS
            }
        }
        return Result.DRAW
    }

    protected boolean isSameNaipe(List<Carta> paramCartas) {
        return paramCartas.groupBy { it.naipe }.size() == 1
    }

    protected boolean isSequency(List<Carta> paramCartas) {
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
        return getCartasAgrupadas(minhasCartas).values().iterator().next().size() == qtd
    }

    protected boolean isTotalParesEquals(int qtd) {
        Map<Integer, List<Carta>> map = getCartasAgrupadas(minhasCartas)
        int totalGrupos = 0
        map.each { grupo ->
            if (grupo.value.size() > 1) {
                totalGrupos++
            }
        }
        return (totalGrupos == qtd)
    }

    private List<Carta> getCartasSemGrupo(List<Carta> paramCartas) {
        Map<Integer, List<Carta>> map = getCartasAgrupadas(paramCartas)
        List<Carta> listaToReturn = []
        map.each { grupo ->
            if (grupo.value.size() == 1) {
                listaToReturn.add(grupo.value.get(0))
            }
        }
        return listaToReturn
    }

    private List<Carta> getCartasDoMaiorGrupoAteKickerSemRepeticao(List<Carta> parCartas){

        Map<Integer, List<Carta>> map = getCartasAgrupadas(parCartas)
        List<Carta> listaToReturn = []
        map.each { grupo ->
            if (grupo.value.size() > 1) {
                listaToReturn.add(grupo.value.get(0))
            }
        }
        return listaToReturn + getCartasSemGrupo(parCartas)
    }

    private Map getCartasAgrupadas(List<Carta> paramCartas) {
        return paramCartas.groupBy { it.valor.ordinal() }.sort({ primeiro, segundo ->
            if (segundo.value.size() > primeiro.value.size()) {
                return 1
            }
            if (segundo.value.size() == primeiro.value.size()) {
                return -1
            }
            if (segundo.value.get(0).valor.ordinal() > primeiro.value.get(0).valor.ordinal()) {
                return 1
            }
            return -1
        })
    }
}