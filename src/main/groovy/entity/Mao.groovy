package entity
/**
 * Created by pedro on 19/07/17.
 */
class Mao {

    private boolean isSequencia
    private boolean isMesmoNaipe
    private int totalNoMaiorPar
    private int totalNoMenorPar
    private Categoria categoria
    private int totalPares
    private int cartaMaisAlta
    private List<Carta> cartas

    Mao(String stringCartas) {
        this.cartas = convertToListCartas(stringCartas)
        sortHand()
        verifyNaipe()
        verifySequencia()
        verifyPares()
        determinarCartaMaisAlta()
        determineCategory()
    }

    Result compareWith(Mao opponent){
        if(this.categoria.nivel > opponent.categoria.nivel){
            return Result.WIN
        }else if(this.categoria.nivel < opponent.categoria.nivel){
            return Result.LOSS
        }else{
            return desempate(opponent)
        }
    }

    private Result desempate(Mao opponent){
        def myMap = getCartasAgrupadas(this.cartas)
        def opponentMap = getCartasAgrupadas(opponent.cartas)
        List<List<Carta>> myList = []
        List<List<Carta>> opponentList = []
        myMap.each{k, v -> myList << v}
        opponentMap.each{k, v -> opponentList << v}

        if(myList.get(0).size() > 1){
            Result r = getDesempateResult(myList.get(0).get(0).numCarta,opponentList.get(0).get(0).numCarta)
            if(r.is(Result.DRAW)){
                if(myList.get(1).size() > 1){
                    r = getDesempateResult(myList.get(1).get(0).numCarta,opponentList.get(1).get(0).numCarta)
                    if(r.is(Result.DRAW)){
                        return desempateByKicker(myList, opponentList)
                    }else{
                        return r
                    }
                }else{
                    r = desempateByKicker(myList, opponentList)
                }
            }
            return r
        }else{
            return desempateByKicker(myList, opponentList)
        }
    }

    private Map getCartasAgrupadas(List<Carta> paramCartas){
        def map = paramCartas.groupBy {it.numCarta}
        .sort({a, b ->
            if(b.value.size() > a.value.size()){
                return 1
            } else if(b.value.size() == a.value.size()){
                return -1
            }else{
                int bNumCarta = b.value.get(0).numCarta
                int aNumCarta = a.value.get(0).numCarta
                if(bNumCarta > aNumCarta){
                    return 1
                }else{
                    return -1
                }

            }
        })
        return map
    }

    private void determineCategory(){
        if(isSequencia){
            if(isMesmoNaipe){
                if(cartaMaisAlta == 14){
                    categoria = Categoria.ROYAL_FLUSH
                }else{
                    categoria = Categoria.STRAIGHT_FLUSH
                }
            }else{
                categoria = Categoria.SEQUENCIA
            }
        }else{
            if(isMesmoNaipe){
                categoria = Categoria.FLUSH
            }else{
                if(totalNoMaiorPar == 4){
                    categoria = Categoria.QUADRA
                }else{
                    if(totalNoMaiorPar == 3){
                        if(totalPares == 2){
                            categoria = Categoria.FULL_HOUSE
                        }else{
                            categoria = Categoria.TRINCA
                        }
                    }else{
                        if(totalPares == 2){
                            categoria = Categoria.DOIS_PARES
                        }else{
                            if(totalPares == 1){
                                categoria = Categoria.UM_PAR
                            }else{
                                categoria = Categoria.CARTA_ALTA
                            }
                        }
                    }
                }
            }
        }
    }

    private void verifyNaipe(){

        if(cartas.groupBy {it.naipe}.size().is(1)){
            isMesmoNaipe = true
        }else{
            isMesmoNaipe = false
        }
    }

    private void verifySequencia(){
        int numCartaAtual = (cartas.get(0).numCarta-1)
        isSequencia = true

        cartas.each{
            if(it.numCarta == (numCartaAtual+1)){
                numCartaAtual = it.numCarta
            }else{
                isSequencia = false
            }
        }
    }

    private void verifyPares(){
        def map = getCartasAgrupadas(this.cartas)
        totalNoMaiorPar = 0
        totalNoMenorPar = 0

        int sumPares = 0
        int counter = 1
        map.each {
            if(counter == 1 && it.value.size()>1){
                    totalNoMaiorPar=it.value.size()
            }else if(counter == 2 && it.value.size() > 1){
                totalNoMenorPar = it.value.size()
            }
            if(it.value.size() > 1){sumPares++}
            counter++
        }
        totalPares = sumPares
    }

    private void determinarCartaMaisAlta(){
        cartaMaisAlta = 0
        cartas.each {
            if(it.numCarta > cartaMaisAlta){
                cartaMaisAlta = it.numCarta
            }
        }
    }

    private void sortHand() {
        cartas.sort({it.numCarta})
    }

    private List<Carta> convertToListCartas(String paramCartas){
        String[] arrayCartas = paramCartas.split(' ')
        List<Carta> listCartas = []
        arrayCartas.each{numCarta ->
            listCartas << new Carta(numCarta.substring(0,1), numCarta.charAt(1))
        }
        listCartas.each {it.numCarta = discoverNumCarta(it.valor)}
        return listCartas
    }

    private static int discoverNumCarta(String letra) {
        switch (letra) {
            case ['2', '3', '4', '5', '6', '7', '8', '9']:
                return Integer.parseInt(letra)
                break
            case 'T':
                return 10
                break
            case 'J':
                return 11
                break
            case 'Q':
                return 12
                break
            case 'K':
                return 13
                break
            case 'A':
                return 14
                break
            default:
                throw new Exception("Valor inválido")
        }
    }

    private Result getDesempateResult(int minhaCarta, int oponenteCarta){
        if(minhaCarta > oponenteCarta){
            return Result.WIN
        }else if(minhaCarta < oponenteCarta){
            return Result.LOSS
        }else{
            return Result.DRAW
        }
    }

    private Result desempateByKicker(List<List<Carta>> minhaMao, List<List<Carta>> maoOponente){
        Result result = null
        for(int i = 0; i < minhaMao.size(); i++){
            if(minhaMao.get(i).size()<2){
                if(minhaMao.get(i).get(0).numCarta > maoOponente.get(i).get(0).numCarta){
                    result = Result.WIN
                }else if (minhaMao.get(i).get(0).numCarta < maoOponente.get(i).get(0).numCarta){
                    result = Result.LOSS
                }
            }

        }
        if(result == null){
            result = Result.DRAW
        }
        return result
    }
}


