// Grau de complexidade
/// O(n) = Para o melhor caso. Caso a lsita já venha ordernada.
/// O(n^3/2) = Para o caso médio, sequência do Gap dividido por 2. (Existem gaps melhores, pesquisar ...)
/// O(n²) = Pior caso. Caso a lista venha desordenada e necessite passar sempre pelo While.

// const { lista } = require('./data.js');
// let ordernar = lista;


// const ordernar = [8, 2, 7, 11, 14, 5, 1, 0, 3, 15, 17, 6, 9];
const ordernar = [8, 2, 7, 11, 14, 5, 1, 0];

let gap = Math.floor(ordernar.length / 2);

function insertSort(array) {
    while(gap > 0) {
        for (let i = gap; i < array.length; i++) {
            let temp = array[i];
            let j = i;
            while (j >= gap && array[j - gap] > temp) {
                array[j] = array[j - gap];
                j -= gap;
            }
            array[j] = temp;
        }
        gap = Math.floor(gap / 2);
    }
    return array;
}

console.time("Tempo de execução");
console.log(insertSort(ordernar));
console.timeEnd("Tempo de execução");