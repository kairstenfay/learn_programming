/**
 * Converts an integer < 10000 into its roman numerical equivalent.
 *
 * @param num
 * @returns {*}
 */
function convertToRoman(num) {
    let roman = '';

    let romanNumerals = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1};

    const letters = Object.keys(romanNumerals);
    let remainder = num;

    for (let i = 0; i < letters.length; i++) {
        let arabic = romanNumerals[letters[i]];
        let repetitions = Math.floor(remainder / arabic);

        roman += letters[i].repeat(repetitions);
        remainder = remainder % arabic;
        console.log(remainder + ' remains!');
    }

    return roman;
}

console.log(convertToRoman(36));