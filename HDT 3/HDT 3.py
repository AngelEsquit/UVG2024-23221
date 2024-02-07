from multiprocessing import heap
import random
import csv

from gnome import gnome_sort
from Heapsort import heap_sort
from Merge import merge_sort
from quicksort import quicksort
from Radixsort import radixSort
from selection import selection_sort
from shellSort import shell_sort


def leerCSV(ruta_archivo):
    numeros = []
    with open(ruta_archivo, "r") as archivo:
        lector_csv = csv.reader(archivo)
        for fila in lector_csv:
            numeros.append(int(fila[0]))
    return numeros

def generarNum():
    # Generar una lista de números enteros al azar
    numeros = [random.randint(0, 10000) for _ in range(3000)]

    # Especificar la ruta del archivo CSV
    ruta_archivo = "numeros.csv"

    # Guardar los números en el archivo CSV
    with open(ruta_archivo, "w", newline="") as archivo:
        escritor_csv = csv.writer(archivo)
        escritor_csv.writerows([[numero] for numero in numeros])  # Escribir números

    print("Los números se han guardado exitosamente en el archivo CSV.")

while True:    
    print("Algoritmos de Ordenamiento:")
    print("1. Selection Sort")
    print("2. Insertion Sort")
    print("3. Merge Sort")
    print("4. Quick Sort")
    print("5. Heap Sort")
    print("6. Radix Sort")
    
    sort_option = int(input("Seleccione el algoritmo de ordenamiento (1-6): "))
    ascendente = input("Ordenar de forma ascendente? (s/n): ").lower() == "s"
    if sort_option == 1:
        generarNum()
        sorted_numbers = gnome_sort(leerCSV("numeros.csv"), ascendente)
    elif sort_option == 2:
        generarNum()
        sorted_numbers = merge_sort(leerCSV("numeros.csv"), ascendente)
    elif sort_option == 3:
        generarNum()
        sorted_numbers = quicksort(leerCSV("numeros.csv"), 0, len(leerCSV("numeros.csv")) - 1, ascendente)
    elif sort_option == 4:
        generarNum()
        sorted_numbers = radixSort(leerCSV("numeros.csv"), ascendente)
    elif sort_option == 5:
        generarNum()
        sorted_numbers = selection_sort(leerCSV("numeros.csv"), ascendente)
    elif sort_option == 6:
        generarNum()
        sorted_numbers = shell_sort(leerCSV("numeros.csv"), ascendente)
    elif sort_option == 7:
        generarNum()
        sorted_numbers = heap_sort(leerCSV("numeros.csv"), ascendente)
    else:
        print("Opción inválida")
        sorted_numbers = []

    print("Números ordenados:", sorted_numbers)
