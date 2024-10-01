package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Controller manager = new Controller();
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Cập nhật thông tin sinh viên bởi ID");
                System.out.println("3. Xóa sinh viên bởi ID");
                System.out.println("4. Tìm kiếm sinh viên theo tên");
                System.out.println("5. Sắp xếp sinh viên theo điểm trung bình (GPA)");
                System.out.println("6. Sắp xếp sinh viên theo tên");
                System.out.println("7. Hiển thị danh sách sinh viên");
                System.out.println("8. Ghi danh sách sinh viên vào file 'student01.txt'");
                System.out.println("9. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập giới tính: ");
                        String gender = scanner.nextLine();
                        System.out.print("Nhập tuổi: ");
                        int age = scanner.nextInt();
                        System.out.print("Nhập điểm toán: ");
                        double toan = scanner.nextDouble();
                        System.out.print("Nhập điểm lý: ");
                        double ly = scanner.nextDouble();
                        System.out.print("Nhập điểm hóa: ");
                        double hoa = scanner.nextDouble();
                        manager.them(name, gender, age, toan, ly, hoa);
                        break;
                    case 2:
                        System.out.print("Nhập ID sinh viên: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhập tên: ");
                        String name01 = scanner.nextLine();
                        System.out.print("Nhập giới tính: ");
                        String gender01 = scanner.nextLine();
                        System.out.print("Nhập tuổi: ");
                        int age01 = scanner.nextInt();
                        System.out.print("Nhập điểm toán: ");
                        double toan01= scanner.nextDouble();
                        System.out.print("Nhập điểm lý: ");
                        double ly01 = scanner.nextDouble();
                        System.out.print("Nhập điểm hóa: ");
                        double hoa01 = scanner.nextDouble();
                        manager.update_id(id, name01, gender01, age01, toan01, ly01, hoa01);
                        break;
                    case 3:
                        System.out.print("Nhập ID sinh viên: ");
                        id = scanner.nextInt();
                        if (manager.xoa_id(id)) {
                            System.out.println("Xóa thành công!");
                        } else {
                            System.out.println("Sinh viên không tồn tại!");
                        }
                        break;
                    case 4:
                        System.out.print("Nhập tên sinh viên: ");
                        String searchName = scanner.nextLine();
                       System.out.println(manager.tim_kiem(searchName).getId()
                               +","+manager.tim_kiem(searchName).getName()
                               +","+manager.tim_kiem(searchName).getAge()
                               +","+manager.tim_kiem(searchName).getGender()
                               +","+manager.tim_kiem(searchName).getToan()
                               +","+manager.tim_kiem(searchName).getLy()
                               +","+manager.tim_kiem(searchName).getHoa()
                       );
                        break;
                    case 5:

                        manager.sap_xep_diem();
                        manager.hien_thi();
                        break;
                    case 6:
                        manager.sap_xep_ten();
                        manager.hien_thi();
                        break;
                    case 7:
                        manager.hien_thi();
                        break;
                    case 8:
                        manager.ghi_file();
                        System.out.println("Ghi file thành công!");
                        break;
                    case 9:
                        running = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
            scanner.close();
        }
}