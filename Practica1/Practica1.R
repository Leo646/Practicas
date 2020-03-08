#1. ¿Cual es la suma de los primeros 100 enteros positivos? La formula de la suma de
#   los enteros desde 1 hasta n es: n(n+1)/2. Defina n = 100 y luego calcule la suma desde 1
#   hasta 100 usando la formula.
      n=100
      a<-n*(n+1)/2
      a
#2. Ahora use la misma formula para calcular la suma de los enteros del 1 al 10000
      n=10000
      a<-n*(n+1)/2
      a
#3. Ejecute el siguiente código en R:
      n <- 1000
      x <- seq(1, n)
      x
      sum(x)
    # Basado en los resultados que hacen las funciones sum y seq?.
       #b. Seq crea una lista de números y sum los suma a todos ellos.
      
#4. Cargue US murders dataset.
    #library(dslabs)
    #data(murders)
    #Use la función str para examinar su estructura. Podemos ver que el objeto es un
    #dataframe.Cuál de las siguientes opciones describe mejor las variables representadas en
    #este data frame?
      library(dslabs)
      data(murders)
      str(murders)
      # A. Los 51 estados
#5. ¿Cuales son los nombres de las columnas usadas para este dataframe?
      head(murders)
#6. Use el “accessor” $ para extraer las abreviaturas de cada estado y asignelas al
    #objeto a. Determine el tipo de dato para este objeto.   
      a<-murders$abb
      a
      class(a)
#7. Ahora use los corchetes para extraer las abreviaturas de cada estado y asígnelas al
#   objeto b. Use la función “identical” para determinar si a y b son iguales
      b<- a[]
      b
      identical(a,b)
#8. La función table toma un vector como argumento y devuelve la frecuencia para
#  cada elemento. Puede ver rápidamente cuántos estados hay en cada región aplicando esta
#  función. Use esta función en una línea de código para crear una tabla de estados por
#  región
      table((murders$state),(murders$region))
      
      
      
a=c(1:10000)
sum(a)