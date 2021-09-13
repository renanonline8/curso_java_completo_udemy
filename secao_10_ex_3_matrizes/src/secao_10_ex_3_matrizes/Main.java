package secao_10_ex_3_matrizes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is number of lines? ");
		int numberLines = sc.nextInt();
		
		System.out.print("What is number of columns? ");
		int numberColumns = sc.nextInt();
		
		int[][] mat = new int[numberLines][numberColumns];
		
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.print("What is value to search? ");
		int numberToSearch = sc.nextInt();
		
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				if (mat[i][j] == numberToSearch) {
					System.out.printf("Position %d, %d:%n", i, j);
					
					Integer left = left(mat, i, j);
					if(left != null) {
						System.out.printf("Left: %d%n", left);
					}
					
					Integer right = right(mat, i, j);
					if(right != null) {
						System.out.printf("Right: %d%n", right);
					}
					
					Integer up = up(mat, i, j);
					if(up != null) {
						System.out.printf("Up: %d%n", up);
					}
					
					Integer down = down(mat, i, j);
					if(down != null) {
						System.out.printf("Down: %d%n", down);
					}
				}
			}
		}
		
		sc.close();
	}
	
	private static Integer left(int[][] mat, int line, int column) {
		int pos = column - 1;
		if(pos >= 0 && pos <= mat[line].length - 1) {
			return (Integer) mat[line][pos];
		} else {
			return null;
		}
	}
	
	private static Integer right(int[][] mat, int line, int column) {
		int pos = column + 1;
		if(pos >= 0 && pos <= mat[line].length - 1) {
			return (Integer) mat[line][pos];
		} else {
			return null;
		}
	}
	
	private static Integer up(int[][] mat, int line, int column) {
		int pos = line - 1;
		if(pos >= 0 && pos <= mat.length - 1) {
			return (Integer) mat[pos][column];
		} else {
			return null;
		}
	}
	
	private static Integer down(int[][] mat, int line, int column) {
		int pos = line + 1;
		if(pos >= 0 && pos <= mat.length - 1) {
			return (Integer) mat[pos][column];
		} else {
			return null;
		}
	}
}
