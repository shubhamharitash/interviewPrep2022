package ch12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class LearningPaths {
    public static void printPathDetails(Path path) {
        System.out.println("========================================================");
        System.out.println("path.getFileName()" + ":" + path.getFileName());
        System.out.println("path.getFileSystem()" + ":" + path.getFileSystem());
        System.out.println("path.getNameCount()" + ":" + path.getNameCount());
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("path.getName(i)" + ":" + path.getName(i));
        }
        System.out.println("path.getParent()" + ":" + path.getParent());
        System.out.println("path.getRoot()" + ":" + path.getRoot());
        System.out.println("path.toAbsolutePath()" + ":" + path.toAbsolutePath());
        System.out.println("path.normalize()" + ":" + path.normalize());
        System.out.println("========================================================");
    }

    public static void createNewFile(Path filePath) {
        try {
            if(filePath.getParent() != null) {
                System.out.println(filePath.getParent().toFile().mkdirs());
            }
            System.out.println(filePath.toFile().createNewFile());
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static void main(String[] args) {
        // Creating a file in cur dir
        Path path = Paths.get("testFile.txt");
        printPathDetails(path);
//        createNewFile(path);

        // For nesting
        path = Paths.get("newInterviewPrepStructure", "languages", "java", "FileHandling.txt");
        printPathDetails(path);
//        createNewFile(path);

        // Using resolve
        path = Paths.get("testPath");
        Path temp = Paths.get("parentPath");
        Path result = temp.resolve(path);
        temp = Paths.get("testFile.txt");
        result = result.resolve(temp);
        printPathDetails(result);

        // Using resolveSibling
        path = Paths.get("parentPath/testFile.txt");
        Path sibling = path.resolveSibling("testFile2.txt");
        printPathDetails(sibling);
    }
}
