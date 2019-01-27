
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
  }
  set list(someArray) {
    return this._list = someArray;
  }

  get length() {
    return this._list.length;
  }

  set maxSize(aSize) {
    this._maxSize = aSize;
    this._checkSize();
    return this._maxSize;
  }
  pop () { // TODO: test to make sure length is one less than before
    // removes the top item from the stack and returns the new stack
    if (this._list.length < 1) {
      throw new RangeError('There is nothing left to pop!');
    } else {
      this._list.pop();
      return this._list;
    }
  }

  grab (index) {
    return this._list[index];
  }

  push (newItem) {
    // adds an item to the top of the stack
    this._list.push(newItem);
    this._checkSize();
    return this._list;
  }
  peek () {
    // makes a copy of the top item in the stack
    if (this._list.length < 1) {
      throw new RangeError('There is nothing in the stack to see!');
    } else {
      return this._list[this._list.length - 1];
    }
  }
   _checkSize () {
     if (this._list.length > this._maxSize) {
       throw new RangeError(`You have exceeded the stack limit of ${this._maxSize}!`);
    }
   }
}


function _updateBalance(stack) {
    let balance = {
      // updates the balance by resetting it then checking for matches to the parentheses using a nested for loop
      curlyBalance: 0,
      curvyBalance: 0,
      squareBalance: 0
    };

    for (let i = 0; i < stack.length; i++) {
        for (let j = 0; j < stack.grab(i).length; j++) {
            switch(stack.grab([i])[j]) {
                case '{':
                    balance.curlyBalance++;
                    break;

                case '(':
                    balance.curvyBalance++;
                    break;

                case '[':
                    balance.squareBalance++;
                    break;

                case '}':
                    balance.curlyBalance--;
                    break;

                case ')':
                    balance.curvyBalance--;
                    break;

                case ']':
                    balance.squareBalance--;
                    break;
            }
        }
    }

    return balance;
}

function checkBalance (stack, balance) {
    balance = _updateBalance(stack);
    if (balance.curvyBalance !== 0 || balance.curlyBalance !== 0 || balance.squareBalance !== 0) {
        // throw new SyntaxError('Your parentheses are not balanced!');
        return "Your parentheses are not balanced!"
    } else {
        return 'You are balanced.';
    }
}

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
console.log(test3.length);
console.log(_updateBalance(test3));
console.log(checkBalance(test3));
test3.pop();
console.log(checkBalance(test3));
console.log(test3);
// test3.maxSize = 1;
console.log('\n\n');

let test4 = new Stack();
test4.push('A curly eyebrow emoticon is drawn like this: }:)                {(');
console.log(test4);
console.log(checkBalance(test4));

console.log('\n\n');

// // todo: update balance when updating list or creating instance of new Stack with list passed in
// // I removed the `list` argument from the constructor so that every new instance starts
// // with an empty stack
//
//
// console.log('Todo?');
// let newList = ['}{{{}(('];
// let test5 = new Stack();
// test5.list = newList;
// // console.log(test5); // does not reflect balance
// // test5.list = newList;
// console.log(test5); // using the setter does
// console.log(checkBalance(test5));
// console.log(test5);
// console.log(test5.peek());
//
//
// // todo: add tests to make sure that the balances are correct
// todo: make sure checkBalance works