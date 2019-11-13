package convert;

class Node {
	public Node(int a, double b) {
		vt = a;
		gt = b;
	}

	protected int vt;
	protected double gt;
	protected void pr() {
		System.out.println(vt+"  "+gt);
	}
}
