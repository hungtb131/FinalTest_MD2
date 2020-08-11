package Data;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookManager {
    Scanner scanner = new Scanner(System.in);
    private static final String PATH = "src/PhoneList.txt";
    private List<PhoneList> phoneList1;
    private ReadAndWriteFile<PhoneList> readAndWriteFile;

    public PhoneBookManager() {
        readAndWriteFile = new ReadAndWriteFile();
        phoneList1 = readAndWriteFile.readFile(PATH);
    }

    public void add() {
        System.out.println("Nhập số điện thoại mới: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Nhập họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        int birthday = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        PhoneList phoneList = new PhoneList(number, group, name, gender, address, birthday, email);
        phoneList1.add(phoneList);
        readAndWriteFile.writeFile(PATH, phoneList1);
    }

    public void show() {
        for (PhoneList phoneList : phoneList1) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Số điện thoại: " + phoneList.getPhoneNum());
            System.out.println("Nhóm: " + phoneList.getGroup());
            System.out.println("Họ và tên: " + phoneList.getName());
            System.out.println("Giới tính: " + phoneList.getGender());
            System.out.println("Địa chỉ: " + phoneList.getAddress());
            System.out.println("---------------------------------------------------------------------");
        }
    }

    public void edit(int number) {
        boolean isExisted = false;
        for (int i = 0; i < phoneList1.size(); i++) {
            if (number == (phoneList1.get(i).getPhoneNum())) {
                isExisted = true;
                boolean run = true;
                while (run) {
                    System.out.println("Menu");
                    System.out.println("1. Cập nhật nhóm");
                    System.out.println("2. Cập nhật họ tên");
                    System.out.println("3. Cập nhật giới tính");
                    System.out.println("4. Cập nhật địa chỉ");
                    System.out.println("5. Cập nhật ngày sinh");
                    System.out.println("6. Cập nhật email");
                    System.out.println("0. Thoát");
                    try {
                        int choice1 = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice1) {
                            case 1:
                                System.out.println("Sửa nhóm " + phoneList1.get(i).getGroup() + " thành : ");
                                String group = scanner.nextLine();
                                phoneList1.get(i).setGroup(group);
                                System.out.println("Đã sửa nhóm của số điện thoại 0" + phoneList1.get(i).getPhoneNum() + " thành: " + phoneList1.get(i).getGroup());
                                break;
                            case 2:
                                System.out.println("Sửa họ và tên " + phoneList1.get(i).getName() + " thành : ");
                                String name = scanner.nextLine();
                                phoneList1.get(i).setName(name);
                                System.out.println("Đã sửa họ tên của số điện thoại 0" + phoneList1.get(i).getPhoneNum() + " thành: " + phoneList1.get(i).getName());
                                break;
                            case 3:
                                System.out.println("Sửa giới tính " + phoneList1.get(i).getGender() + " thành : ");
                                String gender = scanner.nextLine();
                                phoneList1.get(i).setGender(gender);
                                System.out.println("Đã sửa giới tính của số điện thoại 0" + phoneList1.get(i).getPhoneNum() + " thành: " + phoneList1.get(i).getGender());
                                break;
                            case 4:
                                System.out.println("Sửa địa chỉ " + phoneList1.get(i).getAddress() + " thành : ");
                                String address = scanner.nextLine();
                                phoneList1.get(i).setAddress(address);
                                System.out.println("Đã sửa địa chỉ của số điện thoại 0" + phoneList1.get(i).getPhoneNum() + " thành: " + phoneList1.get(i).getAddress());
                                break;
                            case 5:
                                System.out.println("Sửa ngày sinh " + phoneList1.get(i).getBirthday() + " thành : ");
                                int birthday = scanner.nextInt();
                                phoneList1.get(i).setBirthday(birthday);
                                System.out.println("Đã sửa họ tên của số điện thoại 0" + phoneList1.get(i).getPhoneNum() + " thành: " + phoneList1.get(i).getBirthday());
                                break;
                            case 6:
                                System.out.println("Sửa email " + phoneList1.get(i).getEmail() + " thành : ");
                                String mail = scanner.nextLine();
                                phoneList1.get(i).setEmail(mail);
                                System.out.println("Đã sửa họ tên của số điện thoại 0" + phoneList1.get(i).getPhoneNum() + " thành: " + phoneList1.get(i).getEmail());
                                break;
                            case 0:
                                System.out.println("Đã sủa xong.");
                                System.out.println();
                                scanner.nextLine();
                                run = false;
                                break;
                            default:
                                System.out.println("No choice!");
                        }
                    } catch (InputMismatchException ex) {
                        System.err.println("Yêu cầu nhập số chính xác");
                        scanner.nextLine();
                    }
                }
            }
        }
        if (!isExisted) {
            System.out.printf("Số điện thoại = %d không tồn tại.\n", number);
        } else {
            readAndWriteFile.writeFile(PATH, phoneList1);
        }
    }

    public void delete(int number) {
        PhoneList list = null;
        for (int i = 0; i < phoneList1.size(); i++) {
            if (phoneList1.get(i).getPhoneNum() == number) {
                list = phoneList1.get(i);
                break;
            }
        }
        if (list != null) {
            System.out.println("Đã xóa số điện thoại của: " + list.getName());
            System.out.println();
            phoneList1.remove(list);
            readAndWriteFile.writeFile(PATH, phoneList1);
        } else {
            System.out.printf("Số điện thoại = %d không tồn tại.\n", number);
        }
    }

    public void searchProduct(String key) {
        List<PhoneList> listsSearch = new ArrayList<>();
        Iterator<PhoneList> iterator = phoneList1.iterator();
        while (iterator.hasNext()) {
            PhoneList phoneList = iterator.next();
            if (checkKey(key, phoneList.getName())) {
                listsSearch.add(phoneList);
            }
            if (checkKey(key, phoneList.toString())) {
                listsSearch.add(phoneList);
            }
        }
        showSearch(listsSearch);
    }

    public boolean checkKey(String key, String input) {
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }

    public void showSearch(List<PhoneList> listsSearch) {
        for (PhoneList phoneList : listsSearch) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Số điện thoại: " + phoneList.getPhoneNum());
            System.out.println("Nhóm: " + phoneList.getGroup());
            System.out.println("Họ và tên: " + phoneList.getName());
            System.out.println("Giới tính: " + phoneList.getGender());
            System.out.println("Địa chỉ: " + phoneList.getAddress());
            System.out.println("Ngày sinh: " + phoneList.getBirthday());
            System.out.println("Email: " + phoneList.getEmail());
            System.out.println("---------------------------------------------------------------------");
        }
    }
}