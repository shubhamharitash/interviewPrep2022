package ch17.theory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {
    public static void main(String[] args) {
        try(
                FileOutputStream outputStream = new FileOutputStream("src/main/resources/test.dat");
        ) {
            for (int i = 0; i < 10; i++) {
                outputStream.write(i);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        try(
                FileInputStream inputStream = new FileInputStream("src/main/resources/test.dat");
        ) {
            int value;
            while ((value = inputStream.read()) != -1){
                System.out.println(value);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
