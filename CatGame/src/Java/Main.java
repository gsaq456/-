package Java;
import java.util.Scanner;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		Random random = new Random();  // happy, full, tired, clean에 랜덤값을 주기위한 메소드
		Condition co = new Condition(); // 먹이 주기 놀아주기 산책하기 목욕하기 콘테스트 상점 가방에 대한 하위 항목들을 불러오기 위한 메소드
		StartEnding se = new StartEnding(); // 게임의 프롤로그와 엔딩을 위한 메소드
		
		boolean a = true; // while 반복을 멈추기 위한 a변수 선언
		int count = 1; // 날짜 변수
        int count_copy = 1; // 1일부터 7일까지 가기 위한 변수
		int[] tr = new int[1]; // 하루가 지나 간 뒤 피로도 배부름 청결도의 값을 랜덤으로 변화시키 위한 배열선언
		
		se.prologue(); // 프롤로그를 출력하기 위한 메소드

		System.out.print("고양이의 이름을 입력하세요 : "); // 고양이 이름을 출력하기 위한 출력문
		String name = scan.next();
		System.out.print("고양이의 성별을 입력하세요 : "); // 고양이 성별을 출력하기 위한 출력문
		String sex = scan.next();
		
		while(a) 
		{
			System.out.println("-------------------------------------------------------------------------");
			System.out.print(name+"("+sex+")" + " |"); 
			System.out.print(" 배부름:  " + co.getFull()+" |"); // condition 클래스에서 full 값을 불러오는 출력문
			System.out.print(" 청결도: " + co.getClean()+" |"); 		
			System.out.print(" 행복도: " + co.getHappy()+" |"); 
			System.out.print(" 피로도: " + co.getTired()+" |"); 
			System.out.println("     Day : "+count); 
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("	                          /\\___/\\");
			System.out.println("	                         /  _　_ |");
			System.out.println("	                                                ㅣ 　　       ㅣ");
			System.out.println("	                                                            ／    `ミ＿xノ");
			System.out.println("	                                                         ／　　 　       ㅣ");
			System.out.println("	                                                      ／　  ヽ　           ﾉ");
			System.out.println("	                                         ㅣ　　   ㅣ  ㅣ ㅣ");
			System.out.println("	                                              ／￣　　     ㅣ  ㅣ ㅣ");
			System.out.println("	                                   ㅣ (￣ヽ___ヽ_つ_つ");
			System.out.println("	                                               ヽ二つ");
			
			
			
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1.먹이주기  | 2.놀아주기  | 3.산책하기  | 4.목욕하기  | 5.콘테스트  | 6.상점  | 7.가방  | 8.잠자기   ");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("선택>");
	         
			int select = scan.nextInt();
	    
			switch(select) 
			{
	            case 1 :
	            	co.Food(); // condition 클래스에서 Food메소드의 값을 불러 오기 위한 메소드 
	            	break;
	            case 2 :
	            	co.play(); 
	            	break;
	            case 3 :
	            	co.walking(); 
	            	break;
	            case 4 :
	                co.shower();  
	                break;
	            case 5 :
	            	co.contest(); 
	            	break;
	            case 6 :
	            	co.shop();  
	            	break;
	            case 7 :
	            	co.bag(); 
	            	break;
	            case 8 :
	            	
	            if(count_copy==7) // 7일차에 출력문 중복 방지를 위한 조건문 선언
	 	        {
	            	count_copy = count_copy-1;
	 	        }
	            	
	            if(count==count_copy) // count가 증가함에 따라 count_copy값도 같이 증가하여 1일 부터 6일차까지 동일한 내용실행
	            {
	            	System.out.println("하루가 지나갑니다. ");
	            	for(int e = 0; e < tr.length; e++) // 랜덤 변수값과 배열 크기 지정을 위한  반복문
	            	{
	            	tr[e] = random.nextInt(35)+25; // 25~35까지 랜덤값을 배열에 저장
	            	System.out.println("피로도가"+ tr[e] + "만큼 내려갑니다."); //피로도가 위에서 구한 랜덤 값 만큼 내려간다는 출력문
	            	co.tired = co.tired - tr[e]; // 기존 피로도에서 위에서 나온 랜덤값을 빼서 저장함
	            	tr[e] = random.nextInt(15)+10; 
	            	System.out.println("배부름이"+ tr[e] + "만큼 내려갑니다."); 
	            	co.full = co.full - tr[e];
	            	tr[e] = random.nextInt(15)+10; 
	            	System.out.println("청결도가"+ tr[e] + "만큼 내려갑니다."); 
	            	co.clean = co.clean - tr[e]; 
	            	scan.nextLine();
	            	System.out.println("-------------------------------------------------------------------------");
	            	}
	            }
	            
	         
	            
	            if(count==7) //7일차가 됬을 때 아래 조건문을 실횅
	            {
            	    if(co.tired>100)
            	    {
            	    	se.endingSad();
            	    	a=false;
	            	}
            	    else if(co.clean<0)
	            	{
            	    	se.endingSad();
            	    	a=false;
		           	}
            	    else if(co.full>100)
	            	{
            	    	se.endingSad();
            	    	a=false;
		            }
            	    else if(co.full<0)
	            	{
            	    	se.endingSad();
            	    	a=false;
		            }
            	    else if(co.happy<0)
	            	{
            	    	se.endingSad();
            	    	a=false;
		            }
            	    else
            	    {
            	    	se.endingHappy();
            	    	a=false;
            	    }
	            }
	            count++; // 하루가 끝났을 떄 count를 증가시킴
	            count_copy++; 
	         } 
	     
	  
	      }
		
	      scan.close();
	}

}
