import sys
import os

# Generado por IA para que corriera el test
script_dir = os.path.dirname(__file__)  # Obtiene el directorio del script
parent_dir = os.path.join(script_dir, os.pardir, 'src')  # Navega al directorio src

import unittest

from gnome import gnome_sort
from Heapsort import heap_sort
from Merge import merge_sort
from quicksort import quicksort
from Radixsort import radixSort
from selection import selection_sort
from shellSort import shell_sort

class TestSortingAlgorithms(unittest.TestCase):
    def test_gnome_sort(self):
        self.assertEqual(gnome_sort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(gnome_sort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_heap_sort(self):
        self.assertEqual(heap_sort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(heap_sort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_merge_sort(self):
        self.assertEqual(merge_sort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(merge_sort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_quick_sort(self):
        self.assertEqual(quicksort([4, 2, 7, 1, 3], 0, 4, True), [1, 2, 3, 4, 7])
        self.assertEqual(quicksort([4, 2, 7, 1, 3], 0, 4, False), [7, 4, 3, 2, 1])

    def test_radix_sort(self):
        self.assertEqual(radixSort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(radixSort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_selection_sort(self):
        self.assertEqual(selection_sort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(selection_sort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_shell_sort(self):
        self.assertEqual(shell_sort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(shell_sort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

if __name__ == "__main__":
    unittest.main()