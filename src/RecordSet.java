import java.util.ArrayList;
import java.io.*;

public class RecordSet {
    private final String fileName;
    private ArrayList<String[]> data;

    public RecordSet(String fileName) throws IOException{
        this.fileName = fileName;
        this.data = new ArrayList<>();

        BufferedReader input = new BufferedReader(new FileReader(fileName));

        try{
            String[] temp;
            String line;
            /*
            int size = 0;
            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) != ',')
                    size++;
            }
            */
            while ((line = input.readLine()) != null){
                temp = line.split(",");
                data.add(temp);
            }
        } finally {
            input.close();
        }
    }

    public void display() {
        for(int i = 0; i < data.size(); i++){
            for(int j = 0; j < data.get(i).length; j++){
                System.out.print(data.get(i)[j] + " | ");
            }
            System.out.println();
        }
    }

    public String getRow(int index){
        String line = "| ";
        for(int i = 0; i < data.get(index).length; i++){
            line = line.concat(data.get(index)[i] + " | ");
        }
        return line;
    }

    public String getValue(String columnName, int index){
        for(int i = 0; i < data.get(0).length; i++){
            if(data.get(0)[i].equals(columnName)) {
                return data.get(index)[i];
            }
        }
        return "invalid";
    }

    public String[] getColumn(String columnName){
        String[] column = new String[data.size()];
        for(int i = 0; i < data.get(0).length; i++){
            if(data.get(0)[i].equals(columnName)) {
                for(int j = 0; j < data.size(); j++){
                    column[j] = data.get(j)[i];
                }
                return column;
            }
        }
        return null;
    }

}
