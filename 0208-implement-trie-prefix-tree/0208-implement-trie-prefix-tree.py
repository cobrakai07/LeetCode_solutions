class My_Trie:
    def __init__(self):
        self.root = Node()
    

    def insert(self,s):
        node = self.root
        for ch in s: 
            idx = ord(ch)-ord('a')
            if node.arr[idx] is None:
                node.arr[idx] = Node()
            node = node.arr[idx]
        node.isleaf = True

    def prefix(self,s):
        node = self.root
        for ch in s:
            idx = ord(ch)-ord('a')
            if node.arr[idx] is None:
                return False
            node = node.arr[idx]
        return True 

    def hasword(self,s):
        node = self.root
        for ch in s:
            idx = ord(ch)-ord('a')
            if node.arr[idx] is None:
                return False
            node = node.arr[idx]
        return node.isleaf       

class Node:
    def __init__(self):
        self.arr=[None]*26
        self.isleaf = False
class Trie:

    def __init__(self):
        self.trie = My_Trie()

    def insert(self, word: str) -> None:
        self.trie.insert(word)

    def search(self, word: str) -> bool:
        return self.trie.hasword(word)

    def startsWith(self, prefix: str) -> bool:
        return self.trie.prefix(prefix)


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)