package agent;

public class Knapsack {
    protected int value;
    protected int weight;

    public Knapsack(String[] vector){
        value = Integer.parseInt(vector[0]);
        weight = Integer.parseInt(vector[1]);
    }

    @Override
    public String toString(){
        return "value: " + value + ", weight: " + weight+"\n";
    }
}
