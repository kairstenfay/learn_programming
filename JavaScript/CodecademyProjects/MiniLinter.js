let story = 'Last weekend, I took literally the most beautiful bike ride of my life. The route is called ' +
    '"The 9W to Nyack" and it actually stretches all the way from Riverside Park in Manhattan to South Nyack, ' +
    'New Jersey. It\'s really an adventure from beginning to end! It is a 48 mile loop and it basically took me an ' +
    'entire day. I stopped at Riverbank State Park to take some extremely artsy photos. It was a short stop, though, ' +
    'because I had a really long way left to go. After a quick photo op at the very popular Little Red Lighthouse, I ' +
    'began my trek across the George Washington Bridge into New Jersey.  The GW is actually very long - 4,760 feet! ' +
    'I was already very tired by the time I got to the other side.  An hour later, I reached Greenbrook Nature ' +
    'Sanctuary, an extremely beautiful park along the coast of the Hudson.  Something that was very surprising to me ' +
    'was that near the end of the route you actually cross back into New York! At this point, you are very close to ' +
    'the end.';

let overusedWords = ['really', 'very', 'basically'];

let unnecessaryWords = ['extremely', 'literally', 'actually' ];

let storyArray = story.split(' ');
// console.log(storyArray);

let overusedWordsCounter = 0;
let sentenceCounter = 0;

storyArray.forEach(function(item, index, array) {
    // remove unnecessary words
    for (let i = 0; i < unnecessaryWords.length; i++) {
        if (item === unnecessaryWords[i]) {
            console.log(index);
            array.splice(index, 1);
        }
    }

    // count overused words
    for (let i = 0; i < overusedWords.length; i++) {
        if (item === overusedWords[i]) {
            overusedWordsCounter++;
        }
    }

    // count sentences
    for (let i = 0; i < item.length; i++) {
        if (item[i] === '.' || item[i] === '!') {
            sentenceCounter++;
        }
    }
});

let mostUsedWord = '';
let maxUses = 0;

// find most used word
for (let i = 0; i < storyArray.length; i++) {
    let word = storyArray[i];
    let uses = 0;
    for (let j = 0; j < storyArray.length; j++) {
        if (word === storyArray[j]) {
            uses++
        }
    }
    if (uses > maxUses) {
        maxUses = uses;
        mostUsedWord = word;
    }
}

// remove an overused word every other time it appears
console.log(storyArray.length);
for (let i = 0; i < storyArray.length; i++) {
    let word = storyArray[i];
    let counter = 0;
    for (let j = 0; j < storyArray.length; j++) {
        for (let k = 0; k < overusedWords.length; k++) {
            if (word === storyArray[i] && word === overusedWords[k]) {
                counter++;
                if (counter % 2 === 0) {
                    storyArray.splice(i, 1);
                }
            }
        }
    }
}
console.log(storyArray.length);

// replace remaining overused words with something else




console.log(`You used the words "${overusedWords.join(', ')}" ${overusedWordsCounter} times.`);
console.log(`You wrote ${sentenceCounter} sentences.`);
console.log(`The most used word was ${mostUsedWord}. It appeared ${maxUses} times.`);

console.log(storyArray.join(' '));
