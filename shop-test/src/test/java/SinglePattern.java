/**
 * Created by weichen on 2018/10/19.
 * 单例模式
 */
public class SinglePattern {


	public class client {
		public void main() {
			Singleton singelton = Singleton.getSingelton();
			singelton.doSomething();
		}
	}

	public static class Singleton {
		private static final Singleton singelton = new Singleton();

//		构造函数私有
		private Singleton() {
		}

		public static Singleton getSingelton() {
			return singelton;
		}

		public static void doSomething(){

		}
	}


}
