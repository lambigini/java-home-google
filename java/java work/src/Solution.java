

/* 
Sorting even numbers from a file

*/

import java.io.*;  

public class Solution {
    public static void main(String[] args) throws IOException {
        //write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //BufferedWriter writer = new BufferedWriter( new FileWriter(new File(reader.readLine())));
        FileInputStream readFile = new FileInputStream(reader.readLine());
        BufferedInputStream inputStream = new BufferedInputStream(readFile);
        while (inputStream.available()>0){
            int num =(int) inputStream.read();
            System.out.println(num);
        }
        reader.close();
        readFile.close();
    }
}
