/**
 * Created by weichen on 2018/10/19.
 * 模板方法模式
 */
public class TemplateMethodPattern {

	public class Client {
		public void main(String[] args) {
			AbstractCalss class1 = new ConcreteClass1();
			AbstractCalss class2 = new ConcreteClass2();

			class1.templateMethod();
			class2.templateMethod();
		}
	}


	public abstract class AbstractCalss {
		//基本方法
		protected abstract void doSomeThing();
		//基本方法
		protected abstract void doAnyThieng();

//		模板方法
		public void templateMethod() {
			this.doSomeThing();
			this.doAnyThieng();
		}
	}

	public class ConcreteClass1 extends AbstractCalss{
		@Override
		protected void doSomeThing() {
			//处理业务逻辑
		}

		@Override
		protected void doAnyThieng() {
			//处理业务逻辑
		}
	}

	public class ConcreteClass2 extends AbstractCalss{
		@Override
		protected void doSomeThing() {
			//处理业务逻辑
		}

		@Override
		protected void doAnyThieng() {
			//处理业务逻辑
		}
	}
}
