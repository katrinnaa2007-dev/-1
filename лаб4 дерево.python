python
class TreeNode:
    def __init__(self, value):
        self.value = value
        self.children = []
    
    def add_child(self, child_node):
        self.children.append(child_node)

class Tree:
    def __init__(self):
        self.root = None
    
    def find_path(self, target_value):
        """Поиск пути от корня до узла с заданным значением"""
        def dfs(node, path, target):
            if node is None:
                return None
            path.append(node.value)
            if node.value == target:
                return path.copy()
            for child in node.children:
                result = dfs(child, path, target)
                if result:
                    return result
            path.pop()
            return None
        
        return dfs(self.root, [], target_value) if self.root else None
