package entity.Mao

import entity.Carta
import entity.Conversor

/**
 * Created by pedro on 26/07/17.
 */
class MaoSimpleFactory {

    static Mao create(String cartas){
        List<Carta> lista = Conversor.converter(cartas).sort { it.valor.ordinal()}
        teste(cartas)
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
        throw new Exception("lista inválidas")
    }
    static teste(String s){
        List<Carta> listaCompleta = Conversor.converter(s)
        println"\nCompleta"
        listaCompleta.each {
            print "${it.valor } "
        }
        List<Carta> listaSemRepeticao = Conversor.removerCartasDuplicadas(listaCompleta)
        println""
        listaSemRepeticao.each {
            print "${it.valor } "
        }

    }
}
