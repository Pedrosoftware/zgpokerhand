package entity

/**
 * Created by pedro on 26/07/17.
 */
class Conversor {

    static List<Carta> converter(String paramCartas) {
        List<Grupo> grupos = new ArrayList<>()
        String[] arrayCartas = paramCartas.split(' ')
        List<Carta> listCartas = []
        arrayCartas.each { letra ->
            Carta carta = new Carta(
                    valor: conversorValor(letra.substring(0, 1)),
                    naipe: conversorNaipe(letra.substring(1)))
            listCartas << carta
        }

        Map<Carta, List<Carta>> agrupamento = listCartas.groupBy { valor -> valor.valor }

//        println "MAO"
//        agrupamento.each {
//            if(it.value.get(0).valor == Valor.CINCO ||
//                    it.value.get(0).valor == Valor.VALETE ||
//                    it.value.get(0).valor == Valor.QUATRO){
//                print " ${it.value.size()} ${it.value.get(0).valor}\t"
//            }else{
//                print " ${it.value.size()} ${it.value.get(0).valor}\t\t"
//            }
//        }
//        println""
        Grupo grupo = new Grupo()
        agrupamento.sort { a, b ->
            if (b.value.size() > a.value.size()) {
                return 1
            } else {
                if (b.value.size() < a.value.size()) {
                    return -1
                } else {
                    if (b.value.get(0).valor.ordinal() > a.value.get(0).valor.ordinal()) {
                        return 1
                    } else if (b.value.get(0).valor.ordinal() < a.value.get(0).valor.ordinal()) {
                        return -1

                    }
                }
            }
            return 0
        }.each {
            grupo.lista << it.value.get(0)
        }
        return listCartas
    }

    static Valor conversorValor(String letra) {
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

    static Naipe conversorNaipe(String naipe) {
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
