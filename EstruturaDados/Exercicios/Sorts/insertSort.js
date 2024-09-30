// Grau de complexidade
/// O(n) = para o melhor caso. Esse melhor caso seria se a lista viesse ordenada
/// O(n²) = para o meio e pior caso. Caso a lista venha desordenada.

const ordernar = [8, 2, 7, 5, 1, 3, 6];

function insertSort(array) {
    for (let i = 1; i < array.length; i++) {
        let temp = array[i];
        let j = i - 1;
        while (j >= 0 && array[j] > temp) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = temp;
    }
    return array
}

console.log(insertSort(ordernar));