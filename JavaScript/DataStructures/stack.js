
/*
@channel
This week we'll be returning to data structures and algorithms.  We'll spend the next 2-3 weeks on stacks.

Stacks are one of the simplest and most important data structures.  The assignment this week is to implement a stack
and solve a few problems with it.  Your implementation should have the following methods
- `pop()` - removes the top element from the stack and returns it.  Errors if no items on the stack.
- `push()` - puts an element on top of the stack.  Your stack should have a max size and should throw a stack overflow
 error if push would exceed the max size.
- `peek()` - gets a copy of the top element of the stack without removing it.  Should error if no items on the stack.

You can use anything you want as the underlying data structure (e.g. a python list, your linked list from the last data
 structures section, a c array, etc.)

The problem this week is a classic one on stacks: Given an expression containing arbitrary characters as well as paired
 "parentheses", write a function to determine whether or not the parentheses are balanced.  Here parentheses are
 anything in the set `(, ), {, }, [, ]` and the remaining arbitrary characters will come from the basic ascii character
 set (specifically `string.printable` from the python `string` library).

We'll use this problem to talk about how compilers and interpreters use particular kinds of punctuation
 (or whitespace!) to create scoping rules and interpret the logic of programs.

I'll provide a test suite for the data structure and the problem (thanks Falko!) after our session on Friday.
  You should attempt to build your own test suite for these things to verify your work beforehand, though.

 */


class Stack {
  constructor(list=[], maxSize=10) {
    this._list = list;
    this._maxSize = maxSize;
    this._curlyBalance = 0;
    this._squareBalance = 0;
    this._curvyBalance = 0;
  }
  get list () {
    return this._list;
  }
  set list(someArray) {
    return this._list = someArray;
  }
  get maxSize () {
    return this._maxSize;
  }
  set maxSize(aSize) {
    this._maxSize = aSize;
    if (this._list.length > this._maxSize) {
      throw new RangeError(`You have exceeded the stack limit of ${this._maxSize}!`);
    } else {
      return this._maxSize;
    }
  }
  pop () {
    // removes the first item from the stack and returns the new stack
    if (this._list.length < 1) {
      throw new RangeError('There is nothing left to pop!');
    } else {
      return this._list.pop();
    }
  }
  push (newItem) {
    // adds an item to the top of the stack
    this._list.push(newItem);
    // check new item
    this._updateBalance(this._list[this._list.length-1]);

    if (this._list.length > this._maxSize) {
      throw new RangeError(`You have exceeded the stack limit of ${this._maxSize}!`);
    } else {
      return this._list;
    }
  }
  peek () {
    if (this._list.length < 1) {
      throw new RangeError('There is nothing in the stack to see!');
    } else {
      return this._list[this._list.length - 1];
    }
  }
  _updateBalance (listItem) {
    /*
    switch (this._list.includes()) {
      case '{':
        return this._curlyBalance++;
      case '(':
        return this._curvyBalance++;
      case '[':
        return this._squareBalance++;
      case '}':
        return this._curlyBalance--;
      case ')':
        return this._curvyBalance--;
      case ']':
        return this._squareBalance--;
        */
    // for (let i = 0; i < listItem; i++) {
      console.log('Evaluating ' + listItem);
      if (this._list[i].includes('{')) {
        this._curlyBalance++;
      } else if (this._list[i].includes('(')) {
        this._curvyBalance++;
      } else if (this._list[i].includes('[')) {
        this._squareBalance++;
      } else if (this._list[i].includes('}')) {
        this._curlyBalance--;
      } else if (this._list[i].includes(')')) {
        this._curvyBalance--;
      } else if (this._list[i].includes(']')) {
        this._squareBalance--;
      }

     // for (let j = 0; j < this._list[i].length; j++) {
     //  while (this._list[i][j] )
     }

/*  static pickSubstituteTeacher(substituteTeachers) {
    const rand = Math.floor(Math.random() * substituteTeachers.length);
    return substituteTeachers[rand];
  }
  */

}

const list = [1,2,3];

let test = new Stack();
test.list = list;
console.log(test.list);
test.pop();
console.log(test.list);

const list2 = [1,2,3,4,5];
let test2 = new Stack(list2);

console.log(test2);
test2.maxSize = 5;
test2.list = list2;
console.log(test2.list);
console.log(test2.maxSize);
// console.log(test2.push(6));
// test2.maxSize = 4;

test2.peek();
const temp = test2.peek();
console.log(temp); // makes a copy

console.log(test2.list);


let test3 = new Stack();
// test3.peek();
test3.push('3');
test3.push('4');
test3.push('5');
console.log(test3.list);
console.log('\n\n');
console.log("Testing balance function");
test3.push('{');
test3.push('}');

// console.log(test3.list.includes('{'));
console.log(test3);