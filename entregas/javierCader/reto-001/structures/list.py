class CustomList:
    def __init__(self, initial_data=None):
        if initial_data is None:
            self._data = []
        else:
            self._data = list(initial_data)

    def append(self, item):
        self._data.append(item)

    def pop(self, index):
        if index < 0:
            index += len(self._data)
        if index >= len(self._data) or index < 0:
            raise IndexError("CustomList pop index out of range")
        return self._data.pop(index)

    def __getitem__(self, index):
        if isinstance(index, slice):
            return CustomList(self._data[index])
        if index < 0:
            index += len(self._data)
        if index >= len(self._data) or index < 0:
            raise IndexError("CustomList index out of range")
        return self._data[index]

    def __setitem__(self, index, value):
        if index < 0:
            index += len(self._data)
        if index >= len(self._data) or index < 0:
            raise IndexError("CustomList assignment index out of range")
        self._data[index] = value

    def __delitem__(self, index):
        del self._data[index]

    def __len__(self):
        return len(self._data)

    def __iter__(self):
        return iter(self._data)

    def __str__(self):
        return str(self._data)

    def __repr__(self):
        return f"{self.__class__.__name__}({self._data})"