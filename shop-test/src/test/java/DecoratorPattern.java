/**
 * Created by weichen on 2018/10/22.
 * 装饰器模式
 */
public class DecoratorPattern {

	public class Client {
		public void main() {
			Component component = new ConcreteComponent();

			component = new ConcreteDecorator_A(component);
			component = new ConcreteDecorator_B(component);

			component.operate();
			;
		}
	}


	public abstract class Component {
		// 抽象方法
		public abstract void operate();
	}

	public class ConcreteComponent extends Component {
		//具体实现
		@Override
		public void operate() {
			System.out.println("do something");
		}
	}

	public abstract class Decorator extends Component {

		private Component component = null;

		//通过构造函数传递   《被修饰者》
		public Decorator(Component _component) {
			this.component = _component;
		}

		// 委托给被修饰者执行
		@Override
		public void operate() {
			this.component.operate();
		}
	}

	public class ConcreteDecorator_A extends Decorator {
		//定义 被修饰者
		public ConcreteDecorator_A(Component _component) {
			super(_component);
		}

		//定义自己的修饰方法
		private void method() {
			System.out.println("method A 修饰; 修饰最高分");
		}

		// 委托给被修饰者执行
		@Override
		public void operate() {
			this.method();
			super.operate();
		}
	}

	public class ConcreteDecorator_B extends Decorator {
		//定义 被修饰者
		public ConcreteDecorator_B(Component _component) {
			super(_component);
		}

		//定义自己的修饰方法
		private void method() {
			System.out.println("method B 修饰； 修饰班级排名");
		}

		// 委托给被修饰者执行
		@Override
		public void operate() {
			this.method();
			super.operate();
		}
	}

}
