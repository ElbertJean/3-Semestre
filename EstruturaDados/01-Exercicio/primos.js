const vetor = [1, 4, 6, 11, 15, 12];
const numerosPrimos = [];

for (let i = 0; i < vetor.length; i++) {
    let valorI = vetor[i];
    let contador = 0;

    for (valorI; valorI > 0; valorI--){
        let resultado = vetor[i] % valorI;

        if (resultado === 0) {
            contador ++;
        }
    }
    if (contador === 2) {
        numerosPrimos.push(vetor[i]);
    }
}

console.log('Quantidade de números primos:', numerosPrimos.length);
console.log('Números primos:', numerosPrimos);