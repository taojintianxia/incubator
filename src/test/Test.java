package test;

public class Test {
	public static void main(String... args) {
		Test test = new Test();
		TestBean bean = new TestBean();
		bean.setAge(25);
		bean.setName("AAA");
		test.testReflection(bean);
	}

	public void testReflection(TestBean bean) {
		System.out.println("bean name is : " + bean.getName());
	}
}
