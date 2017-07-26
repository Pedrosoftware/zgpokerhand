package entity

/**
 * Created by pedro on 26/07/17.
 */
class MaoSimpleFactory {

    static Mao create(String cartas){
        Mao mao = new MaoRoyalFlush(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoStraightFlush(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoQuadra(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoFullHouse(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoFlush(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoSequencia(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoTrinca(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoDoisPares(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoUmPar(cartas)
        if(mao.check(cartas)){return mao}
        mao = new MaoCartaAlta(cartas)
        if(mao.check(cartas)){return mao}
        throw new Exception("Cartas inválidas")
    }
}
