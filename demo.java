import java.io.*;

public class demo {
    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/Administrator/Desktop/1/demo1/src/public.cer";
        byte[] bytes = file2Byte(filePath);
        System.out.println(bytes.length);
        byte2File(bytes, "C:/Users/Administrator/Desktop/1/demo1/src/1.cer");
    }

    private static byte[] file2Byte(String filePath) throws IOException {
        byte[] buffer = null;
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = fileInputStream.read(b)) != -1) {
            byteArrayOutputStream.write(b, 0, n);
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteArrayOutputStream.toByteArray();
        return buffer;
    }


    private static void byte2File(byte[] buf, String filePath) {
        File file = new File(filePath);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        try {
            bufferedOutputStream.write(buf);
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

