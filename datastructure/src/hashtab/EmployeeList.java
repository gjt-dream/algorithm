package hashtab;

import java.net.Socket;

public class EmployeeList {
    //头指针，执行第一个Emp，因此我们这个链表的head是指向第一个Emo
    private Employee head;

    /**
     * 添加元素
     * @param emp
     */
    public void add(Employee emp){
        if (head == null){
            head = emp;
            return;
        }
        //辅助节点
        Employee temp = head;
        while (true){
            if (temp.getNext() == null){
                temp.setNext(emp);
                break;
            }
            temp = temp.getNext();
        }
//        temp.setNext(emp);
    }

    public void list(int on){
        if (head == null){
            System.out.println("第"+ on + "条链表为空！");
            return;
        }
        Employee temp = head;
        System.out.print("第"+ on + "条链表" + "当前元素为：");
        while (true){
            System.out.print(temp.toString());
            if (temp.getNext() == null){
                break;
            }
            System.out.print("=>");
            temp = temp.getNext();
        }
        System.out.println();
    }

    /**
     * 通过id查找员工
     * @param id
     * @return
     */
    public Employee findEmployeeById(int id){
        if (head == null){
            System.out.println("链表为空!");
            return null;
        }
        Employee temp = head;

        while (true){

            if (temp.getId() == id){
                return temp;
            }

            if (temp.getNext() == null){
                return null;
            }

            temp = temp.getNext();
        }
    }

    /**
     * 通过id删除员工
     * @param id
     */
    public void del(int id,String name){
        if (head == null){
            System.out.println("链表为空!");
            return;
        }
        Employee employeeById = findEmployeeById(id);
        if (employeeById == null){
            System.out.println("没有找到id为" + id + "员工!");
            return;
        }
        Employee temp = head;
        while (true){
            if (temp.getName().equals(name)){
                head = temp.getNext();
                System.out.println("删除成功！员工为：" + temp);
                break;
            }else if (temp.getNext().getName().equals(name)){
                temp.setNext(temp.getNext().getNext());
                System.out.println("删除成功！员工为：" + temp);
                break;
            }
            if (temp.getNext() == null){
                break;
            }
            temp =temp.getNext();
        }

//        if (temp.getName().equals(name)){
//            head = temp.getNext();
//            System.out.println("删除成功！员工为：" + temp);
//            return;
//        }else if (temp.getNext() == null){
//            if (employeeById.getName().equals(name)){
//                employeeById =findEmployeeById(id - 1);
//                temp = employeeById;
//                temp.setNext(null);
//                System.out.println("删除成功！员工为：" + employeeById.getNext());
//                return;
//            }
//            System.out.println("失败！");
//            return;
//        }else {
//            if (employeeById.getName().equals(name)){
//                employeeById =findEmployeeById(id - 1);
//                temp = employeeById;
//                temp.setNext(employeeById.getNext().getNext());
//                System.out.println("删除成功！员工为：" + employeeById.getNext());
//                return;
//            }
//            System.out.println("失败！");
//            return;
//        }
    }
}
