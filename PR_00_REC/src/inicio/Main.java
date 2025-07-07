package inicio;

import dominio.Persona;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //------------------------------VECTORES
        int[] vector = {2, 4, 6, 1};
        System.out.println(sumaVector(vector));
        System.out.println("RECURSIVO V1");
        System.out.println(sumaVectorRecursivo(vector));
        System.out.println("RECURSIVO V2");
        System.out.println(sumaVectorRecursivoV2(vector));

        System.out.println("el minimo Recursivo es : ");
        System.out.println(elementoMinimoRecursivo(vector));
        System.out.println("Mostrar Ascendente : ");
        //mostrarAscendente(5);
        System.out.println("minimo Elemento-SEBAS: ");
        System.out.println(eLminElemnto(vector));

        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(sumaDiagonales(matriz));

        //------------------------------------------------------------------------------------------------------------------------

        /*
         Press Alt+Intro with your caret at the highlighted text to see how
         IntelliJ IDEA suggests fixing it.
         System.out.printf("Hello and welcome!");
         Press Mayús+F10 or click the green arrow button in the gutter to run the code.
                for (int i = 1; i <= 5; i++) {

                    // Press Mayús+F9 to start debugging your code. We have set one breakpoint
                    // for you, but you can always add more by pressing Ctrl+F8.
                    System.out.println("i = " + i);
                }

        System.out.println(promedio(5, 2));
        Persona p1 = new Persona("TEo", 2, "321");
        Persona p2 = new Persona("Mia", 3, "456");
        //Persona p1= new Persona();
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        */


    }

    //----------------------------------------------------------PRACTICO 0 ------------------------------------------------------------------


    //matriz sumar diagonales
    /*
     * {1,2,3,4}, 0-3
     * {5,6,7,8}, 1-2
     * {9,10,11,12}, 2-1
     * {13,14,15,16} 3-0
     * */

    //Ejercicio 2: Matrices Implemente un algoritmo que dado una matriz devuelva la suma de todos los elementos de sus diagonales.
    // En caso de que la matriz tenga dimensión impar y por lo tanto ambas diagonales compartan un mismo elemento,
    // el mismo deberá ser contabilizado solo 1 vez.

    //la mejor versión más optima ir de todas las puntas hacia adentro:
    public static int sumaDiagonalesV4(int[][] matriz) {
        int suma = 0;

        for (int i = 0; i < matriz.length / 2; i++) {
            suma += matriz[i][i];                                           //   ↘  mitad de elementos diagonal PRINCIPAL desde 00 ( DER a IZQ )
            suma += matriz[matriz.length - 1 - i][i];                       //   ↗   mitad de elementos diagonal SECUNDARIA desde 40 ( IZQ a DER )
            suma += matriz[i][matriz.length - 1 - i];                       //   ↙   mitad de elementos diagonal SECUNDARIA desde 0.4 a medida que i aumenta J disminuye
            suma += matriz[matriz.length - 1 - i][matriz.length - 1 - i];  //    ↖  mitad de elementos diagonal PRINCIPAL desde 44  ( DER a IZQ )
        }

        //Ahora debo restar el repetido (si es que es impar)

        if (matriz.length % 2 == 1) {
            suma -= matriz[matriz.length / 2][matriz.length / 2]; //ESTE ES EL ELEMENTO DEL MEDIO
        }
        return suma;
    }


    public static int sumaDiagonalesV3(int[][] matriz) {
        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][i]; //suma elementos diagonal principal
            suma += matriz[i][matriz.length - 1 - i]; //suma elementos diagonal secundaria
            //suma+= matriz[matriz.length-1-i][i]; //suma elementos diagonal secundaria eMPIEZO DESDE IZQUIERDA A DERECHA eJEMPLO  I=0 4= J = 0
            //suma+= matriz[matriz.length-1-i][matriz.length-1-i]; //suma elementos diagonal secundaria eMPIEZO DESDE IZQUIERDA A DERECHA eJEMPLO  I=0 4= J = 0
        }
        //Ahora debo restar el repetido (si es que es impar)

        if (matriz.length % 2 == 1) {
            suma -= matriz[matriz.length / 2][matriz.length / 2]; //ESTE ES EL ELEMENTO DEL MEDIO
        }
        return suma;
    }


    //ESTE RECORRE LAS DOS DIAGONALES A LA MISMA VEZ, EL PRIMER IF RESUELVE QUE ESTAN CRUZANDOSE EN EL MISMO PUNTO
    //TIENE EL MISMO ORDEN QUE DEPENDE DEL NUMERO DE ELEMENTOS
    public static int sumaDiagonalesV2(int[][] matriz) {
        int col = 0; //esta va incrementando
        int col2 = matriz.length - 1; // esta va decrementando
        int fila = 0;
        int fila2 = matriz[0].length - 1;
        int sumaTotal = 0;
        //La desventaja de este es que en todas las iteraciones estoy preguntando si estoy en el elemento cental.

        while (col < matriz.length) {
            if (col == col2 && fila == fila2) {
                sumaTotal += matriz[col][fila];
            } else {
                sumaTotal += matriz[col][fila] + matriz[col2][fila2];

            }
            col++;
            fila++;
            col2--;
            fila2--;
        }
        return sumaTotal;
    }

    //Este tiene orden cuadratico, es el peor
    public static int sumaDiagonales(int[][] matriz) {

        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if (i == j || i + j == matriz.length - 1) {
                    suma += matriz[i][j];
                }


            }

        }

        return suma;
    }

    // 1-B ---Implemente un algoritmo que encuentre el mínimo elemento de un vector de forma recursiva. (vector de enteros).

    public static int elementoMinimoRecursivo(int[] vector) {
        return elementoMinimoRecursivo(vector, 0, vector.length - 1);

    }

    private static int elementoMinimoRecursivo(int[] vector, int posDesde, int posHasta) {

        if (posDesde == posHasta) {
            return vector[posDesde];
        } else {
            int minimo = elementoMinimoRecursivo(vector, posDesde, posHasta - 1);
            if (minimo < vector[posHasta]) {
                return minimo;
            } else {
                return vector[posHasta];
            }
        }
    }


    // otra versión

    public static int eLminElemnto(int[] vec) {

        return eLminElemnto(vec, 0);
    }

    private static int eLminElemnto(int[] vector, int posDesde) {

        if (posDesde == vector.length - 1) {
            return vector[posDesde];
        }
      //  int minimoIzq = vector[posDesde];
      //  int minimoDerecha = eLminElemnto(vector, posDesde + 1);
        /*
        if (minimoIzq <= minimoDerecha) {
            return vector[posDesde];
        } else {
            return minimoDerecha;
        }
        */
        return Math.min(vector[posDesde], eLminElemnto(vector, posDesde + 1));


    }

    public static int minimo(int[] vec) {

        int minimo = Integer.MAX_VALUE;
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] < minimo) {
                minimo = vec[i];
            }
        }
        return minimo;
    }


    // 1-A --Vectores-Implemente un algoritmo que sume los elementos de un vector. Hacerlo tanto de manera iterativa y recursiva.

    public static int sumaVector(int[] vector) {
        int suma = 0; //es el neutro
        for (int i = 0; i < vector.length; i++) {
            suma += vector[i];

        }
        return suma;
    }

    public static int sumaVectorV2(int[] vector) {
        int suma = 0; //es el neutro
        for (int i = vector.length - 1; i >= 0; i--) {
            suma += vector[i];

        }
        return suma;
    }

    //--------------------------------------------------------------RECURSIVA------------------------------------
    public static int sumaVectorRecursivo(int[] vec) {
        return sumaVectorRecursivo(vec, 0, vec.length - 1);
    }

    private static int sumaVectorRecursivo(int[] vec, int posDesde, int posHasta) {
        if (posDesde == posHasta) { //estoy en array de un solo elemento o largo 1
            System.out.println(vec[posDesde]);
            return vec[posDesde];
        }
        //¿como Dividir Problema? -> 1.- Quedarme con un elemento y la llamada rec es lo que queda o ->  2.PARTIR AL MEDIO dos llamadas rec una por cada mitad
        int sumtIzq = vec[posDesde];
        int sumDer = sumaVectorRecursivo(vec, posDesde + 1, posHasta);

        return sumtIzq + sumDer;
    }

    public static int sumaVectorRecursivoV2(int[] vec) {
        return sumaVectorRecursivoV2(vec, 0, vec.length - 1);
    }

    private static int sumaVectorRecursivoV2(int[] vec, int posDesde, int posHasta) {
        if (posDesde == posHasta) { //estoy en array de un solo elemento o largo 1
            return vec[posDesde];
        }
        int posMedio = (posDesde + posHasta) / 2;
        int sumtIzq = sumaVectorRecursivoV2(vec, posDesde, posMedio);
        int sumDer = sumaVectorRecursivoV2(vec, posMedio + 1, posHasta);

        return sumtIzq + sumDer;
    }

    //- //-----------------------------------------------------------------------------------------------------------------------------------
    public static float promedio(int date1, int date2) {
        //return ((float)date1+date2)/2;
        return (date1 + date2) / 2f;
    }

    public static void mostrarAscendente(int numero) {
        if (numero > 0) {
            System.out.println(numero);
        } else {
            mostrarAscendente(numero - 1);
            System.out.println(numero);
        }


    }

}