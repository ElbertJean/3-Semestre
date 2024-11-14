function mergeSort(array, start = 0, end = array.length - 1) {
  if (start >= end) return;

  const middle = Math.floor((start + end) / 2);

  mergeSort(array, start, middle);
  mergeSort(array, middle + 1, end);

  merge(array, start, middle, end);
}

function merge(array, start, middle, end) {
  const aux = array.slice(start, end + 1);
  let i = 0, j = middle - start + 1, k = start;

  while (i <= middle - start && j < aux.length) {
    array[k++] = aux[i] <= aux[j] ? aux[i++] : aux[j++];
  }

  while (i <= middle - start) {
    array[k++] = aux[i++];
  }
}

const array = [38, 27, 43, 3, 9, 82, 10];
console.log("Array original:", array);
mergeSort(array);
console.log("Array ordenado:", array);
