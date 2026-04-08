import java.util.ArrayList;

public class PrintAllSubSequences {


    public static void main(String[] args) {
        int []a = {1,2,3,4};
        PrintAllSubSequences obj = new PrintAllSubSequences();
        ArrayList<Integer> objects = new ArrayList<>();
        obj.printSubSequences(a,objects,0);
    }

    void printSubSequences(int[] arr,ArrayList<Integer> output,int index){ {

        if(index>=arr.length ){
               if(output.size()>0 ) System.out.println(output);
            return;
        }
        output.add(arr[index]);

        printSubSequences(arr,output,index+1);

        output.remove(output.size()-1);
        printSubSequences(arr,output,index+1);

    }



    }
}



