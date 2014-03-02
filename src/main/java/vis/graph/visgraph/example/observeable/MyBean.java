package vis.graph.visgraph.example.observeable;

public class MyBean extends EventBean {
	private final String property = "typedA";
	private boolean typedA;

	public void setTypedA(final boolean newValue) {
		final boolean oldValue = typedA;
		super.firePropertyChanged(property, oldValue, newValue);
		this.typedA = newValue;
	}

	public String getProperty() {
		return property;
	}

	public boolean getTypedA() {
		return this.typedA;
	}
}