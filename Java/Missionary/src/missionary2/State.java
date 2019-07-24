package missionary2;

public class State {
	int left_can;
	int right_can;
	int left_mis;
	int right_mis;
	boolean boatLeft;
	State parent;
	public State(int lc, int rc, int lm, int rm, boolean lf, State st){
		left_can = lc;
		right_can = rc;
		left_mis = lm;
		right_mis = rm;
		boatLeft = lf;
		parent = st;
		
	}

}
