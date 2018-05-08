# Proyecto2Lenguajes
Proyecto Máquinas de Turing Lenguajes formales

El siguiente proyecto consiste en una aplicación Android, la cual contienen 5 máquinas de Turing simuladas que realizan distintos comportamientos cada una.

La aplicación consiste en una interfaz simple que cuenta con un Drawer lateral para acceder a cada una de las máquinas y cada una está contenida en una Actividad, que contiene un campo para ingresar la entrada, un botón para comenzar y una vista que consiste en un arreglo dinámico (Recyclerview) de vistas individuales (cada item de la cinta) la cual es una representación gráfica de una Lista que contiene cada uno de los caracteres, para efectos del funcionamiento, siempre se le agrega un espacio en blanco al inicio y al final de cada cadena.

Por la naturaleza del funcionamiento de las máquinas de Turing, cualquier input que no sea perteneciente al alfabeto o gramática de las mismas, será rechazado sin necesidad de validaciones en código.

**1.Máquina de Turing que reconoce cadenas de palíndromos**
Ésta máquina toma como entradas que pertenezcan al alfabeto {a,b,c} y determina si éstas entradas son palíndromas o no (que se leen igual de izquierda a derecha y viceversa). Para hacerlo, va comparando la primera y última letra de la misma, si la letra es igual, elimina las mismas para continuar con el proceso. 

Va a darse el caso en el que son palíndromos de longitud par, donde al final de las comparaciones no va a quedar nada en el centro, mientras que si son de longitud impar, va a quedar ya sea a,b o c en el centro, debieron de tomarse en cuenta esas consideraciones.

**1.Máquina de Turing que reconoce patrones y los copia**
Ésta máquina toma como entradas que pertenezcan al alfabeto {a,b,c} y realiza una copia idéntica de las mismas. Funciona recorriendo cada una de las letras (empezando siempre por la segunda) reemplazando las mismas con un caracter X y haciéndole un espacio al final con un caracter Y, dependiendo de la letra, es el camino que toma, la máquina va colocando las nuevas letras al final y regresando a su caracter original a las originales, el motivo de empezar por la segunda es que al principio, se coloca un caracter Y como separador, y éste es el que va a reemplazarse para copiar la primera letra y así haber copiado toda la cadena.

Cada una de las siguientes máquinas tienen un comportamiento relativamente distinto, a pesar de que su función es similar (Operaciones aritméticas)

**1.Máquina de Turing que realiza una suma en código unario**
Ésta máquina toma como input 2 cadenas de "unos" separadas por el signo "+" y realiza la operación entre las mismas. Ya que la suma inherentemente implica unión, se procede a recorrer la cadena hasta encontrar el signo +, reemplazándolo por un "uno". Aquí se unieron las 2 cadenas, sin embargo hay un "uno" de más, por lo que se llega al final de la cadena, se retrocede y se convierte el último uno en un espacio en blanco.

**1.Máquina de Turing que realiza una resta en código unario**
En el caso de la resta, al igual que la suma son 2 cadenas de "unos" pero separadas por el signo "-". Se procede convirtiendo los caracteres del sustraendo en X, y por cada X se va a convertir en Y el último "uno" del minuendo, cuando todos los caracteres del minuendo han sido consumidos, se van convirtiendo todos los símbolos que no sean 1 en blanco y el resultado queda rodeado de los mismos. Por el funcionamiento de la máquina, un resultado negativo es rechazado por la misma.

**1.Máquina de Turing que realiza una multiplicación en código unario**
En mi opinión, la más complicada. Al igual que las anteriores 2, son 2 cadenas de "unos" pero separadas por el signo "\*". 
Supongamos que tenemos nxm, donde n es una cantidad de "unos" y m es otra cantidad de "unos"

Se recorre la cadena hasta el final, agregando un símbolo "=" en el mismo, para poder separar las partes de la misma.

Luego, se recorre hasta llegar al principio del multiplicador, se va reemplazando cada uno por X, y se procede a buscar el primer símbolo del multiplicando, se reemplaza por Y y se copia al final de la cadna, esto se repite n veces.
Se procede a buscar el siguiente símbolo del multiplicador y se reemplaza por x, volvemos a hacer el procedimiento de buscar en el multiplicando (primero convirtiendo las Y que dejamos en "unos"). Ésto se realiza n veces, al final entonces habremos agregado nxm "unos" después del signo igual, por efectos de orden, se procede a volver caracter blanco a todo lo que está antes del signo igual.

