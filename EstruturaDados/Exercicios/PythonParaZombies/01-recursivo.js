function fatorial(n) {
  if ( n <=1 ) return 1;
  return n * fatorial (n-1);
}

function pot(base, exp) {
  if (exp === 0) return 1;
  return base * pot(base, exp -1);
}

function inv(s) {
  if (s.length <= 1) return s;
  return s[s.length - 1] + inv(s.slice(1, -1)) + s[0];
}

function mdc(a, b) {
  if (a % b === 0) return b;
  return mdc(b, a%b);
}

function sd(n) {
  if (n <=9) return n;
  return sd(n / 10) + n % 10;
}

function fib(n) {
  if (n <= 2) return 1;
  return fib(n - 1) + fib(n - 2);
}

let dic = {};

function f(n) {
  if (n <= 2) return 1;
  if (!(n in dic)) {
    dic[n] = f(n - 1) + f(n - 2);
    console.log('dic:', dic);
  };
  return dic[n];
}

console.log('fatorial:', fatorial(5));
console.log('potencia:', pot(2, 3));
console.log('inverter:', inv('abc'));
console.log('mdc:', mdc(10, 8));
console.log('sd:', sd(123));
console.log('fib:', fib(7));
console.log('f:', f(7));