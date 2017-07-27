package entity

/**
 * Created by pedro on 27/07/17.
 */
class Comparador {

    boolean isMesmoNaipe(List<Carta> paramCartas) {
        return paramCartas.groupBy { it.naipe }.size() == 1
    }

    boolean isSequencia(List<Carta> paramCartas) {
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

    boolean isMaiorParLengthEquals(List<Carta> cartas, int qtd) {
        List<Grupo> grupos = Conversor.listaToGrupo(cartas)
        if(grupos.size() > 0){
            return (grupos.get(0).qtd == qtd)
        }
        return (qtd == 0)
    }

    boolean isTotalParesEquals(List<Carta> cartas, int qtd) {
        return (Conversor.listaToGrupo(cartas).size() == qtd)
    }
}
