package jar.apache.poi.excel.client;

import jar.apache.poi.excel.common.Common;
import jar.apache.poi.excel.util.ExcelUtil;
import l.demo.Demo.Student;

import java.util.List;

/**
 * @author Hongten
 * @since 2014-5-21
 */
public class Client {

    public static void main(String[] args) throws Exception {
        String read_excel2003_2007_path = Common.STUDENT_INFO_XLS_PATH;

//        String read_excel2010_path = Common.STUDENT_INFO_XLSX_PATH;
        String read_excel2010_path = "C:/Users/234607/Desktop/student_info.xlsx";
//        // read the 2003-2007 excel
//        List<Student> list = new ExcelUtil().readExcel(read_excel2003_2007_path);
//        if (list != null) {
//            for (Student student : list) {
//                System.out.println("No. : " + student.getNo() + ", name : " + student.getName() + ", age : " + student.getAge() + ", score : " + student.getScore());
//            }
//        }
        System.out.println("======================================");
        // read the 2010 excel
        List<Student> list1 = new ExcelUtil().readExcel(read_excel2010_path);
        if (list1 != null) {
            for (Student student : list1) {
                System.out.println("No. : " + student.getNo() + ", name : " + student.getName() + ", age : " + student.getAge() + ", score : " + student.getScore());
            }
        }
//        System.out.println("======================================");
//        String write_excel2003_2007_path = Common.STUDENT_INFO_XLS_OUT_PATH;
//        String write_excel2010_path = Common.STUDENT_INFO_XLSX_OUT_PATH;
//        new ExcelUtil().writeExcel(list, write_excel2003_2007_path);
//        new ExcelUtil().writeExcel(list, write_excel2010_path);
//        System.out.println("======================================");
//
//        // write the 2003-2007 excel
//        List<Student> list2 = new ExcelUtil().readExcel(write_excel2003_2007_path);
//        if (list != null) {
//            for (Student student : list2) {
//                System.out.println("No. : " + student.getNo() + ", name : " + student.getName() + ", age : " + student.getAge() + ", score : " + student.getScore());
//            }
//        }
//        System.out.println("======================================");
//        // write the 2010 excel
//        List<Student> list3 = new ExcelUtil().readExcel(write_excel2010_path);
//        if (list1 != null) {
//            for (Student student : list3) {
//                System.out.println("No. : " + student.getNo() + ", name : " + student.getName() + ", age : " + student.getAge() + ", score : " + student.getScore());
//            }
//        }
    }
}
