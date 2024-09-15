const { nomesSimples, nomesCompostos, nomes } = require('./data.js');


const buscaNome = (list, item) => {
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

let lista = [];

for (let i = 1; i <= 100; i++) {
  lista.push(i * 2);
}

console.log(buscaNome(nomes, "Elbert"));
console.log(buscaNome(nomes, "Ana Maria"));
console.log(buscaNome(nomes, "Antônio Carlos"));
console.log(buscaNome(nomesSimples, "Elbert"));
console.log(buscaNome(nomesSimples, "Ana"));
console.log(buscaNome(nomesCompostos, "Elbert"));
console.log(buscaNome(nomesCompostos, "Ana Maria"));
