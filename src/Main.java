import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        //List<Character> pancakeList = Arrays.asList("A", "B", "C", "D", "E");
        ArrayList<Character> pancakeList = new ArrayList<Character>();
        ArrayList<Character> pancakeListVerify = new ArrayList<Character>();
        ArrayList<Character> pancakePart = new ArrayList<Character>();
        ArrayList<Character> pancakeListCopy = new ArrayList<Character>();
        int cont = 1, aux = 0, contAux = 0;
        // 65 == A && 91 == Z
        // CREANDO LA LISTA ABCDE...
        for(int i=65; i<70; i++){
            pancakeList.add((char)i);
            pancakeListCopy.add((char)i);
            pancakeListVerify.add((char)i);
        }
        
        System.out.println("Pancake ordenado: "+pancakeList);
        Collections.shuffle(pancakeList);
        System.out.println("Pancake desornado : "+pancakeList);
        System.out.println();
        System.out.println();
        //BusqAmplitud(pancakeList, pancakeListVerify);
        
        
        // Ciclo que ordena la ArrayList Pancake siempre del mayor hasta el menor.
        while(!pancakeListVerify.equals(pancakeList)){

            // Checar en que parte esta la letra mas grande del pancake
            for(int i=0; i<=pancakeList.size()-cont; i++){
                if(pancakeList.get(i) == Collections.max((pancakeListCopy)))
                    aux = i;
            }

            // Eliminar la letra maxima del pancake copy
            for(int i=0; i<=pancakeListCopy.size()-1; i++){
                if(pancakeListCopy.get(i) == Collections.max((pancakeListCopy)))
                    pancakeListCopy.remove(i);
            }

            // Obtenemos una parte del arreglo para darle vuelta
            for(int i=0; i<=aux; i++){
                pancakePart.add(pancakeList.get(i));
            }
            Collections.reverse(pancakePart);

            // Aqui añadimos la parte volteada
            for(int i=0; i<=aux; i++){
                pancakeList.set(i,pancakePart.get(i));
            }
            contAux++;
            System.out.println("Volteada num "+contAux+": "+pancakeList);
            pancakePart.clear();

            // Se vuelte a tomar la parte volteada y se realiza otro volteada
            for(int i=0; i<=pancakeList.size()-cont; i++){
                pancakePart.add(pancakeList.get(i));
            }
            Collections.reverse(pancakePart);
            for(int i=0; i<=pancakeList.size()-cont; i++){
                pancakeList.set(i,pancakePart.get(i));
            }
            contAux++;
            System.out.println("Volteada num. "+contAux+": "+pancakeList);
            pancakePart.clear();
            cont++;
        }
        
        System.out.println();
        System.out.println();
        System.out.println("- PANCAKE ORDENADO: "+pancakeList);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
