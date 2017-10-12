package stringbuilder;

//String 不可变字符序列
//StringBuffer 线程安全，效率低
//StringBuilder 线程不安全，效率低

public class Test01 {
	public static void main(String[] args)
	{
		//StringBuilder sb = new StringBuilder();
		//StringBuilder sb1 = new StringBuilder(32);
		StringBuilder sb2 = new StringBuilder("abcd");
		sb2.append("efg");
		sb2.append(true).append(321).append("随便");	//return this-方法链
		System.out.println(sb2);
		
		StringBuilder gh = new StringBuilder('a');
		for(int i=0;i<1000;i++)
		{
			gh.append(i);
		}
		System.out.println(gh);
		
		
	}
}
