let raceNumber = Math.floor(Math.random() * 1000);

let early = true;

let age = 18;

if (early === true) {
    raceNumber += 1000;
}

let runnerGreeting = `You are runner #${raceNumber}. `

if (age > 18 && early === true) {
    console.log(runnerGreeting + "You will race at 9:30 am.");
} else if (age > 18 && early !== true) {
    console.log(runnerGreeting  + "Late adults run at 11:00 am.");
} else if (age < 18) {
    console.log(runnerGreeting + "Youth registrants run at 12:30 pm (regardless of registration).");
} else {
    console.log("Please see the registration desk.");
}