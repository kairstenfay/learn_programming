
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
  constructor(maxSize=10) {
    this._list = [];
    this._maxSize = maxSize;
    this._curlyBalance = 0;
    this._squareBalance = 0;
    this._curvyBalance = 0;
  }
  get list () {
    return this._list;
  }
  set list(someArray) {
    this._updateBalance();
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
  pop () { // TODO: test to make sure length is one less than before
    // removes the top item from the stack and returns the new stack
    if (this._list.length < 1) {
      throw new RangeError('There is nothing left to pop!');
    } else {
      this._list.pop();
      this._updateBalance();
      return this._list;
    }
  }
  push (newItem) {
    // adds an item to the top of the stack
    this._list.push(newItem);
    this._updateBalance();

    if (this._list.length > this._maxSize) {
      throw new RangeError(`You have exceeded the stack limit of ${this._maxSize}!`);
    } else {
      return this._list;
    }
  }
  peek () {
    // makes a copy of the top item in the stack
    if (this._list.length < 1) {
      throw new RangeError('There is nothing in the stack to see!');
    } else {
      return this._list[this._list.length - 1];
    }
  }
  _updateBalance () {
    // updates the balance by resetting it then checking for matches to the parentheses using a nested for loop
    this._curlyBalance = 0;
    this._curvyBalance = 0;
    this._squareBalance = 0;

    for (let i = 0; i < this._list.length; i++) {
      for (let j = 0; j < this._list[i].length; j++) {
        switch(this._list[i][j]) {
          case '{':
            this._curlyBalance++;
            break;

          case '(':
            this._curvyBalance++;
            break;

          case '[':
            this._squareBalance++;
            break;

          case '}':
            this._curlyBalance--;
            break;

          case ')':
            this._curvyBalance--;
            break;

          case ']':
            this._squareBalance--;
            break;
        }
      }
    }
  }
   checkBalance () {
    this._updateBalance();
    if (this._curvyBalance !== 0 || this._curlyBalance !== 0 || this._squareBalance !== 0) {
      // throw new SyntaxError('Your parentheses are not balanced!');
      return "Your parentheses are not balanced!"
    } else {
      return 'You are balanced.';
    }
   }

/*  static pickSubstituteTeacher(substituteTeachers) {
    const rand = Math.floor(Math.random() * substituteTeachers.length);
    return substituteTeachers[rand];
  }
  */

}

// const list = [1,2,3];
//
// let test = new Stack();
// test.list = list;
// console.log(test.list);
// test.pop();
// console.log(test.list);
//
// const list2 = [1,2,3,4,5];
// let test2 = new Stack();
// test.list = list2
//
// console.log(test2);
// test2.maxSize = 99;
// console.log(test2.list);
// console.log(test2.maxSize);
// // console.log(test2.push(6));
// // test2.maxSize = 4;
//
// const temp = test2.peek();
// console.log(temp); // makes a copy
// console.log(test2.list);


let test3 = new Stack();
// test3.peek();
test3.push('3');
test3.push('4');
test3.push('5');
test3.push('{');
test3.push('}(');
test3.push('(');
test3.push('}');
console.log(test3);
console.log(test3.checkBalance());
test3.pop();
console.log(test3.checkBalance());
console.log(test3);
console.log('\n\n');

let test4 = new Stack();
test4.push('A curly eyebrow emoticon is drawn like this: }:)                {(');
console.log(test4);
console.log(test4.checkBalance());

console.log('\n\n');

// todo: update balance when updating list or creating instance of new Stack with list passed in
// I removed the `list` argument from the constructor so that every new instance starts
// with an empty stack


console.log('Todo?');
let newList = ['}{{{}(('];
let test5 = new Stack();
test5.list = newList;
// console.log(test5); // does not reflect balance
// test5.list = newList;
console.log(test5); // using the setter does
console.log(test5.checkBalance());
console.log(test5);
console.log(test5.peek());


// todo: add tests to make sure that the balances are correct
// todo: make sure checkBalance works
