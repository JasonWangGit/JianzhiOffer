package Question09;

//https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/

public class Main {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		CQueue cQueue = new CQueue();
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(97);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(15);
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(1);
		cQueue.appendTail(43);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(18);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(36);
		cQueue.appendTail(69);
		cQueue.appendTail(21);
		cQueue.appendTail(91);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(22);
		cQueue.appendTail(40);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(81);
		cQueue.appendTail(65);
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(77);
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(63);
		cQueue.appendTail(96);
		cQueue.appendTail(5);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(35);
		cQueue.appendTail(90);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
	}
}
