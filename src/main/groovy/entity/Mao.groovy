package entity
/**
 * Created by pedro on 19/07/17.
 */
abstract class Mao {

    protected Categoria categoria
    protected List<Carta> minhasCartas

    Mao(String paramCartas) {
        minhasCartas = convertToListCartas(paramCartas).sort { it.valor.ordinal() }
    }

    protected isPercorrerSomenteKickerNoDesempate(){
        return true
    }

    Result compareWith(Mao opponent) {
        int minhaForca = this.categoria.ordinal()
        int oponenteForca = opponent.categoria.ordinal()

        if (minhaForca > oponenteForca) {
            return Result.WIN
        } else if (minhaForca < oponenteForca) {
            return Result.LOSS
        }
        return this.desempate(opponent.minhasCartas)
    }

    abstract boolean check(String cartas)

    private Result desempate(List<Carta> opponent) {
        List<Carta> myCartas
        List<Carta> opponentCartas
        if(isPercorrerSomenteKickerNoDesempate()){
            myCartas = getCartasSemGrupo(minhasCartas)
            opponentCartas = getCartasSemGrupo(opponent)
        }else{
            myCartas = getCartasDoMaiorGrupoAteKickerSemRepeticao(minhasCartas)
            opponentCartas = getCartasDoMaiorGrupoAteKickerSemRepeticao(opponent)
        }

        for(int i = 0; i < myCartas.size(); i++){
            if(myCartas.get(i).valor > opponentCartas.get(i).valor){
                return Result.WIN
            }else if(myCartas.get(i).valor < opponentCartas.get(i).valor){
                return Result.LOSS
            }
        }
        return Result.DRAW
    }

    protected boolean isSameNaipe(List<Carta> paramCartas) {
        return paramCartas.groupBy { it.naipe }.size() == 1
    }

    protected boolean isSequency(List<Carta> paramCartas) {
        boolean isSequencia = true
        int numCartaAtual = (paramCartas.get(0).valor.ordinal() - 1)

        paramCartas.each {
            if (it.valor.ordinal() == (numCartaAtual + 1)) {
                numCartaAtual = it.valor.ordinal()
            } else {
                isSequencia = false
                return isSequencia
            }
        }
        return isSequencia
    }

    protected boolean isMaiorParLengthEquals(int qtd) {
        return getCartasAgrupadas(minhasCartas).values().iterator().next().size() == qtd
    }

    protected boolean isTotalParesEquals(int qtd) {
        Map<Integer, List<Carta>> map = getCartasAgrupadas(minhasCartas)
        int totalGrupos = 0
        map.each { grupo ->
            if (grupo.value.size() > 1) {
                totalGrupos++
            }
        }
        return (totalGrupos == qtd)
    }

    private List<Carta> getCartasSemGrupo(List<Carta> paramCartas) {
        Map<Integer, List<Carta>> map = getCartasAgrupadas(paramCartas)
        List<Carta> listaToReturn = []
        map.each { grupo ->
            if (grupo.value.size() == 1) {
                listaToReturn.add(grupo.value.get(0))
            }
        }
        return listaToReturn
    }

    private List<Carta> getCartasDoMaiorGrupoAteKickerSemRepeticao(List<Carta> parCartas){

        Map<Integer, List<Carta>> map = getCartasAgrupadas(parCartas)
        List<Carta> listaToReturn = []
        map.each { grupo ->
            if (grupo.value.size() > 1) {
                listaToReturn.add(grupo.value.get(0))
            }
        }
        return listaToReturn + getCartasSemGrupo(parCartas)
    }

    protected List<Carta> convertToListCartas(String paramCartas) {
        String[] arrayCartas = paramCartas.split(' ')
        List<Carta> listCartas = []
        arrayCartas.each { letra ->
            Carta carta = new Carta(
                    valor: discoverValorCarta(letra.substring(0, 1)),
                    naipe: discoverNaipeCarta(letra.substring(1)))
            listCartas << carta
        }
        return listCartas
    }

    private Map getCartasAgrupadas(List<Carta> paramCartas) {
        return paramCartas.groupBy { it.valor.ordinal() }.sort({ primeiro, segundo ->
            if (segundo.value.size() > primeiro.value.size()) {
                return 1
            }
            if (segundo.value.size() == primeiro.value.size()) {
                return -1
            }
            if (segundo.value.get(0).valor.ordinal() > primeiro.value.get(0).valor.ordinal()) {
                return 1
            }
            return -1
        })
    }

    protected Valor discoverValorCarta(String letra) {
        switch (letra) {
            case ['2']:
                return Valor.DOIS
            case ['3']:
                return Valor.TRES
            case ['4']:
                return Valor.QUATRO
            case ['5']:
                return Valor.CINCO
            case ['6']:
                return Valor.SEIS
            case ['7']:
                return Valor.SETE
            case ['8']:
                return Valor.OITO
            case ['9']:
                return Valor.NOVE
            case 'T':
                return Valor.DEZ
            case 'J':
                return Valor.VALETE
            case 'Q':
                return Valor.DAMA
            case 'K':
                return Valor.REI
            case 'A':
                return Valor.AIS
            default:
                throw new Exception("Valor inválido")
        }
    }

    protected Naipe discoverNaipeCarta(String naipe) {
        naipe = naipe.toUpperCase()
        switch (naipe) {
            case ['S']:
                return Naipe.ESPADA
            case ['H']:
                return Naipe.COPAS
            case ['D']:
                return Naipe.OURO
            case ['C']:
                return Naipe.PAUS
            default:
                throw new Exception("Naipe inválido")
        }
    }
}