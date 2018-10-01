package synchronize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppSyn {

	public static void change(int a[]) {
		a[0] = 10;
	}
	public static void main(String[] args) {
		int a[] = {6};
		change(a);
		System.out.println(a[0]);
	}

}
