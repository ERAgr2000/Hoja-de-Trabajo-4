from numpy import random

#Programa para generacion de un archivo con 3000 datos al azar, para su ordenamiento.
file1 = open('myfile.txt', 'w') 

for x in range(3000):
    x = random.randint(5000)
    file1.write(str(x)+",")