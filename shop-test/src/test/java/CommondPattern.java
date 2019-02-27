/**
 * Created by weichen on 2018/10/19.
 * 命令模式
 */
public class CommondPattern {


	public class client {
		public void main () {
			//1. 首先声明调用者Invoker
			Invoker invoker = new Invoker();
			//2. 定义接收者
			Receiver receiver1 = new ConcreteReceiver1();
			Receiver receiver2 = new ConcreteReceiver2();

			//3. 定义一个发送给接收者的命令
			Command command_a = new ConcreteCommand_A(receiver1);
			Command command_b = new ConcreteCommand_B(receiver2);

			//4. 命令交个调用者去执行
			invoker.setCommand(command_a);
			invoker.action();

			invoker.setCommand(command_b);
			invoker.action();
		}
	}

	/**
	 * 通用Receiver类
	 * 接收者可以有多个，所以定义一个所有特性的抽象集合
	 */
	public abstract class Receiver {
		//抽象接受者，定义每个接收者都必须完成的任务
		public abstract void doSomething();
	}

	/**
	 *  具体的接收者1
	 */
	public class ConcreteReceiver1 extends Receiver {
		//每个接收者都必须处理一定的业务逻辑
		@Override
		public void doSomething() {
			System.out.println("处理业务1");
		}
	}

	/**
	 *  具体的接收者2
	 */
	public class ConcreteReceiver2 extends Receiver {
		//每个接收者都必须处理一定的业务逻辑
		@Override
		public void doSomething() {
			System.out.println("处理业务2");
		}
	}

	/**
	 * 命令角色：命令模式的核心
	 */
	public abstract class Command {
		// 每个命令都必须有一个执行命令的方法
		public abstract void exceute();
	}

	/**
	 * 具体命令类A
	 * 每个命令类中，通过构造函数定义该命令是针对哪一个接收者发出的，定义一个命令接收的主体
	 */
	public class ConcreteCommand_A extends Command {

		//此命令，使用哪一个Receiver类进行命令处理
		private Receiver receiver;

		public ConcreteCommand_A(Receiver receiver) {
			this.receiver = receiver;
		}

		//必须实现的一个命令类
		@Override
		public void exceute() {
			//业务逻辑处理
			this.receiver.doSomething();
		}
	}

	/**
	 * 具体命令类B
	 */
	public class ConcreteCommand_B extends Command {

		//此命令，使用哪一个Receiver类进行命令处理
		private Receiver receiver;

		public ConcreteCommand_B(Receiver receiver) {
			this.receiver = receiver;
		}

		//必须实现的一个命令类
		@Override
		public void exceute() {
			//业务逻辑处理
			this.receiver.doSomething();
		}
	}

	/**
	 * 调用者Invoker,仅仅实现命令的传递
	 */
	public class Invoker {
		private Command command;

		//接收命令
		public void setCommand(Command commandParmeter) {
			this.command = commandParmeter;
		}

		//执行命令
		public void action () {
			this.command.exceute();
		}
	}
}
