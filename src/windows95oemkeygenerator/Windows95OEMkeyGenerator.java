/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows95oemkeygenerator;

import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

public class Windows95OEMkeyGenerator {

    public static void main(String[] args) throws IOException {

        Random rand = new Random();

        JOptionPane.showMessageDialog(null, "on the beet brah");

        int intDay, intYear, intStageTwo, intSum = 0, intFinal;
        String strDayConverted = "", strStageTwoConverted = "", strStageThreeConverted = "";
        boolean blnDivBySeven;

        System.out.println("\t" + "Windows 95 OEM serial generator");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("\t" + "Press enter to generate a serial");
        System.out.println("");
        System.in.read();

        intDay = rand.nextInt(366 - 1) + 1;

        if (intDay < 100) {

            strDayConverted = String.format("%03d", intDay);
            System.out.print("\t \t" + strDayConverted);
        } else {
            System.out.print("\t \t" + intDay);
        }

        intYear = rand.nextInt(2003 - 1995) + 1995;
        System.out.print(String.valueOf(intYear).substring(2));
        System.out.print("-OEM-");

        intStageTwo = rand.nextInt(999999 - 1) + 1;
        strStageTwoConverted = String.format("%07d", intStageTwo);

        while (intStageTwo != 0) {
            intSum = intSum + intStageTwo % 10;
            intStageTwo = intStageTwo / 10;
        }

        blnDivBySeven = intSum % 7 == 0;

        if (blnDivBySeven == false) {

            while (blnDivBySeven == false) {

                intStageTwo = rand.nextInt(999999 - 1) + 1;
                strStageTwoConverted = String.format("%07d", intStageTwo);
                intSum = 0;
                

                while (intStageTwo != 0) {
                    intSum = intSum + intStageTwo % 10;
                    intStageTwo = intStageTwo / 10;
                }
                
                blnDivBySeven = intSum % 7 == 0;
            }

            System.out.print(strStageTwoConverted + "-");
            intFinal = rand.nextInt(99999 - 1) + 1;
            strStageThreeConverted = String.format("%05d", intFinal);
            System.out.println(strStageThreeConverted);

        } else {
            System.out.print(strStageTwoConverted + "-");
            
            intFinal = rand.nextInt(99999 - 1) + 1;
            strStageThreeConverted = String.format("%05d", intFinal);
            System.out.println(strStageThreeConverted);

        }

    }

}
