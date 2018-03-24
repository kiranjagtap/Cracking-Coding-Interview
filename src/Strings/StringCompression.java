package Strings;

public class StringCompression {
	public static void main(String[] args) {
		String str = "b";
		System.out.println(compress1(str));

		str = "aa";
		System.out.println(compress1(str));

		str = "aabcccccaaa";
		System.out.println(compress1(str));
		System.out.println("=============");
		str = "b";
		System.out.println(compress2(str));

		str = "aa";
		System.out.println(compress2(str));

		str = "aabcccccaaa";
		System.out.println(compress2(str));
	}

	public static String compress1(String str) {

		int size = str == null ? 0 : str.length();
		if (size == 1) {
			return str;
		}

		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		System.out.println("size--->" + size);
		for (int i = 0; i < size; i++) {
			countConsecutive++;
			System.out.println("i--->" + i);
			/*
			 * If next character is different than current, append this char to
			 * result.
			 */
			if (i + 1 >= size || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}

	public static String compress2(String str) {
		int finalLength = countCompression(str);
		if (finalLength >= str.length())
			return str;

		StringBuffer compressed = new StringBuffer(finalLength); // initialize
																	// capacity
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			/*
			 * If next character is different than current, append this char to
			 * result.
			 */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}

	public static int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			/*
			 * If next character is different than current, append this char to
			 * result.
			 */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive)
						.length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}
}
