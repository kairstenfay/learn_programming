/**
 * Takes a given object price and the amount a customer paid for it in cash. Assumes the customer always pays an
 * amount greater than or equal to the order price. Processes the cash against the cash in drawer (cid). Returns an
 * object detailing the status of the cash register (OPEN, CLOSED, or INSUFFICIENT_FUNDS) and an array that lists the
 * change the customer should receive in decreasing order of denomination value, according to what's available.
 *
 * @param price - price of the order
 * @param cash - the amount paid in cash by the customer
 * @param cid - a 2d array listing available currency
 * @returns object with status and change keys
 */
function giveCustomerChange(price, cash, cid) {
    const CHANGE_MAP = {'PENNY': 0.01, 'NICKEL': 0.05, 'DIME': 0.1, 'QUARTER': 0.25, 'ONE': 1.0, 'FIVE': 5.0,
                        'TEN': 10.0, 'TWENTY': 20.0, 'ONE HUNDRED': 100.0};
    let change = [];
    let status;

    let totalChange = [];
    cid.map(x => totalChange.push(x[1]));
    totalChange = totalChange.reduce((accumulator, denomination) => accumulator + denomination);
    totalChange = Math.round(totalChange * 100) / 100;

    if ((cash - price) > totalChange) {
        status = "INSUFFICIENT_FUNDS";
    } else if ((cash - price) === totalChange) {
        status = "CLOSED";
        change = cid;
    } else {
        let changeNeeded = cash - price;
        console.log(changeNeeded + ' change needed');
        for (let i = Object.keys(CHANGE_MAP).length - 1; i >= 0; i--) {
            changeNeeded = Math.round(changeNeeded * 100) / 100; // Integer bit issues
            const denomination = Object.values(CHANGE_MAP)[i];

            // Don't exceed the amount we have in the cash register for each denomination
            let quantity = Math.min((Math.floor(changeNeeded / denomination)), (Math.floor(cid[i][1] / denomination)));
            if (quantity > 0) {
                changeNeeded -= denomination * quantity;
                cid[Object.keys(CHANGE_MAP)[i]] -= denomination * quantity;
                change.push([Object.keys(CHANGE_MAP)[i], denomination * quantity]);
            }
        }
        if (changeNeeded === 0) {
            status = "OPEN";
        } else {
            status = "INSUFFICIENT_FUNDS";
            change = [];
        }
    }
    return {status: status, change: change};
}


console.log(giveCustomerChange(19.5, 20, [["PENNY", 0.01], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 1],
    ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]]));
