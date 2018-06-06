import java.util.Scanner;
class Prime{
public static void main(String[] args){
	 Scanner s= new Scanner(System.in);
int i;
int num=0;
String primeNumbers="";
System.out.println("enter the value of n");
int n=s.nextInt();
s.close();
for(i=1;i<=n;i++){
	int counter=0;
	for(num=i;num>=1;num--){
		if(i%num==0){
			counter=counter+1;
		}
	}
	if(counter==2){
		primeNumbers=primeNumbers+ i +"";
}
}
System.out.println("prime numbers from 1-n");
System.out.println(primeNumbers);
}
}	

