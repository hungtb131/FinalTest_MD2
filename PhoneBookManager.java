package Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookManager {
    Scanner scanner=new Scanner(System.in);
    private static final String PATH ="src/Data/contact.csv";
    private List<PhoneList> phoneList1;
    private ReadAndWriteFile<PhoneList> readAndWriteFile;
    
    public PhoneBookManager() {
        readAndWriteFile = new ReadAndWriteFile();
        phoneList1 = readAndWriteFile.readFile(PATH);
    }
    
    public void add(){
        int id;
        int count=0;
        for(int i = 0; i< phoneList1.size(); i++) {
            if (count < phoneList1.get(i).getId()) {
                count = phoneList1.get(i).getId();
            }
        }
        id=count+1;
        System.out.println("Nhập số điện thoại mới: ");
        int number= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập nhóm: ");
        String group= scanner.nextLine();
        System.out.println("Nhập họ và tên: ");
        String name= scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender= scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address= scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String birthday= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Nhập email: ");
        String email= scanner.nextLine();
    
        PhoneList phoneList = new PhoneList(id,number,group,name,gender,address,birthday,email);
        phoneList1.add(phoneList);
        readAndWriteFile.writeFile(PATH, phoneList1);
    }
    
    public void show(){
    for(PhoneList phoneList : phoneList1){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Thứ tự: "+ phoneList.getId());
        System.out.println("Số điện thoại: "+ phoneList.getPhoneNum());
        System.out.println("Nhóm: " + phoneList.getGroup());
        System.out.println("Họ và tên: "+ phoneList.getName());
        System.out.println("Giới tính: " + phoneList.getGender());
        System.out.println("Địa chỉ: "+ phoneList.getAddress());
        System.out.println("---------------------------------------------------------------------");
    }
    }
    
    public void edit(int id) {
        boolean isExisted = false;
        for (int i = 0; i < phoneList1.size(); i++) {
            if (id == (phoneList1.get(i).getId())) {
                isExisted = true;
                System.out.println("Menu");
                System.out.println("1. Cập nhật số điện thoại");
                System.out.println("2. Cập nhật nhóm");
                System.out.println("3. Cập nhật họ tên");
                System.out.println("4. Cập nhật giới tính");
                System.out.println("5. Cập nhật địa chỉ");
                System.out.println("6. Cập nhật ngày sinh");
                System.out.println("7. Cập nhật email");
                System.out.println("0. Kết thúc cập nhật");
                int choice1;
                boolean run = true;
                while (run) {
                    choice1 = scanner.nextInt();
                    switch (choice1) {
                        case 1:
                            System.out.println("Sửa số điện thoại " + phoneList1.get(i).getPhoneNum() + " thành : ");
                            int number = scanner.nextInt();
                            scanner.nextLine();
                            phoneList1.get(i).setPhoneNum(number);
                            System.out.println("Sửa số điện thoại thành công");
                            break;
                        case 2:
                            System.out.println("Sửa nhóm " + phoneList1.get(i).getGroup() + " thành : ");
                            String group = scanner.nextLine();
                            phoneList1.get(i).setGroup(group);
                            System.out.println("Sửa nhóm thành công");
                            break;
                        case 3:
                            System.out.println("Sửa họ và tên " + phoneList1.get(i).getName() + " thành : ");
                            String name = scanner.nextLine();
                            phoneList1.get(i).setName(name);
                            System.out.println("Sửa họ và tên thành công");
                            break;
                        case 4:
                            System.out.println("Sửa giới tính " + phoneList1.get(i).getGender() + " thành : ");
                            String gender = scanner.nextLine();
                            phoneList1.get(i).setGender(gender);
                            System.out.println("Sửa giới tính thành công");
                            break;
                        case 5:
                            System.out.println("Sửa địa chỉ " + phoneList1.get(i).getAddress() + " thành : ");
                            String address = scanner.nextLine();
                            phoneList1.get(i).setAddress(address);
                            System.out.println("Sửa địa chỉ thành công");
                            break;
                        case 6:
                            System.out.println("Sửa ngày sinh " + phoneList1.get(i).getBirthday() + " thành : ");
                            String birthday = scanner.nextLine();
                            phoneList1.get(i).setBirthday(birthday);
                            System.out.println("Sửa ngày sinh thành công");
                            break;
                        case 7:
                            System.out.println("Sửa email " + phoneList1.get(i).getEmail() + " thành : ");
                            String mail = scanner.nextLine();
                            phoneList1.get(i).setEmail(mail);
                            System.out.println("Sửa email thành công");
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
                }
            }
        }
        if (!isExisted) {
            System.out.printf("Id = %d không tồn tại.\n", id);
        } else {
            readAndWriteFile.writeFile(PATH, phoneList1);
        }
    }
    
    public void delete(int id) {
        PhoneList list = null;
        
        for (int i = 0; i < phoneList1.size(); i++) {
            if (phoneList1.get(i).getId() == id) {
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
            System.out.printf("Id = %d không tồn tại.\n", id);
        }
    }
    
    public void  searchProduct(String key){
        List<PhoneList> listsSearch = new ArrayList<>();
        Iterator<PhoneList> iterator = phoneList1.iterator();
        while (iterator.hasNext()){
            PhoneList phoneList = iterator.next();
            if (checkKey(key, phoneList.getName())){
                listsSearch.add(phoneList);
            }
        }
        showSearch(listsSearch);
    }
    public boolean checkKey(String key , String input){
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }
    
    public void showSearch(List<PhoneList> listsSearch){
        for(PhoneList phoneList :listsSearch){
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Thứ tự: "+ phoneList.getId());
            System.out.println("Số điện thoại: "+ phoneList.getPhoneNum());
            System.out.println("Nhóm: " + phoneList.getGroup());
            System.out.println("Họ và tên: "+ phoneList.getName());
            System.out.println("Giới tính: " + phoneList.getGender());
            System.out.println("Địa chỉ: "+ phoneList.getAddress());
            System.out.println("Ngày sinh: "+ phoneList.getBirthday());
            System.out.println("Email: "+ phoneList.getEmail());
            System.out.println("---------------------------------------------------------------------");
        }
    }
}
