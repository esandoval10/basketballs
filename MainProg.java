import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainProg {

    static String fileName = " "; // /Users/ESE1307/Desktop/Basketballs.txt //
    static BufferedReader br;
    private static Scanner sc;

    public static void main(String[] args) throws NumberFormatException, IOException {
        sc = new Scanner(System.in);
        System.out.println("Enter full file name with address location");
        fileName = sc.next();

        FileReader fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        int counter = countLine();
        double[][] objects = new double[counter][];
        String temp[];
        String currentLine;
        int i = 0;
        int countBall = 0;
        int countBox = 0;
        double smallestVolume = 0;

        while ((currentLine = br.readLine()) != null) { // reads line//
            temp = currentLine.split(" "); // Splits it after every space//
            objects[i] = new double[temp.length]; // array at i defines length of that row//
            if (objects[i].length == 3)
                countBox++;
            else
                countBall++;
            for (int j = 0; j < temp.length; j++) { //
                objects[i][j] = Double.parseDouble(temp[j]); // stores values at the array//
            }
            i++;// adds one to row place//
        }

        Basketball[] bk = new Basketball[countBall];
        boxType[] bx = new boxType[countBox];
        boxType Fitbox = null;
        int noCount = 0;
        double noBox[] = new double[countBall];

        int k = 0;
        int j = 0;
        for (i = 0; i < objects.length; i++) {
            if (objects[i].length == 3) {
                bx[k] = new boxType(objects[i][0], objects[i][1], objects[i][2]);
                k++;
            } else {
                bk[j] = new Basketball(objects[i][0]);
                j++;
            }
        }

        // bB = basketBall bT = boxType//

        for (int bB = 0; bB < bk.length; bB++) {
            boolean fits = false;
            for (int bT = 0; bT < bx.length; bT++) {
                System.out.println("Ball: " + bk[bB].getRadius());
                System.out.println("Box " + "Length:" + bx[bT].getLength() + " Width:" + bx[bT].getWidth() + " Height:"
                        + bx[bT].getHeight());
                if (bx[bT].fitsInBoxType(bk[bB])) {

                    if (0 == smallestVolume) {
                        smallestVolume = bx[bT].getVolume();
                        Fitbox = bx[bT];
                    } else {
                        if (smallestVolume > bx[bT].getVolume()) {
                            smallestVolume = bx[bT].getVolume();
                            Fitbox = bx[bT];
                        }
                    }
                    fits = true;
                }
                System.out.println("Empty space available : " + bx[bT].emptySpace(bk[bB]));
                System.out.println("    ");
            }

            if (!fits) {
                noCount = noCount + 1;
                noBox[noCount] = bk[bB].getRadius();
                System.out.println("Box not available for this basketball ");
                System.out.println("    ");
            } else {
                System.out.println("Smallest available box Length: " + Fitbox.getLength() + " Width: "
                        + Fitbox.getWidth() + " Height: " + Fitbox.getHeight());
                System.out.println("    ");
            }
        }

        int fit = bk.length - noCount;
        System.out.println("  ");
        System.out.println("Number of Basketballs that fit into a box: " + fit);
        System.out.println("List of radius of basketballs that do not fit in any box:");

        for (int big = 0; big < noBox.length; big++) {
            if (0 != noBox[big]) {
                System.out.println(noBox[big] + " ");
            }
        }
    }

    public static int countLine() throws FileNotFoundException {

        BufferedReader reader;
        FileReader file = new FileReader(fileName);
        reader = new BufferedReader(file);
        int counter = 0;
        @SuppressWarnings("unused")
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                counter++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return counter;
    }
}