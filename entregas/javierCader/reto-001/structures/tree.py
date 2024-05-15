from typing import Any, Optional, Set, List

from structures.node import Node

class Tree:
    def __init__(self, root: Optional[Node] = None):
        self.root: Optional[Node] = root

    def add_node(self, parent: Optional[Node], node: Node) -> None:
        if self.root is None:
            self.root = node
        else:
            parent.add_child(node)

    def remove_node(self, parent: Node, node: Node) -> None:
        parent.remove_child(node)

    def is_empty(self) -> bool:
        return self.root is None

    def find(self, data: Any) -> Optional[Node]:
        return self._find_node(self.root, data)

    def _find_node(self, node: Optional[Node], data: Any) -> Optional[Node]:
        if node is None:
            return None
        if node.data == data:
            return node
        for child in node.children:
            found = self._find_node(child, data)
            if found:
                return found
        return None

    def count_nodes(self) -> int:
        return self._count_nodes_recursive(self.root)

    def _count_nodes_recursive(self, node: Optional[Node]) -> int:
        if node is None:
            return 0
        count = 1
        for child in node.children:
            count += self._count_nodes_recursive(child)
        return count
    
    def dfs(self, node: Node, visited: Optional[Set[Node]] = None) -> None:
        if visited is None:
            visited = set()
        visited.add(node)
        print(node.data)
        for child in node.children:
            if child not in visited:
                self.dfs(child, visited)

    def bfs(self) -> None:
        if self.root is None:
            return
        queue: List[Node] = [self.root]
        while queue:
            current = queue.pop(0)
            print(current.data)
            for child in current.children:
                queue.append(child)

    def display_tree(self) -> None:
        if self.root is not None:
            print(self.root)
            