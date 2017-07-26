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

        Map<Integer,List<Carta>> agrupamento = arrayCartas.groupBy { valor -> valor }.sort { a, b ->
            if (b.value.size() > a.value.size()) {
                return 1
            } else {
                if (b.value.size() < a.value.size()) {
                    return -1
                } else {
                    if (b.value.get(0) > a.value.get(0)) {
                        return 1
                    } else {
                        if (b.value.get(0) < a.value.get(0)) {
                            return -1
                        }
                    }
                }
            }
            return 0
        }
        for(mapa in agrupamento){
            grupos.add(new Grupo(lista: mapa.value))
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