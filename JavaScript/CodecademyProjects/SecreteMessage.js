let secretMessage = ['Learning', 'is', 'not', 'about', 'what', 'you', 'get', 'easily', 'the', 'first', 'time,', 'it',
    'is', 'about', 'what', 'you', 'can', 'figure', 'out.', '-2015,', 'Chris', 'Pine,', 'Learn', 'JavaScript'];

ogLength = secretMessage.length

// remove last item in the array
secretMessage.pop();

const printLengths = (ogLength, secretMessage) => {
    console.log(ogLength);
    console.log(secretMessage.length);
}

printLengths(ogLength, secretMessage);

// add 'to' and 'Program' to the end of the array
secretMessage.push("to");
secretMessage.push("Program");

console.log(secretMessage.length);

// replace 'easily' with 'right'
const easilyIndex = secretMessage.indexOf("easily");
secretMessage[easilyIndex] = "right";

// remove first item in the array
secretMessage.shift();

// add 'Programming' to the beginning of the array
secretMessage.unshift('Programming');

secretMessage.length;

/*
secretMessage.forEach(function(item, index, array) {
    if (item === 'get' || item === 'right' || item === 'the' || item === 'first' || item === 'time') {
        array[index] = 'know,'
    }
    return array

});
*/

const startPos = secretMessage.indexOf('get');

const toDelete = ['get', 'right', 'the', 'first', 'time'];

secretMessage.splice(startPos, toDelete.length);

secretMessage[startPos] = 'know,';

console.log(secretMessage.join(' '));
