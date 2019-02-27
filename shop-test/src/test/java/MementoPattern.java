/**
 * Created by weichen on 2018/10/23.
 * 备忘录模式
 */
public class MementoPattern {

	public class Client {
		public void main () {
			//定义发起人
			Originator originator = new Originator();

			//定义备忘录管理员
			Caretaker caretaker = new Caretaker();

			//创建一个备忘录
			caretaker.setMemento(originator.createMemento());

			//恢复一个备忘录
			originator.restoreMemento(caretaker.getMemento());
		}
	}

	//发起人角色
	public class Originator {
		//内部状态
		private String state = "";

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		//创建一个备忘录
		public Memento createMemento() {
			return new Memento(this.state);
		}

		//恢复一个备忘录
		public void restoreMemento (Memento memento) {
			this.setState(memento.getState());
		}
	}

	//备忘录角色
	public class Memento {
		//发起人：内部状态
		private String state = "";

		public Memento(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	}

	//备忘录管理者
	public class Caretaker {
		//备忘录对象
		private Memento memento;

		public Memento getMemento() {
			return memento;
		}

		public void setMemento(Memento memento) {
			this.memento = memento;
		}
	}

}
