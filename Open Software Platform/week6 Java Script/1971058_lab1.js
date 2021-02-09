//Lab Ex1) Implement Factorial function using a recursive function

function factorial(num){
  if (num===0){
    return 1;
  }
  return factorial (num-1)*num;
}

console.log(factorial(3));