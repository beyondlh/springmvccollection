package com.hdsx.lh.ftp;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by lh on 2016/12/16.
 */
public class ReadTextTest {
    @Test
    public void test() throws IOException {

//        InputStream inputStream = ftpClient.retrieveFileStream(new String((remoteDir + "/" + name).getBytes(), "iso-8859-1"));
        File file = new File("D:\\test.txt");
        InputStream inputStream = new FileInputStream(file);
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            System.out.println(lineTxt);
        }
        bufferedReader.close();
    }

}