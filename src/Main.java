import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/nicholaskotsakis/Desktop/data-master/alcohol-consumption/drinks.csv";
        RecordSet rs = new RecordSet(fileName);
        //System.out.println(rs.getValue("beer_servings", 50));
        String[] column = rs.getColumn("beer_servings");
        for(String value : column){
            System.out.println(value);
        }
    }
}
