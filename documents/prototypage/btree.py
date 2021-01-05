class Node :

    def __init__(self):
        self._value = None
        self._leftSon = None
        self._rightSon = None

    @property
    def root(self):
        return self._value

    @property
    def lson(self):
        return self._leftSon

    @property
    def rson(self):
        return self._rightSon

    def isEmpty(self):
        return self._value == None and self._leftSon == None and self._leftSon == None

    # méthode static pouvant être utilisée comme constructeur
    @classmethod
    def rooting(cls, val, ls, rs):
        node = Node()
        node._value = val
        node._leftSon = ls
        node._rightSon = rs
        return node

    # méthode static pouvant être utilisée pour construire un noeud vide
    @classmethod
    def empty(self):
        return Node()


#class BTree :

    # TODO ajouter les parcours en tant que méthodes statics