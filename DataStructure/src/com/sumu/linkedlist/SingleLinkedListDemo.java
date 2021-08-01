package com.sumu.linkedlist;

import java.util.HashMap;
import java.util.Stack;

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

//        System.out.println("链表的有效节点个数为:" + singleLinkedList.getLength(singleLinkedList.getHead()));
        singleLinkedList.list();
        System.out.println("==============");
//        StudentNode res = singleLinkedList.findKIndex(singleLinkedList.getHead(), 3);
//        singleLinkedList.revers(singleLinkedList.getHead());
//        singleLinkedList.list();
        singleLinkedList.reversPrint(singleLinkedList.getHead());


        /*singleLinkedList.addBySort(stu1);
        singleLinkedList.addBySort(stu4);
        singleLinkedList.addBySort(stu3);
        singleLinkedList.addBySort(stu2);*/

        /*System.out.println("修改前：");
        singleLinkedList.list();
        singleLinkedList.update(new StudentNode(4, "LiSi", "男"));
        System.out.println("修改后：");
        singleLinkedList.list();*/

        /*System.out.println("删除前：");
        singleLinkedList.list();
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        System.out.println("删除后：");
        singleLinkedList.list();*/
    }
}

class SingleLinkedList {
    // 创建头节点
    private StudentNode head = new StudentNode(0, "", "");

    public StudentNode getHead() {
        return head;
    }

    // 从尾到头打印单链表
    public void reversPrint(StudentNode studentNode) {
        if (studentNode.next == null) {
            return;
        }

        StudentNode temp = studentNode.next;
        Stack<StudentNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    // 单链表的反转
    public void revers(StudentNode studentNode) {
        if (studentNode.next == null || studentNode.next.next == null) {
            return;
        }
        StudentNode temp = studentNode.next;
        StudentNode next = null;
        StudentNode reversHead = new StudentNode(0, "", "");


        while (temp != null) {
            next = temp.next;
            temp.next = reversHead.next;
            reversHead.next = temp;
            temp = next;
        }
        head.next = reversHead.next;
    }

    // 查找链表中倒数第k个节点
    public StudentNode findKIndex(StudentNode studentNode, int index) {
        if (studentNode.next == null) {
            return null;
        }

        StudentNode temp = head.next;
        StudentNode temp1 = head.next;
        int total = 0;
        while (temp != null) {
            total ++;
            temp = temp.next;
        }

        if (total < index) {
            return null;
        }

        for (int i = 0; i< (total-index); i++) {
            temp1 = temp1.next;
        }

        return temp1;
    }

    // 获取链表有效节点个数
    public int getLength(StudentNode studentNode) {
        if (studentNode.next == null) {
            return 0;
        }

        StudentNode temp = head.next;
        int len = 0;
        while (temp != null) {
            len ++;
            temp = temp.next;
        }

        return len;
    }

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

    public void addBySort(StudentNode studentNode) {
        StudentNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > studentNode.no) {
                break;
            } else if (temp.next.no == studentNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的学生编号 %d 已经存在，不能添加！\n", studentNode.no);
        } else {
            studentNode.next = temp.next;
            temp.next = studentNode;
        }
    }

    public void update(StudentNode studentNode) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        StudentNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == studentNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = studentNode.name;
            temp.sex = studentNode.sex;
        } else {
            System.out.println("未找到编号为：" + studentNode.no + " 的学生，不能修改！");
        }
    }

    public void delete(int no) {
        StudentNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("未找到编号为：" + no + " 的学生，不能删除！");
        }
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
