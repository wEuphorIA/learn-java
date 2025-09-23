package day06.day6io;

import java.io.*;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/15 下午7:38 */
public class Practice5 {
    private static final String SRC_PATH = "D:\\itheima\\";
    private static final String TAR_PATH = "C:\\Users\\wyk\\Desktop\\code\\JavaAdvanced\\homework\\src\\day06\\day6io\\";

    public static void main(String[] args) {
        BufferedInputStream bs = null;
        BufferedOutputStream bos = null;
        try  {
            File file = new File(SRC_PATH);
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File file1 : files) {
                if (file1.isFile()) {
                    bs = new BufferedInputStream(new FileInputStream(file1.getAbsolutePath()));
                    bos = new BufferedOutputStream(new FileOutputStream(TAR_PATH + file1.getName()));
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = bs.read(buffer)) != -1) {
                        bos.write(buffer, 0, len);
                    }
                    bs.close();
                    bos.close();
                }
            }

            System.out.println("执行完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bs != null){
                try {
                    bs.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
