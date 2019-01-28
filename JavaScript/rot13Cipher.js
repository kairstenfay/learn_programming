/**
 * Returns a decoded Cesar's cipher given a string.
 *
 * @param str
 * @returns {string}
 */
function rot13(str) { // LBH QVQ VG!

    let arr = str.split("");
    arr = arr.map(x => x.charCodeAt(0));

    arr = arr.map(x => remapIfUnder65(x));
    return arr.join("");
}

// Change the inputs below to test
console.log(rot13("LBH QVQ V!!!G"));


/**
 * for all characters (except spaces, code 32) that would fall below 65 ('A'), loop them around to 90
 *
 * @param x
 * @returns {string}
 */
function remapIfUnder65(x) {
    if (!String.fromCharCode(x).match(/\W|_/)) {
        x -= 13;
        let diff = 65 - x;
        if (diff > 0) {
            x = 90 - (64 - x);
        }
    }
    return String.fromCharCode(x);
}