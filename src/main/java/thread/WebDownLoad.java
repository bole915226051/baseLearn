package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class WebDownLoad {
    void webDownLoad(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
            System.out.println("下载成功,name = " + fileName);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
