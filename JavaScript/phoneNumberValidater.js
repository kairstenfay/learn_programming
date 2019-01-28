function telephoneCheck(str) {
    if (str.match(/^1?[- ]?(\((?=.*\)))?[\d]{3}((?<=\(.*)\))?[- ]?[\d]{3}[- ]?[\d]{4}$/)) {
        return true;
    } else {
        return false;
    }
    // Good luck!
}

console.log(telephoneCheck("17576227382"));