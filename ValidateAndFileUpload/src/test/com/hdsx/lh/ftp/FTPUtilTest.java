package com.hdsx.lh.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.taglibs.standard.lang.jstl.RelationalOperator;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by lh on 2016/12/16.
 */
public class FTPUtilTest {
    private String remoteDir = "/05.雷浩/软件";
//    private String remoteDir = "/home/QXJ";

    @Test
    public void test() {
        Boolean login = false;
        FTPClient ftpClient = new FTPClient();
        FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
        conf.setServerLanguageCode("zh");
        ftpClient.configure(conf);
        try {
            ftpClient.connect("211.101.37.253");
            login = ftpClient.login("leih", "leih123");
            if (!login) {
                System.out.println("登录失败.");
                return;
            }
            ftpClient.setControlEncoding("GBK");//   gb2312
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            FTPFile[] remoteFiles = ftpClient.listFiles(new String(remoteDir.getBytes("GBK"), "iso-8859-1"));
            System.out.println("目录" + remoteDir + "下的文件:");
            if (remoteFiles != null) {
                String filePath = "D:\\TEST\\";
                for (int i = 0; i < 1; i++) {
                    OutputStream os = null;
                    BufferedOutputStream bufferedOutputStream = null;
                    String name = remoteFiles[i].getName();
                    File tempFile = new File(filePath + name);
                    os = new FileOutputStream(tempFile);
                    bufferedOutputStream = new BufferedOutputStream(os, 1024);
                    ftpClient.retrieveFile(new String((remoteDir + "/" + name).getBytes(), "iso-8859-1"), bufferedOutputStream);

                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    os.flush();
                    os.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                    ftpClient.logout();
                    ftpClient.disconnect();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}