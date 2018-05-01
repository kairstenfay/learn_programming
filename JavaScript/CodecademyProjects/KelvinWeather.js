// today's forecast is 294 K
const kelvin = 294;

// celsius is 273 less than k
const celsius = kelvin - 273;

const fahrenheit = Math.floor(celsius * 9/5 + 32);

console.log(`The temperature is ${fahrenheit} degrees Fahrenheit.`)