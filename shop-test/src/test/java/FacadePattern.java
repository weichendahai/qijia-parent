/**
 * Created by weichen on 2018/10/23.
 * 门面模式
 */
public class FacadePattern {

	public class Client {
		public void main () {
			Facade facade = new Facade();
			facade.doSomething_A();
			facade.doSomething_B();
			facade.doSomething_C();
		}
	}

	public class Class_A {
		public void doSomething() {
			System.out.println("执行逻辑 A");
		}
	}

	public class Class_B {
		public void doSomething() {
			System.out.println("执行逻辑 B");
		}
	}

	public class Class_C {
		public void doSomething() {
			System.out.println("执行逻辑 C");
		}
	}

	public class Facade {
		//定义被委托的对象
		private Class_A class_a = new Class_A();
		private Class_B class_b = new Class_B();
		private Class_C class_c = new Class_C();

		public void doSomething_A () {
			this.class_a.doSomething();
		}
		public void doSomething_B () {
			this.class_b.doSomething();
		}
		public void doSomething_C () {
			this.class_c.doSomething();
		}

		// XXXXX这种写法是错误的XXXXXX
		// 门面不参与子系统内的业务逻辑
		public void doSomething_A_C () {
			this.class_a.doSomething();
			this.class_c.doSomething();
		}
	}
}
