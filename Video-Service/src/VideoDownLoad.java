import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoDownLoad {

    public static void main(String[] args) {
        downVideo("https://vd4.bdstatic.com/mda-ni6e594jqgewm63v/cae_h264/1662545037083098117/mda-ni6e594jqgewm63v.mp4"
        ,"D:/lxyk44/c45.mp4",2000);
    }

    private static String dateToString(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
         return sdf.format(time);
    }

    public static boolean downVideo(String urlString,String filename,int timeout) {
        long start = System.currentTimeMillis();
        System.out.println(dateToString(new Date()));
        boolean ret = false;
        File file = new File(filename);
        try {
            if(file.exists()){
                ret = true;
            }else{
                System.out.println("开始下载视频文件...");
                // 构造URL
                URL url = new URL(urlString);
                // 打开连接
                HttpURLConnection con = (HttpURLConnection )url.openConnection();
                con.setConnectTimeout(timeout);
                con.setReadTimeout(timeout);
                con.connect();
                int contentLength = con.getContentLength();
                System.out.println("文件大小"+contentLength/1024/1024 +"m");
                // 输入流
                InputStream is = con.getInputStream();
                // 1K的数据缓冲
                byte[] bs = new byte[1024*5];
                // 读取到的数据长度
                int len;
                // 输出的文件流

                File file2 = new File(file.getParent());
                file2.mkdirs();
                OutputStream os = new FileOutputStream(file);
                // 开始读取
                while ((len = is.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                // 完毕，关闭所有链接
                os.close();
                is.close();
                if(contentLength != file.length()){
                    file.delete();
                    ret = false;
                }else{
                    ret = true;
                }
            }
        } catch (IOException e) {
            file.delete();
            ret = false;
        }finally {
            System.out.println(dateToString(new Date()));
            System.out.println("最终耗时:" + (System.currentTimeMillis()-start)/1000 +"s" );
            return ret;
        }

    }


}
