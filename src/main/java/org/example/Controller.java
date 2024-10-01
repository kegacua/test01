package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private List<Students> students = new ArrayList<Students>();

    public Controller() {
        doc_file();
    }

    //them sinh vien
    public  void them(String name, String gender, int age, double toan, double ly, double hoa){
        students.add(new Students(name, gender, age, toan, ly, hoa));
    }
    //update by id
    public  void update_id(int id, String name, String gender, int age, double toan, double ly, double hoa){
        for(Students s : students){
            if(s.getId()==id){
                s.setName(name);
                s.setGender(gender);
                s.setAge(age);
                s.setToan(toan);
                s.setLy(ly);
                s.setHoa(hoa);
                s.setTrung_binh(s.trung_binh());
                s.setHoc_luc(s.hoc_luc());
            }
        }

    }
    //xoa sinh vien
    public boolean xoa_id(int id){
        return students.remove(students.removeIf(students -> students.getId() == id));
    }
    //tim-kiem theo ten
    public Students tim_kiem(String name) {
        for (Students s : students) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }
    //sap  xep theo diem
    public void sap_xep_diem(){
        students.sort(Comparator.comparingDouble(Students::getTrung_binh).reversed());
    }
    //sap xep theo ten
    public void sap_xep_ten(){
        students.sort(Comparator.comparing(Students::getName));
    }
    //hien thi danh sach
    public void hien_thi(){
        for(Students s : students){
            System.out.println(s.getId()+","+s.getName()+","+s.getAge()+","+s.getGender()+","+s.getToan()+","+s.getLy()+","+s.getHoa());


        }
    }
    //ghi file
    public void ghi_file() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\tuan\\IdeaProjects\\test01\\src\\main\\java\\org\\example\\student01.txt"))) {
            for (Students s : students) {
                writer.print(",");
                writer.print(s.getName()+",");
                writer.print(s.getAge()+",");
                writer.print(s.getGender()+",");
                writer.print(s.getToan()+",");
                writer.print(s.getLy()+",");
                writer.print(s.getHoa()+",");
                writer.print(s.getTrung_binh()+",");
                writer.println(s.getHoc_luc()+",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //doc_file

    public void doc_file() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\tuan\\IdeaProjects\\test01\\src\\main\\java\\org\\example\\student.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String gender = data[3];
                double toan = Double.parseDouble(data[4]);
                double ly = Double.parseDouble(data[5]);
                double hoa = Double.parseDouble(data[6]);
                students.add(new Students(name, gender, age, toan, ly, hoa));
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            //e.printStackTrace();
        }
    }

}
