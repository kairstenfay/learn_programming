/**
 * Takes a string, strips non-alphanumeric characters (including underscores and spaces) and returns whether the
 * lowercase letters produce the same word left-to-right as they do right-to-left. 
 * 
 * @param str
 * @returns {boolean}
 */
function palindrome(str) {
    let temp = str.toLowerCase().replace(/\W|_/g, "");
    let rev = '';
    for (let i = temp.length - 1; i >= 0; i--) {
        rev += temp[i];
    }

    return temp === rev;
}



palindrome("e ye__"); // should return true