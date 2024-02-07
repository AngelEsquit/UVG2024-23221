import random

def heapify(arr, n, i, ascending=False):
    largest = i
    left_child = 2 * i + 1
    right_child = 2 * i + 2

    if ascending:
        if left_child < n and arr[left_child] < arr[largest]:
            largest = left_child

        if right_child < n and arr[right_child] < arr[largest]:
            largest = right_child
    else:
        if left_child < n and arr[left_child] > arr[largest]:
            largest = left_child

        if right_child < n and arr[right_child] > arr[largest]:
            largest = right_child

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest, ascending)

def heap_sort(arr, ascending=False):
    n = len(arr)

    # Construir un max-heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i, ascending)

    # Extraer elementos uno por uno del heap
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # Intercambiar el máximo con el último elemento
        heapify(arr, i, 0, ascending)



