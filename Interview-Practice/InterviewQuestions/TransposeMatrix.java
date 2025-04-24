package InterviewQuestions;

public class TransposeMatrix {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };

		transposeMatrix(mat);
	}

	public static void transposeMatrix(int[][] mat) {

		int[][] newMatrix = new int[mat[0].length][mat.length];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				newMatrix[j][i] = mat[i][j];
			}
			System.out.println();
		}
		printMatrix(newMatrix);
	}

	public static void printMatrix(int[][] mat) {

		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[0].length; col++) {
				System.out.print(mat[row][col] + " ");
			}
			System.out.println();
		}
	}
}
