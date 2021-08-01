package com.sumu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        StudentNode2 stu1 = new StudentNode2(1, "SuMu", "男");
        StudentNode2 stu2 = new StudentNode2(2, "LiLi", "女");
        StudentNode2 stu3 = new StudentNode2(3, "ZhangSan", "男");
        StudentNode2 stu4 = new StudentNode2(4, "Lisa", "女");
        doubleLinkedList.add(stu1);
        doubleLinkedList.add(stu2);
        doubleLinkedList.add(stu3);
        doubleLinkedList.add(stu4);
        // 打印链表
        System.out.println("修改前：");
        doubleLinkedList.list();
        // 修改节点信息
        /*doubleLinkedList.update(new StudentNode2(2, "XiaoMing", "男"));
        System.out.println("修改后：");
        doubleLinkedList.list();*/
        // 删除节点
        doubleLinkedList.delete(4);
        System.out.println("删除后：");
        doubleLinkedList.list();


    }
}

class DoubleLinkedList {
    private StudentNode2 head = new StudentNode2(0, "", "");

    public StudentNode2 getHead() {
        return head;
    }

    // 删除节点
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，不能删除！");
        }
        StudentNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("未找到编号为：" + no + "的学生！");
        }
    }

    // 修改节点
    public void update(StudentNode2 studentNode2) {
        if (head.next == null) {
            System.out.println("链表为空，不能删除！");
            return;
        }

        StudentNode2 temp = head.next;

        while (temp != null) {
            if (temp.no == studentNode2.no) {
                break;
            }
            temp = temp.next;
        }

        temp.name = studentNode2.name;
        temp.sex = studentNode2.sex;
    }

    // 添加节点
    public void add(StudentNode2 studentNode2) {
        StudentNode2 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        temp.next = studentNode2;
        studentNode2.pre = temp;
    }

    // 打印链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        StudentNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class StudentNode2 {
    public int no;
    public String name;
    public String sex;
    public StudentNode2 next;
    public StudentNode2 pre;

    public StudentNode2(int no, String name, String sex) {
        this.no = no;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StudentNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}