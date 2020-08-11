package Data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        boolean check = true;
        while (check) {
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----:");
            System.out.println("Chọn chức năng theo số(để tiếp tục):");
            System.out.println("1.Xem danh sách.");
            System.out.println("2.Thêm mới.");
            System.out.println("3.Cập nhật.");
            System.out.println("4.Xóa.");
            System.out.println("5.Tìm kiếm.");
            System.out.println("6.Đọc từ file.");
            System.out.println("7.Ghi từ file.");
            System.out.println("8.Thoát.");
            System.out.println("Chọn chức năng: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        phoneBookManager.show();
                        System.out.println( "Hiển thị xong");
                        break;
                    case 2:
                        phoneBookManager.add();
                        System.out.println("Thêm xong");
                        break;
                    case 3:
                        System.out.println("Nhập thứ tự số điện thoại muốn cập nhật: ");
                        int id=scanner.nextInt();
                        phoneBookManager.edit(id);
                        break;
                    case 4:
                        System.out.println("Nhập thứ tự số điện thoại muốn xóa: ");
                        int id1=scanner.nextInt();
                        phoneBookManager.delete(id1);
                        break;
                    case 5:
                        System.out.println("Nhập từ khóa tìm kiếm :");
                        String key=scanner.nextLine();
                        phoneBookManager.searchProduct(key);
                        break;
                    case 6:
                        System.out.println("6");
                        break;
                    case 7:
                        System.out.println("7");
                        break;
                    case 8:
                        check=false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này,nhập lại lựa chọn");

                }
            } catch (InputMismatchException ex) {
                System.err.println("Yêu cầu nhập lại số chính xác");
                scanner.nextLine();
            }
        }
    }
}
