const { numeros } = require('./data.js');

const buscaNumero = (list, item) => {
  let baixo = 0;
  let alto = list.length -1;
  let contador = 0;
  
  while (baixo <= alto) {
    let meio = Math.floor((baixo + alto) / 2);
    let chute = list[meio];

    contador ++;
    console.log('vezes no looping: ', contador);

    if (chute === item) {
      return meio;
    } else if (chute > item) {
      alto = meio - 1;
    } else {
      baixo = meio + 1;
    }
  }
  return null;
}

console.log(buscaNumero(numeros, 24));
console.log(buscaNumero(numeros, 45));
