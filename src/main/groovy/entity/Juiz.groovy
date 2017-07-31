package entity

import entity.reconhecedor.MaoCartaAlta
import entity.reconhecedor.MaoDoisPares
import entity.reconhecedor.MaoFlush
import entity.reconhecedor.MaoFullHouse
import entity.reconhecedor.MaoQuadra
import entity.reconhecedor.MaoRoyalFlush
import entity.reconhecedor.MaoSequencia
import entity.reconhecedor.MaoStraightFlush
import entity.reconhecedor.MaoTrinca
import entity.reconhecedor.MaoUmPar
import entity.reconhecedor.Reconhecedor

/**
 * Created by pedro on 26/07/17.
 */
class Juiz {

    private Reconhecedor[] reconhecedor
    private List<Carta> myCartas
    private List<Carta> opponentCartas

    Juiz() {
        reconhecedor = new Reconhecedor[10]
        reconhecedor[0] = new MaoRoyalFlush()
        reconhecedor[1] = new MaoStraightFlush()
        reconhecedor[2] = new MaoQuadra()
        reconhecedor[3] = new MaoFullHouse()
        reconhecedor[4] = new MaoFlush()
        reconhecedor[5] = new MaoSequencia()
        reconhecedor[6] = new MaoTrinca()
        reconhecedor[7] = new MaoDoisPares()
        reconhecedor[8] = new MaoUmPar()
        reconhecedor[9] = new MaoCartaAlta()
    }


    Result compare(String mao1, String mao2) {

        myCartas = Conversor.stringToCartas(mao1)
        opponentCartas = Conversor.stringToCartas(mao2)

        int myCategory = getCategoria(myCartas).ordinal()
        int opCategory = getCategoria(opponentCartas).ordinal()

        if (myCategory > opCategory) {
            return Result.WIN
        } else if (myCategory < opCategory) {
            return Result.LOSS
        }
        return desempate()
    }

    private Categoria getCategoria(List<Carta> cartas) {

        for (categoria in reconhecedor) {
            categoria.setCartas(cartas)
            if (categoria.reconhecer()) {
                return categoria.getCategoria()
            }
        }
        throw new Exception("Falha ao detectar categoria da carta")
    }

    private Result desempate() {
        myCartas = Conversor.listaCompletaToListaSemDuplicidade(myCartas)
        opponentCartas = Conversor.listaCompletaToListaSemDuplicidade(opponentCartas)

        for (int i = 0; i < myCartas.size(); i++) {
            if (myCartas.get(i).valor > opponentCartas.get(i).valor) {
                return Result.WIN
            } else if (myCartas.get(i).valor < opponentCartas.get(i).valor) {
                return Result.LOSS
            }
        }
        return Result.DRAW
    }
}
