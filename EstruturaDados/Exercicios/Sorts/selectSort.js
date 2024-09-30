// Grau de complexidade
// O(n²) -  For dentro de For

const ordernar = [8, 2, 7, 5, 1, 3, 6];

function selectSort(array) {
    for (let i = 0; i < array.length -1 ; i++) {
        let menorIndex = i; // menor indice começa sendo o valor que começo na varredura

        for (let j = i + 1; j < array.length; j++) {    // preciso fazer j = i + 1 para pegar o proximo item do array
            if (array[j] < array[menorIndex]) {
                menorIndex = j;
            }
        }
   
        let temp = array[i];    // pego o valor do indice do array
        array[i] = array[menorIndex];   // faço o swap do menor para o indice  
        array[menorIndex] = temp; // faz o swap para o indice
        
        console.log('array', array);                                                                             
    }
    return array;
}

console.log(selectSort(ordernar));
