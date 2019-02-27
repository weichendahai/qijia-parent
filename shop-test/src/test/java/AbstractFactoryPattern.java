import org.junit.Test;

/**
 * Created by weichen on 2018/10/19.
 */
public class AbstractFactoryPattern {

	@Test
	public void MyHasMapTest () {
		Client client = new Client();
		client.testRun();
	}

	public abstract class Product {

		//产品类的公共方法
		public void method1() {
			//业务逻辑处理
		};

		//	抽象方法
		public abstract void method2();
	}

	public class ConcreteProduct1 extends Product {
		@Override
		public void method2() {
			//实现具体业务逻辑
		}
	}

	public class ConcreteProduct2 extends Product {
		@Override
		public void method2() {
			//实现具体业务逻辑
		}
	}

	public abstract class Creator {
		/**
		 * 创建一个产品对象，对其输入参数类型可以自行设置
		 * 通常为String，Enum，Class等，也可以设定为空
		 */
		public abstract <T extends Product> T createProduct(Class<T> c);
	}

	public class ConcreteCreator extends Creator {
		@Override
		public <T extends Product> T createProduct(Class<T> c) {
			Product product = null;
			try {
				product = (Product) Class.forName(c.getName()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return (T)product;
		}
	}

	public class Client  {
		public void testRun () {
			Creator creator = new ConcreteCreator();
			ConcreteProduct1 product = creator.createProduct(ConcreteProduct1.class);
			product.method1();
			product.method2();

			ConcreteProduct2 product2 = creator.createProduct(ConcreteProduct2.class);
			product2.method1();
			product2.method2();
		}
	}
}
