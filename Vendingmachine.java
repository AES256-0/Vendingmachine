import java.util.Scanner;
class Vendingmachine
{
	static String[] items={"coke","pepsi","soda"};
	static int[] cents={5,10,20,50};
	static int[] itemsno={5,5,5};
	static int[] item_price={25,35,45};

	//to check whether item is valid or not
	public static boolean checkValidItem(String s){
		for(int i=0;i<items.length;i++)
		{
			if(items[i].equals(s))
				return true;
		}
		return false;
	}
	

	//to return the index of that item
	public static int returnIndex(String s){
		for(int i=0;i<items.length;i++){
			if(items[i].equals(s))
				return i;
		}
		return -1;
	}

	//to check the cents 
	public static boolean checkingCent(int cent){
		for(int i=0;i<cents.length;i++)
		{
			if(cents[i]==cent)
				return true;
		}
		return false;
	}

	//to check whether insert cents are more than the price of item
	public static boolean checkPrice(int cent,String s){
		int i=returnIndex(s);
		if(i!=-1)
		{
			if(item_price[i]<=cent)
				return true;
		}
		return false;
	}

	// to check whether the item is  available or not
	public static boolean checkStock(String s)
	{
		int i=returnIndex(s);
		if(i!=-1)
		{
			if(itemsno[i]>0)
				return true;
		}
		return false;
	}

	//to update item count
	public static void updateItemno(String s){
		int i=returnIndex(s);
		if(i!=-1)
		{	
			itemsno[i]=itemsno[i]-1;
		}
	}

	// main vending maching code
	public static void machineCode(){
		Scanner ob=new Scanner(System.in);
		String s;
		int cent;
		while(true)
		{
			System.out.println("select your product:coke,pepsi or sodA");
			s=ob.next();
			if(!checkValidItem(s))
			{
				System.out.println("choose a valid item");
				continue;
			}
			int sum=0,rem;
			int flag=0;
			System.out.println("only  5,10,20 or 50 cents are allowed");
			while(true)
			{
				System.out.println("\ninsert coin:");
				cent=ob.nextInt();
				sum=sum+cent;
				if(!checkingCent(cent))
				{
					System.out.println("only 5,10,20,50 cents are allowed");
					sum=sum-cent;
					continue;
				}
				if(!checkStock(s))
				{
					System.out.println(s+" stock is empty ,please choose another product or take your money back "+sum);
					break;
				}
				if(!checkPrice(sum,s))
				{
					System.out.println("insert more money: price is"+item_price[returnIndex(s)]);
					System.out.printf("need more :%d",item_price[returnIndex(s)]-sum);
					continue;
				}
				flag=1;
				break;
			}
			if(flag==1)
			{
				System.out.println("your "+s+" is here");
				rem=sum-item_price[returnIndex(s)];
				System.out.println("please collect your remaining amount: "+rem);
				updateItemno(s);
			}
		}
	}
	public static void main(String... s)
	{
		machineCode();
	}
}







		

