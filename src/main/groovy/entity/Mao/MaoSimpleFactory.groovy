package entity.Mao

import entity.Carta
import entity.Conversor

/**
 * Created by pedro on 26/07/17.
 */
class MaoSimpleFactory {

    static Mao create(String cartas){
        List<Carta> lista = Conversor.stringToCartas(cartas)
        Mao mao = new MaoRoyalFlush(lista)
        if(mao.check()){return mao}
        mao = new MaoStraightFlush(lista)
        if(mao.check()){return mao}
        mao = new MaoQuadra(lista)
        if(mao.check()){return mao}
        mao = new MaoFullHouse(lista)
        if(mao.check()){return mao}
        mao = new MaoFlush(lista)
        if(mao.check()){return mao}
        mao = new MaoSequencia(lista)
        if(mao.check()){return mao}
        mao = new MaoTrinca(lista)
        if(mao.check()){return mao}
        mao = new MaoDoisPares(lista)
        if(mao.check()){return mao}
        mao = new MaoUmPar(lista)
        if(mao.check()){return mao}
        mao = new MaoCartaAlta(lista)
        if(mao.check()){return mao}
        throw new Exception("Cartas inválidas")
    }
}
