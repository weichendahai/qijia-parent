/**
 * Created by weichen on 2018/10/19.
 * 责任链模式
 */
public class LinkParteern {

	public class client {
		public void main () {
			//1. 声明责任链上的节点 实例
			Handler concreteHandler_a = new ConcreteHandler_A();
			Handler concreteHandler_b = new ConcreteHandler_B();
			Handler concreteHandler_c = new ConcreteHandler_C();

			//2. 设置责任链中阶段处理顺序   a --> b --> c
			concreteHandler_a.setNextHandler(concreteHandler_b);
			concreteHandler_b.setNextHandler(concreteHandler_c);

			//3. 提交请求，返回处理结果信息
			Response response = concreteHandler_a.handlerMessage(new Request());
		}
	}

	/**
	 * 抽象处理者
	 */
	public abstract class Handler {

		private Handler nextHandler;

		//每个处理者都必须对请求做出处理
		public final Response handlerMessage (Request request) {
			Response response = null;

			//判断是否是自己处理;如果不属于自己的级别，交个下一个处理者

			if (this.getHandlerLevel().equals(request.getRequestLevel())) {
				response = this.echo(request);
			} else {
				if (this.nextHandler != null) {
					response = this.nextHandler.handlerMessage(request);
				} else {
					System.out.println("没有适当处理者，业务采用默认处理，默认报错");
				}
			}
			return response;
		}

		//设置责任链下一个处理者
		public void setNextHandler(Handler handler) {
			this.nextHandler = handler;
		}

		protected abstract Level getHandlerLevel();
		protected abstract  Response echo (Request request);
	}

	/**
	 * 责任链上，具体操作者A
	 */
	public class ConcreteHandler_A extends Handler {

		//设置自己的处理级别
		@Override
		protected Level getHandlerLevel() {
			return null;
		}

		//定义自己的处理逻辑，然后返回数据
		@Override
		protected Response echo(Request request) {
			return null;
		}
	}

	/**
	 * 责任链上，具体操作者B
	 */
	public class ConcreteHandler_B extends Handler {

		//设置自己的处理级别
		@Override
		protected Level getHandlerLevel() {
			return null;
		}

		//定义自己的处理逻辑，然后返回数据
		@Override
		protected Response echo(Request request) {
			return null;
		}
	}


	/**
	 * 责任链上，具体操作者B
	 */
	public class ConcreteHandler_C extends Handler {

		//设置自己的处理级别
		@Override
		protected Level getHandlerLevel() {
			return null;
		}

		//定义自己的处理逻辑，然后返回数据
		@Override
		protected Response echo(Request request) {
			return null;
		}
	}




	public class Level{
		//定义请求等级
	}

	public class Response {
		//处理返回的数据
	}

	public class Request {
		//获取请求等级
		public Level getRequestLevel() {
			return new Level();
		}
	}

}
