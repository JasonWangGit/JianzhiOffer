package Question09;

//https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/

public class Main_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		CQueue_v2 CQueue_v2 = new CQueue_v2();
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(97);
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(15);
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(1);
		CQueue_v2.appendTail(43);
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(18);
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(36);
		CQueue_v2.appendTail(69);
		CQueue_v2.appendTail(21);
		CQueue_v2.appendTail(91);
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(22);
		CQueue_v2.appendTail(40);
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(81);
		CQueue_v2.appendTail(65);
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(77);
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(63);
		CQueue_v2.appendTail(96);
		CQueue_v2.appendTail(5);
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
		CQueue_v2.appendTail(35);
		CQueue_v2.appendTail(90);
		System.out.println(CQueue_v2.deleteHead());
		System.out.println(CQueue_v2.deleteHead());
	}
}
