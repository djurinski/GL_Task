import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to be searched, than pres enter, or leave blank for default: ");
        String inputString = sc.nextLine();
        if (inputString.isEmpty()){
            inputString = "I love to work in global logic";
        }
        System.out.print("Enter letters to be searched in text as one word, than press enter (leave blank for default (LOGIC)): ");
        String frequencyString = sc.nextLine();
        if (frequencyString.isEmpty()){
            frequencyString = "LOGIC";
        }



        Frequency.count(inputString, frequencyString);





    }
}
