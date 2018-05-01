const getUserChoice = userInput => {
    userInput.toLowerCase();
    if (userInput === 'rock' || userInput === 'scissors' || userInput === 'paper' ||
        userInput === 'bomb') {
        return userInput
    } else {
        console.log("You idiot. Do you even RPS?");
    }
}

const getComputerChoice = () => {
    const randomNumber = Math.floor(Math.random() * 3);
    if (randomNumber === 0) {
        return "rock"
    } else if (randomNumber === 1) {
        return "paper"
    } else if (randomNumber === 2) {
        return "scissors"
    }
}

const determineWinner = (userChoice, computerChoice) => {
    if (userChoice === computerChoice) {
        return "The game was a tie."
    } else if (userChoice === "bomb") {
        return "The human won."
    } else if (userChoice === "rock") {
        if (computerChoice === "scissors") {
            return "The human won."
        } else if (computerChoice === "paper") {
            return "The computer won."
        }
    } else if (userChoice === "scissors") {
        if (computerChoice === "paper") {
            return "The human won."
        } else if (computerChoice === "rock") {
            return "The computer won."
        }
    } else if (userChoice === "paper") {
        if (computerChoice === "rock") {
            return "The human won."
        } else if (computerChoice === "scissors") {
            return "The computer won."
        }
    }
}

const playGame = function(userInput) {

    const userChoice = getUserChoice(userInput);
    console.log(`The human chose ${userChoice}.`);

    const computerChoice = getComputerChoice();
    console.log(`The computer chose ${computerChoice}.`);

    console.log(determineWinner(userChoice, computerChoice));

}

playGame("bomb");

