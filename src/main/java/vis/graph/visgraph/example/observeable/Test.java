package vis.graph.visgraph.example.observeable;

public class Test {
	public static void main(String[] args) {
		MyBean x = new MyBean();
		Listener l = new MyBeanListener(x.getProperty());

		x.addListener(l);

		x.setTypedA(true);
		x.setTypedA(false);
		x.setTypedA(true);
		x.setTypedA(true);
	}

	private static class MyBeanListener extends Listener {
		public MyBeanListener(String... properties) {
			super(properties);
		}

		@Override
		public <T> void propertyChanged(String p, T oldValue, T newValue) {
			System.out.println(p + " changed: " + oldValue + " to " + newValue);
		}
	}
}
