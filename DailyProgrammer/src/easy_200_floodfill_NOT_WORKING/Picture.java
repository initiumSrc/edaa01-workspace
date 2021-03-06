package easy_200_floodfill_NOT_WORKING;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Picture {
	int h, w;
	char[][] picture;
	
	public Picture(String filename) {
		ArrayList<String> lines = readPictureFromFile(filename);
		this.w = lines.get(0).length();
		this.h = lines.size();
		picture = new char[h][w];
		
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < lines.get(i).length(); j++) {
				picture[i][j] = lines.get(i).charAt(j);
			}
		}
	}

	public Picture(int w, int h) {
		this.w = w;
		this.h = h;
		picture = new char[h][w];
		for (int i = 0; i < h; i++)
			for (int j  = 0; j < w; j++)
				picture[i][j] = '.';
	}
	
	public void printPicture() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(picture[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	private ArrayList<String> readPictureFromFile(String filename) {
		ArrayList<String> lines = null;
		
		try {
			Scanner sc = new Scanner(new File(filename));
			lines = new ArrayList<String>();
			while(sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			sc.close();
			return lines;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lines;
	}
	
	char replaceAble;
	public boolean bucketFill(int x, int y, char c) {
		replaceAble = '.';
		if (x < w && x > 0 && y < h && y > 0) {
			while (checkSurroundings(x, y)) {
				picture[x][y] = c;
				printPicture();
				bucketFill(++x, y, c);
				bucketFill(x, ++y, c);
				bucketFill(++x, ++y, c);
				bucketFill(--x, y, c);
				bucketFill(x, --y, c);
				bucketFill(--x, --y, c);
				bucketFill(--x, ++y, c);
				bucketFill(++x, --y, c);
			}
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkSurroundings(int x, int y) {
//		char posChar = picture[y][x];
		
		if (replaceAble == picture[++y][x] ||
				replaceAble == picture[y][++x] ||
				replaceAble == picture[++y][++x] ||
				replaceAble == picture[--y][x] ||
				replaceAble  == picture[y][--x] ||
				replaceAble  == picture[--y][--x] ||
				replaceAble == picture[--y][++x] ||
				replaceAble == picture[++y][--x])
			return true;
		
		return false;
	}
}
