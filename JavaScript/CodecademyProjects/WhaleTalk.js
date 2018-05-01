const input = "A peculiar phrase.";

const vowels = ['a', 'e', 'i', 'o', 'u'];

let resultArray = [];

for (let i = 0; i < input.length; i++) {
    console.log(input[i]);
    for (let j = 0; j < vowels.length; j++) {
        if (input[i].toLowerCase() === vowels[j]) {
            resultArray.push(input[i])
        }
    }
    // double e's and u's
    if (input[i] === 'e' || input[i] === 'u') {
        resultArray.push(input[i]);
    }
    }

console.log(resultArray.join('').toUpperCase());