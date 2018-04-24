class Node:
    def __init__(self,data):
        self.right=self.left=None
        self.data = data

    def get(self):
        return self.data


"""
TODO: Define helper methods outside of the Solution class (i.e. as functions)
"""

class Solution:
    def __init__(self):
        self.root=None

    def _set_root(self, data): #maybe don't do this. look at properties
        self.root = Node(data)

    def insert(self, data):
        if self.root is None:
            self._set_root(data)
        else:
            self._insert(self.root,data)

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

    def to_list(self):
        sorted_list = []
        current_node = self.root
        if current_node is None:
            return sorted_list
        self._sort(current_node, sorted_list)
        return sorted_list


    def _sort(self, current_node, sorted_list): 
        if current_node.left:
            #print("I looked to the left")
            self._sort(current_node.left, sorted_list)
        sorted_list.append(current_node.data)

        if current_node.right:
            #print("I looked to the right")
            self._sort(current_node.right, sorted_list)


    def get_height(self):
        return self._height(self.root)#.left), self._height(self.root.right))

    def _height(self, root):
        if root is None: 
            return 0
        else:
            return max(self._height(root.left), self._height(root.right)) + 1

    def find(self, data):
        return self._find_node(self.root, data)

    def _find_node(self, current_node, data):
        if(current_node is None):
            return False
        elif(data == current_node.data):
            return True
        elif(data < current_node.data):
            return self._find_node(current_node.left, data)
        else:
            return self._find_node(current_node.right, data)

    def balance(self):
        current_node = self.root
        self._rotate(current_node)
        print(self._get_balance_factor(current_node))
        print(current_node.data)
        print(current_node.left.data)
        print(current_node.right.data)
        return

    def _get_balance_factor(self, current_node):
        if root is None:
            return 0
        else:
            return -1 * self._height(current_node.left) + self._height(current_node.right)

    def _rotate(self, current_node):
        if current_node is None:
            balance_factor=0
        else:
            balance_factor = -1 * self._height(current_node.left) + self._height(current_node.right)

        if balance_factor < 1: # left heavy
            saved_node = current_node
            current_node = current_node.left ## turn pointer down to the left
            current_node.right = saved_node ## previous parent
            return 
        if balance_factor > 1: # right heavy
            saved_node = current_node
            current_node = current_node.right
            current_node.left = saved_node
            return 




#T=int(input())
myTree=Solution()
#for i in range(T):
myTree.insert(3)
myTree.insert(5)
myTree.insert(2)
myTree.insert(1)
myTree.insert(4)
myTree.insert(6)
myTree.insert(7)
myTree.insert(8)


height=myTree.get_height()
#print(height)

myTree.find(1)
myTree.find(99)

myTree.to_list()
myTree.balance()