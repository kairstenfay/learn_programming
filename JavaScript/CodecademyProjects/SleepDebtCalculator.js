const getSleepHours = function (day) {
    switch (day) {
        case "monday":
            return 8
        case "tuesday":
            return 7
        case "wednesday":
            return 8
        case "thursday":
            return 6
        case "friday":
            return 6.5
        case "saturday":
            return 7
        case "sunday":
            return 10
    }
}

const getActualSleepHours = function () {
    let sleepSum = 0;
    const arr = ['monday','tuesday','wednesday','thursday','friday','saturday','sunday'];
    for (let i = 0; i < arr.length; i ++) {
        sleepSum += getSleepHours(arr[i]);
    }
    return sleepSum
}

const getIdealSleepHours = function(hours) {
    const idealHours = hours;
    return idealHours * 7
}

const calculateSleepDebt = function() {
    const actualSleepHours = getActualSleepHours();
    const idealSleepHours = getIdealSleepHours(8);

    if (actualSleepHours === idealSleepHours) {
        console.log("You got the perfect amount of sleep.");
    } else if (actualSleepHours > idealSleepHours) {
        console.log(`You got ${actualSleepHours - idealSleepHours} more hours of sleep than needed.`);
    } else {
        console.log(`You got ${idealSleepHours - actualSleepHours} fewer hours of sleep than needed. You should get some rest.`);
    }
}

calculateSleepDebt()
