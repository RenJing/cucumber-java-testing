package impls.pages;

import org.apache.bcel.classfile.SourceFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created by twe on 11/24/15.
 */
public class Test {
    public static void main(String args[]) throws IOException {
//        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "datacollection" + File.separator + "account";
//        File sourceFile = new File(filePath);
//        int lineNumber = 4;
//
//        String content = readAppointedLineNumber(sourceFile, lineNumber);
//        System.out.println(content);
    }


//    static synchronized String readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {
//        FileReader in = new FileReader(sourceFile);
//        LineNumberReader reader = new LineNumberReader(in);
//        String s = null;
//        if (lineNumber < 0 || lineNumber > getTotalLines(sourceFile)) {
//            System.out.println("不在文件的行数范围之内。");
//        }
//        {
//            while (reader.getLineNumber() < lineNumber + 1) {
//                s = reader.readLine();
//            }
//        }
//        reader.close();
//        in.close();
//        return s;
//    }

//    static int getTotalLines(File file) throws IOException {
//        FileReader in = new FileReader(file);
//        LineNumberReader reader = new LineNumberReader(in);
//        String s = reader.readLine();
//        int lines = 0;
//        while (s != null) {
//            lines++;
//            s = reader.readLine();
//        }
//        reader.close();
//        in.close();
//        return lines;
//    }


}
