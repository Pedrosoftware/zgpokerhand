package teste

import entity.Mao.Mao
import entity.MaoSimpleFactory
import entity.Result
import spock.lang.Specification
import spock.lang.Unroll
import org.junit.Test
/**
 * Created by pedro on 19/07/17.
 */
class PokerHandTest extends Specification{

    @Unroll
    @Test
    void "Compara duas maos de poker"(){
        given: "crio duas mão de poker"
        Mao hand1 = MaoSimpleFactory.create(myHand)
        Mao hand2 = MaoSimpleFactory.create(opponentHand)

        expect: "comparo uma com a outra"
        hand1.compareWith(hand2) == result

        where: "com os valores abaixo"
        myHand           | opponentHand     || result
        "7H 7C QC JS TS" | "7D 7C JS TS 6D" || Result.WIN
        "9C TC JC QC KC" | "9C 9H 5C 5H AC" || Result.WIN
        "TC TH 5C 5H KH" | "9C 9H 5C 5H AC" || Result.WIN
        "TS TD KC JC 7C" | "JS JC AS KC TD" || Result.LOSS
        "5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS" || Result.LOSS
        "AS AD KD 7C 3D" | "AD AH KD 7C 4S" || Result.LOSS
        "TS JS QS KS AS" | "AC AH AS AS KS" || Result.WIN
        "TS JS QS KS AS" | "TC JS QC KS AC" || Result.WIN
        "TS JS QS KS AS" | "QH QS QC AS 8H" || Result.WIN
        "AC AH AS AS KS" | "TC JS QC KS AC" || Result.WIN
        "AC AH AS AS KS" | "QH QS QC AS 8H" || Result.WIN
        "TC JS QC KS AC" | "QH QS QC AS 8H" || Result.WIN
        "7H 8H 9H TH JH" | "JH JC JS JD TH" || Result.WIN
        "7H 8H 9H TH JH" | "4H 5H 9H TH JH" || Result.WIN
        "7H 8H 9H TH JH" | "7C 8S 9H TH JH" || Result.WIN
        "7H 8H 9H TH JH" | "TS TH TD JH JD" || Result.WIN
        "7H 8H 9H TH JH" | "JH JD TH TC 4C" || Result.WIN
        "JH JC JS JD TH" | "4H 5H 9H TH JH" || Result.WIN
        "JH JC JS JD TH" | "7C 8S 9H TH JH" || Result.WIN
        "JH JC JS JD TH" | "TS TH TD JH JD" || Result.WIN
        "JH JC JS JD TH" | "JH JD TH TC 4C" || Result.WIN
        "4H 5H 9H TH JH" | "7C 8S 9H TH JH" || Result.WIN
        "4H 5H 9H TH JH" | "TS TH TD JH JD" || Result.LOSS
        "4H 5H 9H TH JH" | "JH JD TH TC 4C" || Result.WIN
        "7C 8S 9H TH JH" | "TS TH TD JH JD" || Result.LOSS
        "7C 8S 9H TH JH" | "JH JD TH TC 4C" || Result.WIN
        "TS TH TD JH JD" | "JH JD TH TC 4C" || Result.WIN
        "2S 3H 4D 5H 6D" | "5H 6D 7H 8C 9C" || Result.LOSS
        "2S 3H 4H 5H 6D" | "2S 3H 4D 5H 6C" || Result.DRAW
        "2H 3H 4H 5H 7H" | "2D 3D 4D 5D 8D" || Result.LOSS
        "2S 2H 2D 5H 6D" | "5H 5D 5H 8C 9C" || Result.LOSS
        "2H 3H 4H 5H 6H" | "5H 6H 7H 8H 9H" || Result.LOSS
        "TH JH QH KH AH" | "TC JC QC KC AC" || Result.DRAW
        "TH TH TH TH AS" | "9C 9C 9C 9C 2S" || Result.WIN
        "TH TH TH AH AS" | "9C 9C 9C 2C 2S" || Result.WIN
        "2H 4H 6H 8H AS" | "3C 5C 6C 8C JS" || Result.WIN
        "2H 2H 2H AH AS" | "2C 2C 2C JC JS" || Result.WIN
        "2H 2H 5H AH AS" | "2C 2C 6C AC AS" || Result.LOSS

        "AH JH QH KH TH" | "TH KH JH QH AH" || Result.DRAW
    }
}
