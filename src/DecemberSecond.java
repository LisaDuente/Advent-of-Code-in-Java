import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DecemberSecond {
    int horizontal = 0;
    int depth= 0;
    int faults = 0;
    int aim = 0;
    File instructions = new File("src/DecemberSecond.txt");


    public int DecemberSecondPart1(){

        try{
            Scanner fileReader = new Scanner(instructions);

            while(fileReader.hasNextLine()){

                String line = fileReader.nextLine();
                String[] partHolder = line.split(" ");
                char control = partHolder[1].charAt(0);

                if(Character.isDigit(control)) {
                    if (partHolder[0].equals("up")) {
                        depth = depth - Integer.parseInt(partHolder[1]);
                    } else if (partHolder[0].equals("down")) {
                        depth = depth + Integer.parseInt((partHolder[1]));
                    } else if (partHolder[0].equals("forward")) {
                        horizontal = horizontal + Integer.parseInt(partHolder[1]);
                    } else {
                        faults++;
                    }
                }else{
                    faults++;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return depth*horizontal;
    }

    public int DecemberSecondPart2(){

        try{
            Scanner fileReader = new Scanner(instructions);

            while(fileReader.hasNextLine()){

                String line = fileReader.nextLine();
                String[] partHolder = line.split(" ");
                char control = partHolder[1].charAt(0);

                if(Character.isDigit(control)) {
                    if (partHolder[0].equals("up")) {
                        aim = aim - Integer.parseInt(partHolder[1]);
                    } else if (partHolder[0].equals("down")) {
                        aim = aim + Integer.parseInt((partHolder[1]));
                    } else if (partHolder[0].equals("forward")) {
                        horizontal = horizontal + Integer.parseInt(partHolder[1]);
                        if(aim>0) {
                            depth = depth + (Integer.parseInt(partHolder[1]) * aim);
                        }
                    } else {
                        faults++;
                    }

                }else{
                    faults++;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return depth*horizontal;
    }
}
