import java.util.Random;

/**
 * Created by weichen on 2018/10/25.
 * 访问者模式
 */
public class VisitorPattern {


	public class Client {

		public void main () {
			ObjectStruture objectStruture = new ObjectStruture();
			for(int i=0; i < 10; i++) {
				Element element = objectStruture.createElement();
				Visitor visitor = new Visitor();
				element.accept(visitor);
			}
		}
	}

	//抽象元素
	public abstract class Element {
		//定义业务逻辑
		public abstract void doSomething();
		//允许谁来访问
		public abstract void accept(IVisitor visitor);
	}

	//具体元素
	public class ConcreteElement_A extends Element {
		@Override
		public void doSomething() {
			System.out.println("ConcreteElement_A: 工资：100，工作: 复制代码");
		}

		@Override
		public void accept(IVisitor visitor) {
			visitor.visit(this);
		}
	}

	public class ConcreteElement_B extends Element {
		@Override
		public void doSomething() {
			System.out.println("ConcreteElement_A: 工资：200，业绩: 300万销售");
		}

		@Override
		public void accept(IVisitor visitor) {
			visitor.visit(this);
		}
	}

	//抽象访问者
	public interface IVisitor {
		//可以访问哪些对象
		void visit (ConcreteElement_A concreteElement);
		void visit (ConcreteElement_B concreteElement);
	}

	//具体访问者
	public class Visitor implements IVisitor {
		@Override
		public void visit(ConcreteElement_A concreteElement) {
			concreteElement.doSomething();
		}

		@Override
		public void visit(ConcreteElement_B concreteElement) {
			concreteElement.doSomething();
		}
	}
	//结构对象
	public class ObjectStruture {
		public Element createElement () {
			Random random = new Random();
			if (random.nextInt(100) > 50 ) {
				return new ConcreteElement_A();
			} else {
				return new ConcreteElement_B();
			}
		}
	}
}
