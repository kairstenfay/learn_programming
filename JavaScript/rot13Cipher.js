/**
 * Returns a decoded rot13 cipher given a string.
 *
 * @param str
 * @returns {string}
 */
function rot13(str) { // LBH QVQ VG!

    let arr = str.split(" ");
    for (let i = 0; i < arr.length; i++)
    {
        let tempArr = arr[i].split("");
        tempArr = tempArr.map(x => x.charCodeAt(0));

        tempArr = tempArr.map(x => remapIfUnder65(x));
        arr[i] = tempArr.join('');
        console.log(arr[i]);
    }
    return arr.join(" ");
}

// Change the inputs below to test
console.log(rot13("LBH QVQ VG"));


/**
 * for all characters (except spaces, code 32) that would fall below 65 ('A'), loop them around to 90
 *
 * @param x
 * @returns {string}
 */
function remapIfUnder65(x) {
    x -= 13;
    let diff = 65 - x;
    if (diff > 0) {
        x = 90 - (64 - x);
    }
    return String.fromCharCode(x);
}