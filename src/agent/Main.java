package agent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int maxCapacity;
    private static List<Knapsack> knapsacks = new ArrayList<>();
    private static int n;
    private static int maxValue = 0;
    private static int capacity = 0;
    private static int[] characteristicVector;

    public static int[] getVector(int i, int[] vector){
        vector = new int[n];
        int index = n - 1;
        int number = i;
        int bit;
        while(number > 0){
            bit = number%2;
            vector[index] = bit;
            index--;
            number /= 2;
        }
        return vector;
    }

    public static void main(String[] args) throws IOException {
        // write your code here

        long startTime = System.currentTimeMillis();

        FileReader read = new FileReader(new File("6"));
        BufferedReader buff = new BufferedReader(read);

        String line = buff.readLine();

        maxCapacity = Integer.parseInt(line);

        while((line = buff.readLine()) != null){
            knapsacks.add(new Knapsack(line.split(" ")));
        }

        n = knapsacks.size();
        int tmpCapacity;
        int tmpValue;

        int[] vector = new int[n];

        for(int i = 1; i < Math.pow(2,n); i++){
            tmpCapacity = 0;
            tmpValue = 0;
            vector = getVector(i, vector);
            for(int j = 0; j < vector.length; j++){
                tmpValue += vector[j] * knapsacks.get(j).value;
                tmpCapacity += vector[j] * knapsacks.get(j).weight;

//                if(vector[j]== 1){
//                    tmpValue += knapsacks.get(j).value;
//                    tmpCapacity += knapsacks.get(j).weight;
//                }
            }


//

            if(tmpValue > maxValue && tmpCapacity <= maxCapacity){
                maxValue = tmpValue;
                capacity = tmpCapacity;
                characteristicVector = vector;
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = (stopTime - startTime)/1000;

        System.out.print("characteristic vactor: [ ");
        for(int i = 0; i < characteristicVector.length; i++) System.out.print(characteristicVector[i] + " ");
        System.out.println("]\ntotal value: " + maxValue + "\ntotal capacity: " + capacity + "\nexecution time: "
                + elapsedTime + "s");

    }
}
