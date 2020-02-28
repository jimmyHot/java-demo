package org.java.datastructure.linkedList;

import lombok.NoArgsConstructor;

import java.util.Stack;

@NoArgsConstructor
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "");

    private int count;

    public SingleLinkedList(HeroNode head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    /**
     * 添加链表节点（无序）
     *
     * @param heroNode
     */
    public void  addHeroNode(HeroNode heroNode) {
        //遍历链表，找到最后一个节点后添加heroNode
        //添加临时变量temp 充当指针
        HeroNode temp = head;
        //扎到插入节点的前一个节点
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(heroNode);
                count++;
                break;
            }
            temp = temp.getNext();
        }
    }


    /**
     * 添加链表节点（有序）
     *
     * @param heroNode
     */
    public void addHeroNodeInOrder(HeroNode heroNode) {

        //找到待插入节点的前一个节点
        //定义临时变量temp用于遍历链表
        HeroNode temp = this.head;
        boolean insertFlag = false;
        //思路 1 每种插入情况分开考虑，例如空链表插入和链表末端插入都是一种情况，不需分开考虑问题
      /*  while (true){
            if(temp==null){
                System.out.println("找不到可插入该节点的入口");
                break;
            }
            if(temp.getNo() < heroNode.getNo() && temp.getNext()==null){
                insertFlag=true;
                break;
            }
            if(temp.getNo()< heroNode.getNo() && temp.getNext().getNo()>heroNode.getNo()){
                insertFlag=true;
                break;
            }
            temp=temp.getNext();
        }*/
        //思路2
        while (true) {
            if (temp.getNext() == null) {
                insertFlag = true;
                break;
            }
            if (temp.getNext().getNo() > heroNode.getNo()) {
                //找到待插入点
                insertFlag = true;
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                //说明编号已存在，不可在插入
                System.out.printf("编号 %d 已存在%n", heroNode.getNo());
                break;
            }
            temp = temp.getNext();
        }
        //插入节点heroNode
        if (insertFlag) {
            //更改next
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
            count++;
        }
    }

    /**
     * 删除链表节点
     *
     * @param heroNode
     */
    public void delHeroNode(HeroNode heroNode) {

        //遍历链表，找到节点的no=heroNode.getNo()则删除
        //添加临时变量temp 充当指针
        HeroNode temp = head;
        if (temp.getNext() == null) {
            System.out.println("当前链表为空~~~");
            return;
        }
        while (true) {
            if (temp.getNext().getNo() == heroNode.getNo()) {
                temp.setNext(temp.getNext().getNext());
                count--;
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 更新链表节点信息
     *
     * @param heroNode
     */
    public void updateHeroNode(HeroNode heroNode) {
        //遍历链表，找到节点的no=heroNode.getNo()则更新
        //添加临时变量temp 充当指针
        HeroNode temp = head.getNext();
        if (temp == null) {
            System.out.println("当前链表为空~~~");
            return;
        }
        while (true) {
            if (temp.getNext() == null && temp.getNo() != heroNode.getNo()) {
                System.out.println("当前节点不存在");
                break;
            }
            if (temp.getNo() == heroNode.getNo()) {
                temp.setName(heroNode.getName());
                break;
            }
            temp = temp.getNext();
        }

    }

    /**
     * 列表展示
     */
    public HeroNode list() {

        if (head.getNext() == null) {
            System.out.println("链表内容为空");
        }
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
        return head;
    }


    /**
     * 获取单链表的总节点个数
     *
     * @return
     */
    public int getNumber() {
        return count;
    }

    //单链表的应用

    /**
     * 查找单链表中倒数第k个节点
     * 方法1：获取链表的总节点个数n，获取第 n-k+1个节点即可
     *
     * @param k
     * @return
     */
    public HeroNode getLastIndexNode(int k) {
        //check k
        if (isEmpty()) {
            throw new RuntimeException("链表为空~");
        }
        if (k < 0 || k > count) {
            throw new RuntimeException("参数无意义");
        }
        int x = count - k + 1;
        int moveCount = 0;
        HeroNode temp = this.head;
        while (temp != null) {
            if (moveCount == x) {
                return temp;
            }
            moveCount++;
            temp = temp.getNext();
        }
        throw new RuntimeException("有问题~");
    }

    /**
     * 查找单链表中倒数第k个节点
     * 方法2：将单链表循环扔进栈中，获取第 k个节点即可
     * 废弃：思路可以实现，但相比于上一个方法，该方法需遍历两次
     *
     * @param k
     * @return
     */
    @Deprecated
    public HeroNode getLastIndexNode2(int k) {
        //check k
        if (isEmpty()) {
            throw new RuntimeException("链表为空~");
        }
        if (k < 0 || k > count) {
            throw new RuntimeException("参数无意义");
        }
        HeroNode temp = this.head.getNext();
        Stack<HeroNode> heroNodeStack = new Stack<>();
        while (temp != null) {
            heroNodeStack.push(temp);
            temp = temp.getNext();
        }
        //遍历栈，找到第k个节点返回
        int moveCount = 1;
        while (!heroNodeStack.empty()) {
            HeroNode pop = heroNodeStack.pop();
            if (moveCount == k) {
                return pop;
            }
            moveCount++;
        }
        throw new RuntimeException("有问题~");
    }

    /**
     * 单链表反转
     * 方法1：利用栈先进后出的特点
     * 该方法特点：原链表结构没改变，通知新增实现
     */
    public HeroNode reverseByStack() {

        if (isEmpty()) {
            System.out.println("链表为空~~");
        }
        if (head.getNext().getNext() == null) {
            System.out.println("链表只有一个节点，无需反转");
        }
        HeroNode temp = head.getNext();
        Stack<HeroNode> heroNodeStack = new Stack<>();
        //遍历链表 放入栈
        while (temp != null) {
            heroNodeStack.push(temp);
            temp = temp.getNext();
        }
        //从栈取出放入新链表
        HeroNode reverseHead = new HeroNode(0, "");
        while (!heroNodeStack.empty()) {
            HeroNode node = heroNodeStack.pop();
            add(reverseHead, node);
        }
        //返回新链表
        return reverseHead;
    }

    /**
     * 以head为头结点的链表尾部添加节点node
     *
     * @return 新的链表节点
     */
    private void add(HeroNode head, HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                node.setNext(null);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 单链表反转
     * 方法2：遍历链表，将每一个节点添加到新的链表中最前端即可
     * 方法特点：原链表数据结构未变更，而是新生成了链表2
     */
    public void reverseOld() {
        if (isEmpty()) {
            System.out.println("链表为空~~");
        }
        HeroNode temp = head.getNext();
        //todo 注意真正的链表是node节点，而不是singleLinkedList ,只是包装
        SingleLinkedList singleLinkedListNew = new SingleLinkedList();
        while (temp != null) {
            //TODO: 注释掉的代码 和下边三行代码的区别
            //一定要注意：注意先后顺序：先将该temp节点通过临时变量cul保存，将temp指针到temp.next之后，再将临时变量cul添加至新的链表singleLinkedListNew
/*            singleLinkedListNew.addToHeadIndex(temp);
            temp=temp.getNext();*/
            HeroNode cul = temp;
            temp = temp.getNext();
            singleLinkedListNew.addToHeadIndex(cul);
        }
        singleLinkedListNew.list();
    }


    /**
     * 单链表反转：
     * 方法3：
     * 思路：
     * 1·声明一个新的head：reserveHead,用来充当新链表的头结点
     * 2·遍历原链表，将每一个节点添加至reserveHead链表的最前端
     * 3·设置head.next=reserveHead.next
     */
    public void reverse() {
        //如果链表为空或者链表只有一个节点则无需反转
        if (isEmpty() || head.getNext().getNext() == null) {
            System.out.println("链表为空或者链表只有一个节点则无需反转");
        }
        HeroNode reverseHead = new HeroNode(0, "");
        HeroNode cul = head.getNext();//cul表示当前遍历的节点，从第一个节点开始
        while (cul != null) {
            HeroNode next = cul.getNext();//next表示当前节点cul的下一个节点
            cul.setNext(reverseHead.getNext());
            reverseHead.setNext(cul);
            cul = next;
        }
        head.setNext(reverseHead.getNext());
    }


    /**
     * 单链表逆序打印
     * 方法1：先反转后打印（不推荐）原因：更改原链表的数据结构
     * 方法2：利用栈的先进后出特点
     */
    public void reversePrint() {

        if (isEmpty()) {
            System.out.println("链表为空~~");
        }
        HeroNode temp = head.getNext();
        Stack<HeroNode> heroNodeStack = new Stack<>();
        while (temp != null) {
            heroNodeStack.push(temp);
            temp = temp.getNext();
        }
        while (!heroNodeStack.empty()) {
            System.out.println(heroNodeStack.pop());
        }
    }


    /**
     * 将一个节点添加至该链表的最前端
     *
     * @param node
     */
    private void addToHeadIndex(HeroNode node) {
        node.setNext(head.getNext());
        head.setNext(node);
    }

    private boolean isEmpty() {
        return head.getNext() == null;
    }

}

