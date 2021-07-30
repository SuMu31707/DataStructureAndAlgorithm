package com.sumu.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        StudentNode stu1 = new StudentNode(1, "SuMu", "男");
        StudentNode stu2 = new StudentNode(2, "LiLi", "女");
        StudentNode stu3 = new StudentNode(3, "ZhangSan", "男");
        StudentNode stu4 = new StudentNode(4, "Lisa", "女");
        singleLinkedList.add(stu1);
        singleLinkedList.add(stu2);
        singleLinkedList.add(stu3);
        singleLinkedList.add(stu4);

        singleLinkedList.list();
    }
}

class SingleLinkedList {
    // 创建头节点
    private StudentNode head = new StudentNode(0, "", "");
    // 创建添加的方法
    public void add(StudentNode studentNode) {
        StudentNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = studentNode;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        StudentNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

/**
 * 创建StudentNode，每个StudentNode对象就是一个节点
 */
class StudentNode {
    public int no;
    public String name;
    public String sex;
    public StudentNode next;

    public StudentNode(int no, String name, String sex) {
        this.no = no;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
