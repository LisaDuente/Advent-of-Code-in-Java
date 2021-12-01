import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DecemberOfCode {

    public DecemberOfCode(){

    }

    public int DecemberFirst(){
        File sonarRadar = new File("src/DecemberFirstText.txt");
        int countHigher = 0;
        int saveDepth = 0;
        try{
            Scanner fileReader = new Scanner(sonarRadar);

            while(fileReader.hasNext()){
                int currentDepth = fileReader.nextInt();
                if(currentDepth>saveDepth){
                    countHigher++;
                }
                saveDepth = currentDepth;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return countHigher-1;
    }

    public int DecemberFirstPart2(){
        File sonarRadar = new File("src/DecemberFirstText.txt");
        int countHigher = 0;
        int currentSum;
        int savedSum = 0;
        ArrayList<Integer> sonarData = new ArrayList<>();

        try{
            Scanner fileReader = new Scanner(sonarRadar);

            while(fileReader.hasNext()){
                sonarData.add(fileReader.nextInt());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i = 2; i<sonarData.size();i++){
            currentSum = sonarData.get(i)+sonarData.get(i-1)+sonarData.get(i-2);
            if(currentSum>savedSum){
                countHigher++;
            }
            savedSum = currentSum;
        }

        return countHigher-1;
    }

}
