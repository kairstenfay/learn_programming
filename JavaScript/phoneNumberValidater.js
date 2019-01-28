function phoneNumberValidater(str) {
    if (str.match(/^1?[- ]?(\((?=.*\)))?[\d]{3}((?<=\(.*)\))?[- ]?[\d]{3}[- ]?[\d]{4}$/)) {
        return true;
    } else {
        return false;
    }
}

console.log(phoneNumberValidater("17576227382"));