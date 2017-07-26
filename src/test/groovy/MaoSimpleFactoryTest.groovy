import entity.Mao.Mao
import entity.Mao.MaoCartaAlta
import entity.Mao.MaoDoisPares
import entity.Mao.MaoFlush
import entity.Mao.MaoFullHouse
import entity.Mao.MaoQuadra
import entity.Mao.MaoRoyalFlush
import entity.Mao.MaoSequencia
import entity.Mao.MaoSimpleFactory
import entity.Mao.MaoStraightFlush
import entity.Mao.MaoTrinca
import entity.Mao.MaoUmPar
import org.junit.Test
import spock.lang.Specification

/**
 * Created by pedro on 26/07/17.
 */
class MaoSimpleFactoryTest extends Specification{

    @Test
    def "Royal Flush"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria RoyalFlush"
        (mao instanceof MaoRoyalFlush) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || true
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || true
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || true
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || false
    }

    @Test
    def "Straight Flush"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria StraightFlush"
        (mao instanceof MaoStraightFlush) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || true
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || true
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || true
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || false
    }

    @Test
    def "Quadra"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria Quadra"
        (mao instanceof MaoQuadra) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || true
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || true
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || true
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || false
    }

    @Test
    def "Full House"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria FullHouse"
        (mao instanceof MaoFullHouse) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || true
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || true
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || true
        "2H 2H 5H AH AS"  || false
    }

    @Test
    def "Flush"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria Flush"
        (mao instanceof MaoFlush) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || true
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || true
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || false
    }

    @Test
    def "Sequencia"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria Sequencia"
        (mao instanceof MaoSequencia) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || true
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || true
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || true
        "2S 3H 4H 5H 6D"  || true
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || false
    }

    @Test
    def "Trinca"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria Trinca"
        (mao instanceof MaoTrinca) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || true
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || false
    }

    @Test
    def "Dois pares"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria DoisPares"
        (mao instanceof MaoDoisPares) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || true
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || true
    }

    @Test
    def "Um Par"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria UmPar"
        (mao instanceof MaoUmPar) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || true
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || true
        "5S 5D 8C 7S 6H"  || true
        "AS AD KD 7C 3D"  || true
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || false
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || false
    }

    @Test
    def "Carta Alta"(){

        given:
        Mao mao
        when:"pegar uma instância da classe mão"
        mao = MaoSimpleFactory.create(cartas)
        then:"devo receber a subclasse da categoria CartaAlta"
        (mao instanceof MaoCartaAlta) == result
        where:
        cartas            || result
        "TH JH QH KH AH"  || false
        "7H 7C QC JS TS"  || false
        "9C TC JC QC KC"  || false
        "TC TH 5C 5H KH"  || false
        "TS TD KC JC 7C"  || false
        "5S 5D 8C 7S 6H"  || false
        "AS AD KD 7C 3D"  || false
        "TS JS QS KS AS"  || false
        "AC AH AS AS KS"  || false
        "TC JS QC KS AC"  || false
        "7H 8H 9H TH JH"  || false
        "JH JC JS JD TH"  || false
        "4H 5H 9H TH JH"  || false
        "7C 8S 9H TH JH"  || false
        "TS TH TD JH JD"  || false
        "2S 3H 4D 5H 6D"  || false
        "2S 3H 4H 5H 6D"  || false
        "2H 3H 4H 5H 7H"  || false
        "2S 2H 2D 5H 6D"  || false
        "2H 3H 4H 5H 6H"  || false
        "TH JH QH KH AH"  || false
        "TH TH TH TH AS"  || false
        "TH TH TH AH AS"  || false
        "2H 4H 6H 8H AS"  || true
        "2H 2H 2H AH AS"  || false
        "2H 2H 5H AH AS"  || false
    }

}
