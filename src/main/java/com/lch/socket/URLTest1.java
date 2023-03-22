package com.lch.socket;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @BelongsProject: basic_java
 * @BelongsPackage: com.lch.socket
 * @Author: hai
 * @CreateTime: 2023-03-22  09:50
 * @Version: 1.0
 */

public class URLTest1 {
    public static void main(String[] args) {

        HttpsURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url =
                    new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fa3c22bc0-6130-4e4d-9ba1-aba94cf8e46f%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1682041873&t=d67969fb3ad7981298952bbe5103e4b0");
            urlConnection = (HttpsURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();

            fos = new FileOutputStream("yuner.jpg");

            byte[] buffer = new byte[1000];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (urlConnection != null)
                urlConnection.disconnect();
        }


    }
}
