// Grau de complexidade
/// O(n) = Para o melhor caso. Caso a lsita já venha ordernada.
/// O(n^3/2) = Para o caso médio, sequência do Gap dividido por 2. (Existem gaps melhores, pesquisar ...)
/// O(n²) = Pior caso. Caso a lista venha desordenada e necessite passar sempre pelo While.


//Knuth
let ordernar = Array.from({ length: 1000 }, () => Math.floor(Math.random() * 1000));

function mathGap(array) {
    let gaps = [];
    let k = 1;
    let gap;

    while ((gap = Math.floor((Math.pow(3, k) - 1) / 2)) < array.length) {
        gaps.unshift(gap);
        k++;
    }
    return gaps;
}

console.log('mathGap', mathGap(ordernar));

function insertSort(array) {

    let gaps = mathGap(array);

    for(let gap in gaps) {
        for (let i = gap; i < array.length; i++) {
            let temp = array[i];
            let j = i;
            while (j >= gap && array[j - gap] > temp) {
                array[j] = array[j - gap];
                j -= gap;
            }
            array[j] = temp;
        }
    }
    return array;
}

console.time();
console.log(insertSort(ordernar));
console.timeEnd()