from typing import Any, List

class Node:
    def __init__(self, data: Any):
        self.data: Any = data
        self.children: List['Node'] = []

    def add_child(self, child: 'Node') -> None:
        self.children.append(child)

    def remove_child(self, child: 'Node') -> None:
        self.children.remove(child)

    def __str__(self, level: int = 0) -> str:
        ret = "\t" * level + repr(self.data) + "\n"
        for child in self.children:
            ret += child.__str__(level + 1)
        return ret