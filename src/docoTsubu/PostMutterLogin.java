package docoTsubu;

import java.util.List;

public class PostMutterLogin {
	public void execute(Mutter mutter, List<Mutter> mutterList) {
		mutterList.add(0,mutter);
	}
}
