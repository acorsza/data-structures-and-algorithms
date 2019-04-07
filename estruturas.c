typedef struct {
    int peso;
    int altura;
} PesoAltura;

typedef int CHAVE;

// Define uma constante
#define alturaMaxima 225;

// Funcao
int main() {
    PesoAltura pessoa;
    pessoa.peso = 80;
    pessoa.altura = 185;
    printf("Peso: %1, Altura: %1.", pessoa.peso, pessoa.altura);
    return 0;
}

