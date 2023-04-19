package hashtab;

public class HashTab {
    //hashTab的数组
    private EmployeeList[] hashTabList;
    //数组大小
    private int size;

    public HashTab(int size) {
        this.hashTabList = new EmployeeList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            hashTabList[i] = new EmployeeList();
        }
    }

    //使用散列函数获取数组下标
    public int hashFun(int id){
        return id % size;
    }

    public void add(Employee emp){
        //获取数组下标
        int hashFun = hashFun(emp.getId());
        hashTabList[hashFun].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            hashTabList[i].list(i);
        }
    }

    public void find(int id){
        int findId = hashFun(id);
        Employee employeeById = hashTabList[findId].findEmployeeById(id);

        if (employeeById != null){
            System.out.println("在第" + findId + "链表中找到员工 id = " + employeeById);
        }else {
            System.out.println("没有找到员工!");
        }
    }
    public void delete(int id,String name){
        int delId = hashFun(id);
        hashTabList[delId].del(id,name);
    }
}
