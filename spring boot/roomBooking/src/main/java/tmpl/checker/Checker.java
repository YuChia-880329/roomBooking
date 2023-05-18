package tmpl.checker;

import tmpl.exception.CheckerException;

public interface Checker<I, E extends CheckerException> {

	public void check(I input) throws E;
}
