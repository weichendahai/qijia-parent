/**
 * Created by weichen on 2018/10/19.
 * 创建者模式
 */
public class CreaterPattern {


	public class client {
		void mian () {
			Director director = new Director();
			Product product_a = director.getProduct_A();
		}
	}

//	产品类
	public class Product {
		public void doSomethind() {
			//具体的业务逻辑
		}
	}

//	抽象建造者
	public abstract class Builder  {
		public abstract void setPart();
		public abstract Product buildProduct();
	}

//	具体的构建者;如果有多个产品类就有几个具体的建造者；
//	而且这么多产品类，具有相同的接口或抽象类
	public class ConcreteBuilder extends Builder {
		private Product product = new Product();
//		设置产品的零件
		@Override
		public void setPart() {
			/**
			 * 产品类的具体逻辑处理
			 */
		}

//		组建一个产品
		@Override
		public Product buildProduct() {
			return product;
		}
	}

//	导演类：封装作用，避免高层模块深入建造者模式内部的实现类
	public class Director {
		private Builder builder = new ConcreteBuilder();

		//设置不同零件，产生不同的产品
		public Product getProduct_A() {
			builder.setPart();
			return builder.buildProduct();
		}
	}




}
