function mergeSort(array) {
  if (array.length <= 1) {
    return array;
  }

  // Dividir o array ao meio
  const middle = Math.floor(array.length / 2);
  const leftArray = array.slice(0, middle);
  const rightArray = array.slice(middle);

  // Recursivamente dividir e ordenar as metades
  return merge(mergeSort(leftArray), mergeSort(rightArray));
}

function merge(leftArray, rightArray) {
  let sortedArray = [];
  let leftIndex = 0;
  let rightIndex = 0;

  // Combinar os arrays de forma ordenada
  while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
    if (leftArray[leftIndex] < rightArray[rightIndex]) {
      sortedArray.push(leftArray[leftIndex]);
      leftIndex++;
    } else {
      sortedArray.push(rightArray[rightIndex]);
      rightIndex++;
    }
  }

  // Concatenar o restante dos elementos
  return sortedArray
    .concat(leftArray.slice(leftIndex))
    .concat(rightArray.slice(rightIndex));
}

// Exemplo de uso
const array = [38, 27, 43, 3, 9, 82, 10];
console.log("Array original:", array);
const sortedArray = mergeSort(array);
console.log("Array ordenado:", sortedArray);
