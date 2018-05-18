/*def array_sum_recursive(array, sum=0):
if array:
return array_sum_recursive(array[1:], sum + array[0])
return sum
*/


arraySumRecursive = function(array, sum=0) {
  if (array.length > 0) {  // empty array is truthy in JS
    let firstVal = array[0];
    array.splice(0,1);  // splice returns the value (like python pop)
    return arraySumRecursive(array, sum + firstVal)
  }
  return sum
}


arraySumIterative = function(array) { // don't assume all numbers are positive
  let cumSum = array[0];
  for (let i = 1; i < array.length; i++) {
    cumSum += array[i];
  }
  return cumSum;
}

console.log("Recursive sum is: " + arraySumRecursive([1,2,3,99,201,-3]));
console.log("Iterative sum is: " + arraySumIterative([1,2,3,99,201,-3]));


// def fibonacci_recursive(n, a=1, b=1):
//   if n == 0:
//     return a
// return fibonacci_recursive(n-1, b, a+b)

fibonacciRecursive = function(n, a=1, b=1) {
  if (n===0) {
    return a;
  }
  return fibonacciRecursive(n-1, b, a+b);
};

fibonacciIterative = function(n, a=1, b=1) {
  let temp;
  for (let i = 0; i < n - 1; i++) {  // subtract one so no index error?
    temp = b;
    b = a + b;
    a = temp;
  }
  return b;
};

//[1, 1, 2, 3, 5, 8, 13]

console.log(fibonacciIterative(2));

console.log(fibonacciRecursive(8));


// >>> def ackermann_recursive(m, n):
// ...     if m==0:
// ...             return n + 1
// ...     if n==0:
// ...             return ackermann_recursive(m-1,1)
// ...     return ackermann_recursive(m-1, ackermann_recursive(m, n-1))


ackermannRecursive = function(m, n) {
  if (m==0) {
    return n + 1;
  }
  if (n==0) {
    return ackermannRecursive(m-1, 1);
  }
  return ackermannRecursive(m-1, ackermannRecursive(m, n-1));
};

ackermannIterative = function(m, n) {
  if (m==0) {
    return n + 1;
  }
  if (n==0) {
    return m // pick up here  
  }
};

console.log(ackermannRecursive(0,1));
console.log(ackermannRecursive(2,2));