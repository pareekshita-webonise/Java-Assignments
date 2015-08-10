
public class removeDuplicate {
	public int[] removeDup(final int[] arr) {
		int i, j = 0, k, p, count = 0;
		int total = arr.length;
		for (i = 1; i < total; i++) {
			if (arr[j] != arr[i])
				j++;
			else {
				while (i < total && arr[j] == arr[i]) {
					i++;
					count++;
				}
				for (k = j + 1, p = i; p < total; p++, k++)
					arr[k] = arr[p];
				j++;
				i = j;
			}
			total = total - count;
			count = 0;
		}
		final int[] arr1 = new int[total];
		for (i = 0; i < total; i++)
			arr1[i] = arr[i];
		return arr1;
	}

	public static void main(final String[] args) {

	}

}
