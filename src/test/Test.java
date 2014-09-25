package test;

public class Test {
	/*
	 * 	1	2	3
		6	5	4
		7	8	9
	
		打印出
		3 2 4 1 5 9 6 8 7
	
		1	2	3	4
		8	7	6	5
		9	10	11	12
		16	15	14	13
	
		打印出
		4 3 5 2 6 12 1 7 11 13 8 10 14 9 15 16

	 */
	public static void main(String... args) {
		int[][] matrix = getMatrix(4);
		printMatrix(matrix);
		printMatrixAsGluttonousSnake(matrix);
	}

	public static int[][] getMatrix(int level) {
		if (level < 3) {
			System.out.println("WTF");
			throw new IllegalArgumentException("NIMEI");
		}

		int[][] matrix = new int[level][level];
		int count = 1;

		for (int i = 0; i < level; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < level; j++) {
					matrix[i][j] = count;
					count++;
				}
			} else {
				for (int j = level - 1; j > -1; j--) {
					matrix[i][j] = count;
					count++;
				}
			}
		}

		return matrix;
	}

	public static void printMatrix(int[][] matrix) {
		int level = matrix[0].length;
		for (int i = 0; i < level; i++) {
			for (int j = 0; j < level; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println();
		}
	}

	public static void printMatrixAsGluttonousSnake(int[][] matrix) {
		int level = matrix[0].length;
		for (int i = level - 1; i >= 0; i--) {
			for (int j = 0, plus = 0; j < level - i; j++) {
				System.out.print(matrix[j][i - j + plus] + " - ");
				plus += 2;
			}
		}

		for (int i = 1; i <= level - 1; i++) {
			for (int j = 0, plus = 0; j < level - i; j++) {
				System.out.print(matrix[i + plus][j] + " - ");
				plus += 1;
			}
		}
	}

}