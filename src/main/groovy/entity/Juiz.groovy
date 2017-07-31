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

    Juiz(){
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

        List<Carta> myCartas = Conversor.stringToCartas(mao1)
        List<Carta> opponentCartas = Conversor.stringToCartas(mao2)

        Reconhecedor myHand = reconhecer(myCartas)
        Reconhecedor opponentHand = reconhecer(opponentCartas)

        int minhaForca = myHand.getCategoria().ordinal()
        int oponenteForca = opponentHand.getCategoria().ordinal()

        if (minhaForca > oponenteForca) {
            return Result.WIN
        } else if (minhaForca < oponenteForca) {
            return Result.LOSS
        }
        return desempate(myCartas, opponentCartas)
    }

    private Reconhecedor reconhecer(List<Carta> cartas){

        for(categoria in reconhecedor){
            categoria.setCartas(cartas)
            if(categoria.reconhecer()){
                return categoria
            }
        }
        throw new Exception("Falha ao detectar categoria da carta")
    }

    private static Result desempate(List<Carta> minhasCartas,List<Carta> cartasOponente) {
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
