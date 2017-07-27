package entity

import entity.Carta
import entity.Conversor
import entity.Mao.Mao
import entity.Mao.MaoCartaAlta
import entity.Mao.MaoDoisPares
import entity.Mao.MaoFlush
import entity.Mao.MaoFullHouse
import entity.Mao.MaoQuadra
import entity.Mao.MaoRoyalFlush
import entity.Mao.MaoSequencia
import entity.Mao.MaoStraightFlush
import entity.Mao.MaoTrinca
import entity.Mao.MaoUmPar

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
