from multiprocessing import heap
import random, timeit
import csv

from gnome import gnome_sort
from Heapsort import heap_sort
from Merge import merge_sort
from quicksort import quicksort
from Radixsort import radixSort
from selection import selection_sort
from shellSort import shell_sort

def run_algorithmsDoubleOrden(ascDescBoolean):
    numerosAleatorios = leerCSV("numeros.csv")
    start_time = timeit.default_timer()
    quicksort(numerosAleatorios, 0, len(numerosAleatorios) - 1, ascDescBoolean)
    print("quickSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    gnome_sort(numerosAleatorios, ascDescBoolean)
    gnome_sort(numerosAleatorios, ascDescBoolean)
    print("gnomeSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    heap_sort(numerosAleatorios, ascDescBoolean)
    heap_sort(numerosAleatorios, ascDescBoolean)
    print("heapSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    merge_sort(numerosAleatorios, ascDescBoolean)
    merge_sort(numerosAleatorios, ascDescBoolean)
    print("mergeSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    radixSort(numerosAleatorios, ascDescBoolean)
    radixSort(numerosAleatorios, ascDescBoolean)
    print("radixSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    selection_sort(numerosAleatorios, ascDescBoolean)
    selection_sort(numerosAleatorios, ascDescBoolean)
    print("selectionSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    shell_sort(numerosAleatorios, ascDescBoolean)
    shell_sort(numerosAleatorios, ascDescBoolean)
    print("shellSort:", timeit.default_timer() - start_time, "seconds")

def leerCSV(ruta_archivo):
    numeros = []
    with open(ruta_archivo, "r") as archivo:
        lector_csv = csv.reader(archivo)
        for fila in lector_csv:
            numeros.append(int(fila[0]))
    return numeros

def generarNum(num):
    # Generar una lista de números enteros al azar
    numeros = [random.randint(0, 10000) for _ in range(num)]

    # Especificar la ruta del archivo CSV
    ruta_archivo = "numeros.csv"

    # Guardar los números en el archivo CSV
    with open(ruta_archivo, "w", newline="") as archivo:
        escritor_csv = csv.writer(archivo)
        escritor_csv.writerows([[numero] for numero in numeros])  # Escribir números

    print("-----------------------------\n\n")

num = 300

option = int(input("Desea orden ascendente(1) o descendente(0)?\n"))
if option == 1:
    ascDescBoolean = True
    while num <= 3000:
        generarNum(num)
        print("Cantidad de números: ", num, "\n")

        run_algorithmsDoubleOrden(ascDescBoolean)
        num += 300
elif option==0:
    ascDescBoolean = False
    while num <= 3000:
        generarNum(num)
        print("\n\nCantidad de números: ", num, "\n")    

        run_algorithmsDoubleOrden(ascDescBoolean)
        num += 300
else:
    print("Opción inválida")
