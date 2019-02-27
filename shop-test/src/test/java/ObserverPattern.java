import java.util.List;
import java.util.Vector;

/**
 * Created by weichen on 2018/10/23.
 * 观察者模式
 */
public class ObserverPattern {


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


	//观察者
	public interface Observer {
		//接收到消息，更新方法
		void update();
	}

	//观察者，具体实现类
	public class ConcreteObserver_A implements Observer {
		@Override
		public void update() {
			System.out.println("Concrete Observer A 接收到通知");
		}
	}

	//观察者，具体实现类
	public class ConcreteObserver_B implements Observer {
		@Override
		public void update() {
			System.out.println("Concrete Observer B 接收到通知");
		}
	}

	//被观察者
	public abstract class Subject {
		//定义一个观察者数组
		List<Observer> observerVector = new Vector<Observer>();

		//增加一个观察者
		public void addObserver(Observer observer) {
			this.observerVector.add(observer);
		}

		//删除一个观察者
		public void delObserver(Observer observer) {
			this.observerVector.remove(observer);
		}

		//通知所有观察者
		public void notifyObservers () {
			for (Observer observerItem : observerVector) {
				observerItem.update();
			}
		}
	}

	//被观察者，具体实现
	public class ConcreteSubject extends Subject {
		// 具体的业务逻辑
		public void doSomething() {
			System.out.println("执行了好多好多逻辑");
			System.out.println("逻辑自行成功，赶紧通知观察者吧");
			super.notifyObservers();
		}
	}


}
