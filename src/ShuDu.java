
public class ShuDu
{
	static boolean next(int[][] n, int i, int j)
	{
		// 寻锟斤拷锟斤拷锟斤拷锟侥革拷锟斤拷
		while (n[i][j] != 0)
		{
			if (j < 8)
				j++;
			else if (i < 8)
			{
				i++;
				j = 0;
			} else
			{
				// 锟斤拷锟斤拷锟斤拷
				return true;
			}
		}
		// 锟斤拷涑拷锟�
		for (int k = 1; k <= 9; k++)
		{
			n[i][j] = k;
			if (status(n, i, j))
			{
				if (!next(n, i, j))
					continue;
				return true;
			}
		}
		n[i][j] = 0; // 锟斤拷锟斤拷锟斤拷锟姐，锟剿伙拷锟斤拷一锟斤拷
		return false;
	}

	static boolean status(int[][] n, int i, int j)
	{
		int s = n[i][j];
		// 锟叫讹拷同锟斤拷
		for (int k = 0; k < 9; k++)
		{
			if (k == j)
				continue;
			if (n[i][k] == s)
				return false;
		}
		// 锟叫讹拷同锟斤拷
		for (int k = 0; k < 9; k++)
		{
			if (k == i)
				continue;
			if (n[k][j] == s)
				return false;
		}
		// 锟叫讹拷同锟斤拷一锟斤拷锟脚革拷锟斤拷锟斤拷
		int bi = i / 3 * 3;
		int bj = j / 3 * 3;
		for (int ii = bi; ii < bi + 3; ii++)
		{
			for (int jj = bj; jj < bj + 3; jj++)
			{
				if (ii == i && jj == j)
					continue;
				if (n[ii][jj] == n[i][j])
					return false;
			}
		}
		return true;
	}

	static void print(int[][] n)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				System.out.print(n[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int[][] n =
		{	    { 0, 3, 4, 0, 0, 1, 0, 0, 0 },
				{ 8, 6, 2, 4, 7, 0, 0, 1, 5 },
				{ 0, 0, 0, 3, 0, 6, 8, 9, 0 },
				{ 0, 8, 0, 0, 9, 2, 0, 0, 3 },
				{ 0 ,5, 9, 0, 0, 0, 0, 2, 0 },
				{ 0, 0, 1, 5, 4, 0, 6, 7, 0 },
				{ 2, 4, 0, 0, 1, 5, 9, 8, 0 },
				{ 0, 0, 7, 9, 0, 0, 0, 0, 0 },
				{ 6, 0, 0, 0, 3, 7, 0, 5, 0 } };
		print(n);
		next(n, 0, 0);
		print(n);
	}
}
