package entity

/**
 * Created by pedro on 25/07/17.
 */
class MaoFullHouse extends Mao{

    MaoFullHouse(String paramCartas) {
        super(paramCartas)
        this.categoria = Categoria.FULL_HOUSE
    }

    @Override
    boolean check(String paramCartas) {
        return(!isSequency(minhasCartas)
                && !isSameNaipe(minhasCartas)
                && isMaiorParLengthEquals(3)
                && isTotalParesEquals(2))
    }

    @Override
    Result desempate(List<Carta> opponent) {
        Map<Integer,List<Carta>>  myGroup = this.getCartasAgrupadas(minhasCartas)
        Map<Integer,List<Carta>>  opponentGroup = this.getCartasAgrupadas(opponent)
        Valor myCartaMaiorGrupo = null
        Valor myCartaMenorGrupo = null
        Valor myKicker = null
        Valor opponentCartaMaiorGrupo = null
        Valor opponentCartaMenorGrupo = null
        Valor opponentKicker = null

        myGroup.each {
            if(it.value.size() == 3){
                myCartaMaiorGrupo = it.value.get(0).valor
            }else if(it.value.size() == 2){
                myCartaMenorGrupo = it.value.get(0).valor
            }else{
                myKicker = it.value.get(0).valor
            }
        }

        opponentGroup.each {
            if(it.value.size() == 3){
                opponentCartaMaiorGrupo = it.value.get(0).valor
            }else if(it.value.size() == 2){
                opponentCartaMenorGrupo = it.value.get(0).valor
            }else{
                opponentKicker = it.value.get(0).valor
            }
        }
        Result resultado =desempatar(myCartaMaiorGrupo, opponentCartaMaiorGrupo)
        if(resultado != null){
            return resultado
        }
        resultado = desempatar(myCartaMenorGrupo, opponentCartaMenorGrupo)
        if(resultado != null){
            return resultado
        }
        return desempatar(myKicker, opponentKicker)
    }

    private Result desempatar(Valor myCartaMaiorGrupo, Valor opponentCartaMaiorGrupo){
        if(myCartaMaiorGrupo > opponentCartaMaiorGrupo){
            return Result.WIN
        } else if(myCartaMaiorGrupo < opponentCartaMaiorGrupo){
            return Result.LOSS
        }
        return null
    }
}
