package cryptoCypher;

import java.util.ArrayList;
import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		Scanner inputFile = new Scanner("TestingArrays.txt");
        ArrayList<ArrayList<Double>> tempList = new ArrayList<ArrayList<Double>>();
        while (inputFile.hasNextInt()) {
       	 Scanner columnsReader = new Scanner(inputFile.nextLine());
       	 ArrayList colList = new ArrayList();
       	 while (columnsReader.hasNextDouble()) {
       		 colList.add(columnsReader.nextDouble());
       	 }
       	 tempList.add(colList);
        }
        
        System.out.print(tempList);
        
//        double array[][] = [tempList.size()][];
//        
//        
//        for (int i = 0; i< tempList.size(); i++) {
//        	for (int j  = 0; j<i ; j++) {
//        		System.out.print(tempList[i][j]);
//        	}
//        }
//		
		inputFile.close();
	}
}