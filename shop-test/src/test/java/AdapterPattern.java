/**
 * Created by weichen on 2018/10/22.
 * 适配器 模式
 */
public class AdapterPattern {

	public class Client {
		public void main() {
			//原有业务逻辑
			Target target = new ConcreteAdapter();
			target.request();

			//现在增加了适配器角色后的业务逻辑
			Target target2 = new Adapter();
			target2.request();
		}
	}

	//目标角色；
	//该角色定义把其他类转换为何种接口
	public interface Target {
		void request();
	}

	//目标具体实现类
	public class ConcreteAdapter implements Target {
		@Override
		public void request() {
			System.out.println("if you need any help, please call me");
		}
	}

	//源角色；
	// 你想把谁转换成目标角色；这个"谁"就是源角色
	// 此对象，是后来补丁补充写入的，然后适配入 整个系统体系内，
	// 此对象，本身不继承任何接口和类，完全独立
	public class Adaptee {
		public void doSomething() {
			System.out.println("i am kind of busy, leave me alonge, please");
		}
	}

	//适配器角色；核心角色
	//核心职责: 把源角色转换为目标角色，怎么转换，通过继承或是关联的方式
	public class Adapter extends Adaptee implements Target {
		@Override
		public void request() {
			super.doSomething();
		}
	}
}
