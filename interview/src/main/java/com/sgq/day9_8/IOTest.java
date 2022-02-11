package com.sgq.day9_8;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/8 12:21
 */
public class IOTest {
    //大家一起来跳舞吧2.txt
    //打上花火.txt
    private static File file = new File("D:\\aa\\cc\\FF\\大家一起来跳舞吧2.txt");
    public static void main(String[] args) throws IOException {
           t3();
    }

    public static void t1(){

        try(OutputStream os = new FileOutputStream(file,true)){
            String word = "我去你大爷!";
            byte [] ss =word.getBytes("UTF-8");
            os.write(ss);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void t2(){
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file,true))){
            String word = "BBBBBB";
            byte [] ss =word.getBytes("UTF-8");
            bos.write(ss);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void t3(){
        try(InputStream is = new  FileInputStream(file)){
           byte [] ss = new byte[1024];
           int len = 0 ;
           int i = 0;
           while ((len=is.read(ss))!=-1){
            String  result = new String(ss,0,len);
//               System.out.println(new String(result.getBytes(),"UTF-8"));
               System.out.println(result);
               System.out.println("i======>"+(i++));
           }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void t5() throws IOException {

        StringBuffer sb = new StringBuffer();

            BufferedReader br = new BufferedReader(new FileReader(file));
            String data = "";
            int index = 1 ;
            while ((data=br.readLine())!=null){
                if(data.trim()==""){
                    System.out.println("TRUE");
                }
                sb.append(data+"\n");
                index++;
                if (index>=10)
                    break;
            }
           System.out.print(sb.toString());
           br.close();

    }
}
