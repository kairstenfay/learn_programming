/**
 * Converts an integer < 10000 into its roman numerical equivalent.
 *
 * @param num
 * @returns {*}
 */
function convertToRoman(num) {
    const romanNumerals = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1};
    let roman = '';
    const letters = Object.keys(romanNumerals); // ['M', 'D', 'C', 'L', 'X', 'V', 'I'];
    let remainder = num;

    for (let i = 0; i < letters.length; i++) {
        let arabic = romanNumerals[letters[i]];

        // Check remainder to make sure we never repeat a numeral more than 3 times in a row
        if ((i - 1) % 2 === 0 && (remainder / romanNumerals[letters[i - 1]] >= 9 / 10)) {
            // if we're here, the previous index was even && remainder >= 9/10 the previous numeral
            roman += letters[i + 1] + letters[i - 1];
            remainder -= (romanNumerals[letters[i - 1]] - romanNumerals[letters[i + 1]]);

        } else if ((i - 1) % 2 === 1 && (remainder / romanNumerals[letters[i - 1]] >= 4 / 5)) {
            // if we're here, the previous index was odd && remainder >= 4/5 the previous numeral
            roman += letters[i] + letters[i - 1];
            remainder -= (romanNumerals[letters[i - 1]] - romanNumerals[letters[i]]);

        } else {
            let repetitions = Math.floor(remainder / arabic);
            roman += letters[i].repeat(repetitions);

            // Update remainder
            remainder = remainder % arabic;
        }
    }
    return roman;
}

console.log(convertToRoman(500));
