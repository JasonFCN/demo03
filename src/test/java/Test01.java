/**
 * @author Chenwujie
 * 2022/6/26 11:02
 */

public class Test01 {
    private int i;
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.next());
    }

    public int next(){
        return ++i;
    }

    public int next1(){
        return i++;
    }
}
