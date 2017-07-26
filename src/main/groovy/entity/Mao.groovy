package entity
/**
 * Created by pedro on 19/07/17.
 */
abstract class Mao {

    private boolean isSequencia
    private boolean isMesmoNaipe
    private int totalNoMaiorPar
    private int totalNoMenorPar
    private Categoria categoria
    private int totalGrupos
    //private int cartaMaisAlta
    protected List<Carta> cartas

    Mao(String paramCartas) {
        cartas = convertToListCartas(paramCartas)
        cartas = this.sortHand(cartas)
    }

    Result compareWith(Mao opponent) {
        if (this.categoria.ordinal() > opponent.categoria.ordinal()) {
            return Result.WIN
        } else if (this.categoria.ordinal() < opponent.categoria.ordinal()) {
            return Result.LOSS
        } else {
            return desempate(opponent)
        }
    }

    abstract boolean check(String cartas)

    abstract Result desempate(List<Carta> opponent)

    protected boolean isSameNaipe(List<Carta> paramCartas) {
       return paramCartas.groupBy { it.naipe }.size() == 1
    }

    protected boolean isSequency(List<Carta> paramCartas) {
        boolean sequencia = true
        int numCartaAtual = (paramCartas.get(0).valor.ordinal() - 1)

        paramCartas.each {
            if (it.valor.ordinal() == (numCartaAtual + 1)) {
                numCartaAtual = it.valor.ordinal()
            } else {
                sequencia = false
                return sequencia
            }
        }
        return sequencia
    }

    protected boolean isMaiorParLengthEquals(int qtd){
        Collection<List<Carta>> c = getCartasAgrupadas(cartas).values()
        int qtdMaiorPar =c.iterator().next().size()
        return qtdMaiorPar == qtd
    }

    protected boolean isTotalParesEquals(int qtd){
        Map<Integer,List<Carta>> map = getCartasAgrupadas(cartas)
        int totalGrupos = 0
        for(grupo in map){
            if(grupo.value.size() > 1){
                totalGrupos++
            }
        }
        return (totalGrupos == qtd)
    }

    protected List<Carta> getCartasSemPar(List<Carta> paramCartas){
        Map<Integer,List<Carta>> map = getCartasAgrupadas(paramCartas)
        List<Carta> listaToReturn = []
        map.each { grupo ->
            if(grupo.value.size() == 1){
                listaToReturn.add(grupo.value.get(0))
            }
        }
        return listaToReturn
    }

    protected Valor (List<Carta> cartas) {
        Valor cartaMaisAlta = Valor.DOIS
        cartas.each {carta ->
            if (carta.valor.is(cartaMaisAlta)) {
                cartaMaisAlta = carta.valor
            }
        }
        return cartaMaisAlta
    }

    protected List<Carta> sortHand(List<Carta> paramCartas) {
        return paramCartas.sort({ it.valor.ordinal() })
    }

    //
    protected List<Carta> convertToListCartas(String paramCartas) {
        String[] arrayCartas = paramCartas.split(' ')
        List<Carta> listCartas = []
        arrayCartas.each { letra ->
            Valor v = discoverValorCarta(letra.substring(0, 1))
            Naipe n = discoverNaipeCarta(letra.substring(1))
            Carta carta = new Carta(valor: v,naipe: n)
            listCartas << carta
        }
        return listCartas
    }








    private Map getCartasAgrupadas(List<Carta> paramCartas) {
        return paramCartas.groupBy { it.valor.ordinal() }.sort({ primeira, segunda ->
            if (segunda.value.size() > primeira.value.size()) {return 1}
            if (segunda.value.size() == primeira.value.size()) {return -1}
            if (segunda.value.get(0).valor.ordinal() > primeira.value.get(0).valor.ordinal()) {return 1}
            return -1
        })
    }

    private void determineCategory() {
        if (isSequencia) {
            if (isMesmoNaipe) {
                if (cartaMaisAlta == 14) {
                    categoria = Categoria.ROYAL_FLUSH
                } else {
                    categoria = Categoria.STRAIGHT_FLUSH
                }
            } else {
                categoria = Categoria.SEQUENCIA
            }
        } else {
            if (isMesmoNaipe) {
                categoria = Categoria.FLUSH
            } else {
                if (totalNoMaiorPar == 4) {
                    categoria = Categoria.QUADRA
                } else {
                    if (totalNoMaiorPar == 3) {
                        if (totalGrupos == 2) {
                            categoria = Categoria.FULL_HOUSE
                        } else {
                            categoria = Categoria.TRINCA
                        }
                    } else {
                        if (totalGrupos == 2) {
                            categoria = Categoria.DOIS_PARES
                        } else {
                            if (totalGrupos == 1) {
                                categoria = Categoria.UM_PAR
                            } else {
                                categoria = Categoria.CARTA_ALTA
                            }
                        }
                    }
                }
            }
        }
    }

    private void verifyGroups() {
        def map = getCartasAgrupadas(this.cartas)
        totalNoMaiorPar = 0
        totalNoMenorPar = 0

        int somaGrupos = 0
        int contador = 1
        map.each {carta ->
            if (contador == 1 && carta.value.size() > 1) {
                totalNoMaiorPar = carta.value.size()
            } else if (contador == 2 && carta.value.size() > 1) {
                totalNoMenorPar = carta.value.size()
            }
            if (carta.value.size() > 1) {
                somaGrupos++
            }
            contador++
        }
        totalGrupos = somaGrupos
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

    private Result getDesempateResult(int minhaCarta, int oponenteCarta) {
        if (minhaCarta > oponenteCarta) {
            return Result.WIN
        } else if (minhaCarta < oponenteCarta) {
            return Result.LOSS
        } else {
            return Result.DRAW
        }
    }

    private Result desempateByKicker(List<List<Carta>> minhaMao, List<List<Carta>> maoOponente) {
        Result result = null
        for (int i = 0; i < minhaMao.size(); i++) {
            if (minhaMao.get(i).size() < 2) {
                if (minhaMao.get(i).get(0).valor.ordinal() > maoOponente.get(i).get(0).valor.ordinal()) {
                    result = Result.WIN
                } else if (minhaMao.get(i).get(0).valor.ordinal() < maoOponente.get(i).get(0).valor.ordinal()) {
                    result = Result.LOSS
                }
            }

        }
        if (result == null) {
            result = Result.DRAW
        }
        return result
    }
}


