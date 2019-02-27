/**
 * Created by weichen on 2018/10/22.
 * 策略模式
 */
public class StrategyPattern {

	public class Client {

		public void main () {
			Strategy strategy_a = new ConcreteStrategy_A();
			Context context = new Context(strategy_a);
			context.doAnything();

//			Strategy strategy_b = new ConcreteStrategy_A();
//			Context context_b = new Context(strategy_b);
//			context_b.doAnything();
		}
	}

	//抽象策略角色
	public interface Strategy {
		//策略模式运算法则
		public void doSomething();
	}

	//具体策略角色
	public class ConcreteStrategy_A implements Strategy {
		@Override
		public void doSomething() {
			System.out.println("I am Strategy A; 请求老夫人帮助");
		}
	}

	//具体策略角色
	public class ConcreteStrategy_B implements Strategy {
		@Override
		public void doSomething() {
			System.out.println("I am Strategy B; 走后门");
		}
	}

	//封装角色；
	//策略模式的重点就是封装角色，他是借用代理模式的思路
	public class Context {
		//抽象策略
		private Strategy strategy = null;

		public Context(Strategy _strategy) {
			this.strategy = _strategy;
		}

		//封装后的策略方法
		public void doAnything () {
			this.strategy.doSomething();
		}
	}

}
