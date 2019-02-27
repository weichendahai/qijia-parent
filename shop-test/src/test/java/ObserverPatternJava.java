import java.util.Observable;
import java.util.Observer;

/**
 * Created by weichen on 2018/10/23.
 * 观察者模式
 */
public class ObserverPatternJava {


	public class Client {
		public void main () {
			//创建一个被观察者
			ConcreteSubject concreteSubject = new ConcreteSubject();

			//定义两个观察者
			Observer concreteObserver_a = new ConcreteObserver_A();
			Observer concreteObserver_b = new ConcreteObserver_B();

			//观察者，开始观察被观察者
			concreteSubject.addObserver(concreteObserver_a);
			concreteSubject.addObserver(concreteObserver_b);

			concreteSubject.doSomething();
		}
	}

	//观察者，具体实现类
	public class ConcreteObserver_A implements Observer {
		@Override
		public void update(Observable o, Object arg) {
			System.out.println("Concrete Observer A 接收到通知");
		}
	}

	//观察者，具体实现类
	public class ConcreteObserver_B implements Observer {
		@Override
		public void update(Observable o, Object arg) {
			System.out.println("Concrete Observer A 接收到通知");
		}
	}

	//被观察者，具体实现
	public class ConcreteSubject extends Observable {
		// 具体的业务逻辑
		public void doSomething() {
			System.out.println("执行了好多好多逻辑");
			System.out.println("逻辑自行成功，赶紧通知观察者吧");
			super.setChanged();
			super.notifyObservers("执行了好多好多逻辑，赶紧看看");
		}
	}


}
