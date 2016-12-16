package com.hdsx.lh.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

/**
 * Created by lh on 2016/12/16.
 */
public class FTPUtil {
    {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("211.101.37.253",21);
            ftpClient.login("leih", "leih123");
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void DownloadConfigFile() {

    }
}
