//Lab Ex2) Implement Factorial function using a "for/while loop"

function factorial(num){
    var result=1;
    for (let i=1; i<=num; i++){
      result *= i;
    }
    return result;
  }
  
  console.log(factorial(0));
  console.log(factorial(1));
  console.log(factorial(2));
  console.log(factorial(3));
  console.log(factorial(4));
  console.log(factorial(9));