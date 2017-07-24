import entity.Mao
import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by pedro on 20/07/17.
 */
class MaoTeste extends Specification {

    @Unroll
    @Test
    def "verificão da sequencia das cartas"() {

        given: "uma mão de cartas qualquer"
            Mao mao = new Mao(cartas)
        when: "verifico se as cartas estão em sequencia"
            mao.verifySequencia()
        then: "devo ter o resultado abaixo"
            mao.isSequencia == result
        where:
            cartas           || result
            "TC JC QC KC AC" || true
            "TC TH 5C 5H KH" || false
            "9C 9H 5C 5H AC" || false
            "6C 2C 3C 4C 5H" || true
            "9H 2C 5C 7C 8C" || false
    }

    @Unroll
    @Test
    def "verificação das cartas de mesmo naipe"() {

        given: "uma mão de cartas qualquer"
        Mao mao = new Mao(cartas)

        when: "verifico se todas tem o mesmo naipe"
        mao.verifyNaipe()
        then: "devo ter o resultado abaixo"
        mao.isMesmoNaipe == result
        where:
        cartas           || result
        "TC JC QC KC AC" || true
        "TC TH 5C 5H KH" || false
        "9C 9H 5C 5H AC" || false
        "7C 2C 3C 4C 5H" || false
        "9H 2C 5C 7C 8C" || false

    }

    @Unroll
    @Test
    def "verificação de ordenação das cartas"() {

        given: "Uma mão de poker qualquer"
        Mao mao = new Mao(cartas)
        when: "mando ordenar as cartas"
        mao.sortHand()
        then: "elas devem vir em ordem crescente"
        mao.cartas
        where:
        cartas           || result
        "TC JC QC KC AC" || "TC JC QC KC AC"
        "TC TH 5C 5H KH" || "5C 5H TC TH KH"
        "9C 9H 5C 5H AC" || "5C 5H 9C 9H AC"
        "6C 2C 3C 4C 5H" || "2C 3C 4C 5H 6C"
        "9H 2C 5C 7C 8C" || "2C 5C 7C 8C 9H"
    }

    @Unroll
    @Test
    def "verificação de total de pares, maior e menor par"() {

        given:
            Mao mao = new Mao(cartas)
        when:
            mao.verifyNaipe()
            mao.verifySequencia()
            mao.verifyPares()
        then:
            mao.totalNoMaiorPar == totalNoMaiorPar
            mao.totalNoMenorPar == totalNoMenorPar
            mao.totalPares == totalDePares
        where:
        cartas           | totalNoMaiorPar || totalNoMenorPar || totalDePares
        "6S 3D 6D 6D 3D" | 3               || 2               || 2
        "6S 6H 6D 6C 3D" | 4               || 0               || 1
        "TC JC QC KC AC" | 0               || 0               || 0
        "TC TH 5C 5H KH" | 2               || 2               || 2
        "9C 9H 5C 5H AC" | 2               || 2               || 2
        "6C 2C 3C 4C 5H" | 0               || 0               || 0
        "9H 2C 5C 7C 8C" | 0               || 0               || 0
        "9C 9C 5D TC TC" | 2               || 2               || 2
        "2S 3D 6D 6D 3D" | 2               || 2               || 2




    }


    @Unroll
    @Test
    def "verificação carta de maior valor dentre todas de uma mão"(){

        given: "uma mão de cartas qualquer"
            Mao mao = new Mao(cartas)
        when: "calcular qual é a maior carta dentro todas da mão"
        mao.determinarCartaMaisAlta()
        then: "a carta deve ser a seguinte"
        mao.cartaMaisAlta == resultado
        where: "teste de valores"
        cartas || resultado
        "6S 3D 6D 6D 3D" | 6
        "6S 6H 6D 6C 3D" | 6
        "TC JC QC KC AC" | 14
        "TC TH 5C 5H KH" | 13
        "9C 9H 5C 5H AC" | 14
        "6C 2C 3C 4C 5H" | 6
        "9H 2C 5C 7C 8C" | 9
        "9C 9C 5D TC TC" | 10
        "2S 3D 6D 6D 3D" | 6


    }
}
