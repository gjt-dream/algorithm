package hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        //菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        flag:while (true){
            System.out.println("add: 添加员工!");
            System.out.println("list: 显示员工！!");
            System.out.println("find: 查找员工！");
            System.out.println("delete: 删除员工！");
            System.out.println("exit: 退出系统!");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入id：");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名：");
                    String name = scanner.next();
                    hashTab.add(new Employee(id,name));
                    break;

                case "list":
                    hashTab.list();
                    break;

                case "find":
                    System.out.println("请输入要查找的员工id：");
                    id = scanner.nextInt();
                    hashTab.find(id);
                    break;

                case "delete":
                    System.out.println("请输入要删除的员工id：");
                    id = scanner.nextInt();
                    System.out.println("请输入要删除的员工姓名：");
                    name = scanner.next();
                    hashTab.delete(id,name);
                    break;
                case "exit":
//                    System.exit(0);
                    break flag;
                default:
                    break;
            }
        }
    }
}
