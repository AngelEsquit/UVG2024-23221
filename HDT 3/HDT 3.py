import random
import csv

# Generar una lista de números enteros al azar
numeros = [random.randint(0, 10000) for _ in range(3000)]

# Especificar la ruta del archivo CSV
ruta_archivo = "numeros.csv"

# Guardar los números en el archivo CSV
with open(ruta_archivo, "w", newline="") as archivo:
    escritor_csv = csv.writer(archivo)
    escritor_csv.writerows([[numero] for numero in numeros])  # Escribir números

print("Los números se han guardado exitosamente en el archivo CSV.")

