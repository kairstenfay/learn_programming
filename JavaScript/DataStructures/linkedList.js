/*
@channel I'm going to be assigning a bunch of problems using linked lists for the week after thanksgiving, so your
challenge this week is to build an implementation of a singly linked list.  Your data structure should implement the
following methods:

1. insert(index, data) : insert a new node at the given index
2. pop(index) : remove the node at the given index and return its value
3. print_list(): Traverse the list and print all its values
4. reverse(): Reverse the list
Bonus points for making your linked list implement common container behavior like testing whether it contains an item,
making it easily iterable, etc.

*/


class Node {
  constructor(data) {
    this.right = null;
    this.left = null;
    this.data = data;
  }
}


class LinkedList {
  constructor() {
    this._length = 0;
    this.head = null;
  }

  get length() {
    return this._length;
  }

  print() {
    let listAsAString = "~(";
    let currentNode = this.head;
    if (currentNode) {
      listAsAString += currentNode.data + ")-";
    } else {
      listAsAString += ")";
    }

    for (let i=0; i < this._length - 1; i++) {
      listAsAString += "(" + currentNode.right.data + ")-";
      currentNode = currentNode.right;
    }

    listAsAString += "]";
    console.log(listAsAString);
  }

    // todo: add to prototype? only if linked list and node are functions?
  insert(data) {

    if (!this.head) {
      console.log("Looks like there's nothing here!");  // debugging code
      this._length++;
      return this.head = new Node(data);

    } else {
      // this._insert(this.head, data);
      let currentNode = this.head;

      for (let i=0; i < this._length - 1; i++) {
        currentNode = currentNode.right;
      }

      currentNode.right = new Node(data);
      this._length++;
  }
   // TODO: create sorted lists later
   // _insert(currentNode, data) {
   //    console.log("\n Debugging the _insert method");
   //    console.log(currentNode);
   //    console.log(currentNode.data);
   //    // if (data <= currentNode.data) {
   //    //   if (currentNode.left) {
   //    //     this._insert(currentNode.left, data);
   //    //   } else {
   //    //     currentNode.left = new Node(data);
   //    //   }
   //    //
   //    // } else {
   //    //   if (currentNode.right) {
   //    //     this._insert(currentNode.left, data);
   //    //   } else {
   //    //     currentNode.right = new Node(data);
   //    //   }
   //     this._length++;
   //  }
  }

  // allows user to look at the given index without changing the underlying list
  peek (index) {
    let currentNode = this.head;

    if (!currentNode) {
      console.log("There's nothing to see!");
    } else {
      for (let i=0; i < index; i++) {
        currentNode = currentNode.right;
      }
      console.log(currentNode.data);
    }
  }

  // removes the node at the given index and returns its value
  pop () {
  }

}

/*
    def insert(self, data):
        if self.head is None:
            self._set_head(data)
        else:
            self._insert(self.head,data)

    def _insert(self, current_node, data):
        if data <= current_node.data:
            if current_node.left:
                self._insert(current_node.left,data)
            else:
                current_node.left = Node(data)
        elif data > current_node.data:
            if current_node.right:
                self._insert(current_node.right, data)
            else:
                current_node.right = Node(data)
 */

let test = new LinkedList();
console.log(test);
test.insert(1);

console.log(test);
console.log(test.head);
console.log('\n');

test.insert(3);
test.insert(4);
console.log(test);

test.print();
test.peek(0);
test.peek(2);