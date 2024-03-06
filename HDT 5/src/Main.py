import simpy
import random
import numpy as np
import matplotlib.pyplot as plt
import sys

# Parámetros de la simulación
RANDOM_SEED = 42  # Semilla para reproducibilidad
INTERVALO_LLEGADA = 10  # Intervalo de llegada de procesos
NUM_PROCESOS = [25, 50, 100, 150, 200]  # Número de procesos
RAM_SIZE = 100  # Tamaño de la memoria RAM
CPU_SPEED = 3  # Tasa de instrucciones por unidad de tiempo
INSTRUCCIONES_POR_TIEMPO = 3  # Cantidad de instrucciones por unidad de tiempo
NUM_SIMULACIONES = 100  # Número de simulaciones para calcular promedio y desviación estándar
NUM_CPUS = 1  # Número de procesadores

# Semilla para reproducibilidad
random.seed(RANDOM_SEED)

# Función que simula el ciclo de vida de un proceso en el sistema operativo
def proceso(env, nombre, RAM, CPU):
    memoria = random.randint(1, 10)
    instrucciones = random.randint(1, 10)

    # Estado NEW
    yield env.timeout(random.expovariate(1.0 / INTERVALO_LLEGADA))
    print(f'{nombre} solicita {memoria} de memoria RAM (NEW) en el tiempo {env.now:.2f}')
    yield RAM.get(memoria)
    print(f'{nombre} obtiene {memoria} de memoria RAM (NEW) en el tiempo {env.now:.2f}')

    # Estado READY
    while instrucciones > 0:
        with CPU.request() as req:
            yield req

            # Estado RUNNING
            instrucciones -= INSTRUCCIONES_POR_TIEMPO
            yield env.timeout(1 / CPU_SPEED)
            print(f'{nombre} ejecuta instrucciones, faltan {instrucciones} (RUNNING) en el tiempo {env.now:.2f}')

    # Estado TERMINATED
    yield RAM.put(memoria)
    print(f'{nombre} devuelve {memoria} de memoria RAM (TERMINATED) en el tiempo {env.now:.2f}')


# Función que realiza la simulación y calcula los tiempos promedio y desviación estándar
def simulacion(num_procesos, ram_size = RAM_SIZE, cpu_speed = CPU_SPEED, num_cpus = NUM_CPUS):
    tiempos_totales = []

    for _ in range(NUM_SIMULACIONES):
        env = simpy.Environment()
        RAM = simpy.Container(env, init = ram_size, capacity = ram_size)
        CPU = simpy.Resource(env, capacity = num_cpus)

        for i in range(num_procesos):
            env.process(proceso(env, f'Proceso {i}', RAM, CPU))

        env.run()

        tiempos_totales.append(env.now)

    promedio = np.mean(tiempos_totales)
    desviacion_estandar = np.std(tiempos_totales)

    return promedio, desviacion_estandar

# Ejecutar la simulación para diferentes cantidades de procesos
resultados_promedio = []
resultados_desviacion = []

for num_procesos in NUM_PROCESOS:
    sys.stdout = open(f'{num_procesos}procesosIntervalo{INTERVALO_LLEGADA}CPU{NUM_CPUS}RAM{RAM_SIZE}.txt', 'w')
    promedio, desviacion_estandar = simulacion(num_procesos)
    resultados_promedio.append(promedio)
    resultados_desviacion.append(desviacion_estandar)
    print("\n-----------------------------------------------")
    print(f'Numero de Procesos: {num_procesos}, Tiempo Promedio: {promedio:.2f}, Desviacion Estandar: {desviacion_estandar:.2f}')
    print("-----------------------------------------------")
    sys.stdout.close()

# Graficar los resultados
plt.figure(figsize=(10, 6))
plt.plot(NUM_PROCESOS, resultados_promedio, 'o-')
plt.errorbar(NUM_PROCESOS, resultados_promedio, yerr=resultados_desviacion, fmt = 'o')
plt.xlabel('Número de Procesos')
plt.ylabel('Tiempo Promedio')
plt.title('Tiempo Promedio de Procesos en el Sistema Operativo')
plt.grid(True)
plt.savefig(f'Intervalo{INTERVALO_LLEGADA}CPU{NUM_CPUS}RAM{RAM_SIZE}CPUSPEED{CPU_SPEED}.png') # Guardar la gráfica en un archivo
plt.show()
