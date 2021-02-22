package com.sgq.util;


import com.sgq.pojo.Staff;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author : sgq
 * Date : 2021/1/8 16:58
 */
public class ExcelTool {
    private static Workbook wb;
    private static int count = 0;
    private static List<File> resultList = new ArrayList<>();
    public static List<Staff> readExcel2(String path, int excel_sum) {
        String excelPath = "D:/test_excel";
        List list = new ArrayList();
        if (path != null && !path.equals("")) {
            excelPath = path;
        }

        try {
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {

                readWb(excel.getAbsolutePath());

                Sheet sheet = wb.getSheetAt(0);

                System.out.println("sheet的总数:"+wb.getNumberOfSheets());

                int firstRowIndex = sheet.getFirstRowNum() ;
                System.out.println("第一条记录的位置:"+firstRowIndex);

                int lastRowIndex = sheet.getLastRowNum();

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; ++rIndex) {
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        Staff staff = new Staff();
                        staff.setId((int)Float.parseFloat(row.getCell(row.getFirstCellNum()).toString()));
                        staff.setName(row.getCell(row.getFirstCellNum() + 1).toString());
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        staff.setCreateDate(row.getCell(row.getFirstCellNum()+2).getDateCellValue());
                        list.add(staff);
                    }
                }



            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        ++count;
        if (excel_sum == count) {
            System.out.println(list.size() + "---" + list);
            return list;
        } else {
            return null;
        }
    }

    public static List<File> getAllExcel(String path){
        File file = new File(path);
        File [] arr = file.listFiles();
        for(File temp : arr){
            if(!temp.isDirectory()){
                if(temp.getName().endsWith(".xls") || temp.getName().endsWith(".xlsx")){
                    resultList.add(temp);
                }
            }else {
                getAllExcel(temp.getPath());
            }
        }
        return resultList;
    }

    public static boolean writeExcel(String name,List data) throws IOException {

        String excel = "D:/test_excel/"+name;

        OutputStream out = null ;

        int i = 0 ;


        try {
            readWb(excel);  //读取工作簿,有excel就不创建,没有就创建,创建完后会给wb赋值。

            Sheet read_sheet = wb.getSheetAt(0);

            int lastRowIndex = read_sheet.getLastRowNum();

            out = new FileOutputStream(excel);

            int firstRowIndex = read_sheet.getFirstRowNum() + 1;

            System.out.println(lastRowIndex);

            for(int row_counter = lastRowIndex+1;row_counter<data.size()+lastRowIndex+1;row_counter++){
                Row new_row = read_sheet.createRow(row_counter);

                Staff  staff = (Staff) data.get(i);
                new_row.createCell(0).setCellValue(staff.getId());
                new_row.createCell(1).setCellValue(staff.getName());
                new_row.createCell(2).setCellValue(staff.getCreateDate());
                i++;
            }
            wb.write(out);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(out != null){
                    out.flush();
                    wb.close();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(i==data.size()){
            System.out.println(i+"条数据全部导出成功!!!");
        }else {
            System.out.println("数据导出不完整!!!");
        }



        return false;
    }



    public static void  createExcel(String excelPath) throws IOException {
        //1、判断文件是否存在，存在的话，就追加新的sheet页，不存在就新建
        FileOutputStream out = new FileOutputStream(excelPath);
        // 声明一个工作薄
        Workbook workbook ;
        if(excelPath.endsWith(".xlsx")){
            workbook = new XSSFWorkbook();
        }else {
            workbook = new HSSFWorkbook();
        }

        // 生成一个表格
        workbook.createSheet("title");
        workbook.createSheet("title1");
        workbook.createSheet("title2");
        workbook.write(out);
        out.close();
        workbook.close();

    }


    public static void readWb(String file) throws IOException {
        if(!new File(file).exists()){
            createExcel(file);
        }
        if(file.endsWith(".xls")){
            FileInputStream fis = new FileInputStream(file);
            wb = new HSSFWorkbook(fis);
            fis.close();
        }else {
            wb = new XSSFWorkbook(file);
        }
    }


    public static void main(String[] args) throws IOException {
        /**
        * 测试文件下读取所有的EXCEL文件
        * */
        System.out.println(ExcelTool.getAllExcel("D:/test_excel/"));

        /**
        * 测试读取EXCEL
        * */
        ExcelTool.readExcel2("D:/test_excel/2.xls",3);
        List list = new ArrayList(){{
            add(new Staff(33,"ff",new Date()));
            add(new Staff(44,"哈哈",new Date()));
            add(new Staff(44,"我的锅哈哈",new Date()));
        }};

        /**
         * 测试写入EXCEL
         * */
        writeExcel("2.xls",list);


    }
}