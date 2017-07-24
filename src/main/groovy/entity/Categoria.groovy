package entity

enum Categoria {

    ROYAL_FLUSH(10),
    STRAIGHT_FLUSH(9),
    QUADRA(8),
    FULL_HOUSE(7),
    FLUSH(6),
    SEQUENCIA(5),
    TRINCA(4),
    DOIS_PARES(3),
    UM_PAR(2),
    CARTA_ALTA(1)

    int nivel

    Categoria(int nivel){
        this.nivel = nivel
    }
}