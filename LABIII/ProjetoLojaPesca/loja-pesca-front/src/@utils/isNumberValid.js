function isNumberValid(number) {
  const numberRegex = /^(\+?\d{1,2}\s?)?(\(?\d{2,3}\)?\s?)?\d{4,5}[-.\s]?\d{4}$/;
  return numberRegex.test(number);
}

export default isNumberValid;