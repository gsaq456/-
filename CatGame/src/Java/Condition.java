package Java;

import java.util.*;		//자바 클래스 모든 패키지 가져오기

public class Condition 
{

	public int happy = 50;		//행복도 : 초기값 50
	public int clean = 50;		//청결도 : 초기값 50
	public int tired = 0;	  	//피로도 : 초기값 0
	public int full = 50;		//배부름 : 초기값 50
	public int money = 50000;	//현재 현금 : 초기값 5만원
	
	   
	Scanner scan = new Scanner(System.in);	//스캔함수 선언
	Random random = new Random();      	//랜덤함수 선언
	   
	boolean run = true;	//와일문을 멈추기위한 변수선언
	
	int[] score = {10, 15, 20, 25};		// 고정된 값을 주기 위한 점수배열 선언
	int[] shoping = {20000, 25000, 30000, 35000};	// 상점의 음식 가격 배열 선언
	int[] pla = new int[1];	//랜덤함수를 사용하기 위한 배열선언
	int[] wal = new int[1];
	
	int foodkit[] = new int [4];		//상점 음식 종류를 담기위한 배열선언
	int showerkit[] = new int [4];	
	int foodcheck[] = {0, 0, 0, 0};		//가방안에 음식갯수를 카운트하기위한  배열 선언
	int showercheck[] = {0, 0, 0, 0};
	
	List<String> list = new ArrayList<String>();	//스트링 타입의 리스트 변수 선언
	int bagcount =1;	// 리스트 중복추가를 방지하기위한 bagcount변수 선언
	
			
	Motion mo = new Motion();	//Motion클래스 객체 선언
	
	public int setPoint(int point)	//최대값 최소값을 비교하기 위한 추상 메소드
	{
		if(point>Limit.MAX_POINT) 	//상수인 150을 point가 초과할경우 150울 point에 저장
		{
		point=Limit.MAX_POINT;
		
		}
		else if(point<Limit.MIN_POINT) //상수인 -50보다 point가 더 작을경우 -50울 point에 저장
		{
		point=Limit.MIN_POINT;
		}

		return point;	
}
	
	public void Food()
	{
		while(run)	//while문에 run=true값을 주어 반복실행
		{
			System.out.println("배부름정도: " + full);	// 현재 상태 출력
			System.out.println("청결도: " + clean);	
		    System.out.println("행복도: " + happy);
	        System.out.println("피로도: " + tired);
	        System.out.println("현재 현금: " + money);
	        System.out.println("-------------------------------------------------------------------------");
	        System.out.println("1. 사료  |  2. 육포  | 3. 생선  | 4. 고오급 로얄 소고기 통조림   |5. 먹이 그만주기 ");
	        System.out.println("-------------------------------------------------------------------------");
	        System.out.print("선택>");
	        int select = scan.nextInt();
	      
	        switch(select) //입력받은 수에따른 case 출력
	        {
	        	case 1:
	        		if(foodcheck[0]>0) {	//"foodcheck[0]=사료"가 0보다 클경우 조건문 실행
	        			mo.motion1();
	            	    System.out.println("사료를 주었습니다 ");
	            		System.out.println("-------------------------------------------------------------------------");
	            		System.out.println("배부름 : " + score[0] + "이 올랐습니다.");	//배부름이 처음 설정한 배열값만큼 오름
	            		full = full + score[0];	//기존 full값에 점수를 더해 중첩
	            		full = setPoint(full);	// 추상 메소드 매개값에 full을 주어서 최대 최소값과 비교한다.
	            		setFull(full);	//set 메소드를 이용하여 full값을 full 필드에 저장
	            		System.out.println("행복도 : " + score[0] + "이 올랐습니다.");
	            		happy = happy + score[0];	
	            		happy = setPoint(happy);
	            		setHappy(happy);
	            		System.out.println("청결도 : " + score[0] + "이 떨어졌습니다.");
	            		clean = clean - score[0] ;
	            		clean = setPoint(clean);
	            		setClean(clean);
	            		System.out.println();
	            		foodcheck[0]--;	//사료를 먹었으니 하나 감소
	            		System.out.println("사료가"+foodcheck[0]+"개 남았습니다.");	//남은 갯수 출력
	            		System.out.println("-------------------------------------------------------------------------");
	            	    }
	            	    else {
	            	    	System.out.println("사료가 하나도 없어요 ㅠㅠ");	// 사료가 없을 경우 출력
	            	    	System.out.println("-------------------------------------------------------------------------");
	            	    }
	            	break; 
	                case 2:
	                if(foodcheck[1]>0) {
	                	System.out.println("육포를 주었습니다 ");
	                	mo.motion2();
	            		System.out.println("-------------------------------------------------------------------------");
	            		System.out.println("배부름 : " + score[1] + "이 올랐습니다.");
	            		full = full + score[1];
	            		full = setPoint(full);
	            		setFull(full);
	            		System.out.println("행복도 : " + score[1] + "이 올랐습니다.");
	            		happy = happy + score[1];
	            		happy = setPoint(happy);
	            		setHappy(happy);
	            		System.out.println("청결도 : " + score[1] + "이 떨어졌습니다.");
	            		clean = clean - score[1] ;
	            		clean = setPoint(clean);
	            		setClean(clean);
	            		System.out.println();
	            		foodcheck[1]--;
	            		System.out.println("육포가"+foodcheck[1]+"개 남았습니다.");
	            		System.out.println("-------------------------------------------------------------------------");
	                	}
	                else {
	            	    	System.out.println("육포가 하나도 없어요 ㅠㅠ");
	            	    	System.out.println("-------------------------------------------------------------------------");
	            	    }
	            	break;
	            case 3:
	            	if(foodcheck[2]>0) {
	            		System.out.println("생선을 주었습니다 ");
	            		mo.motion3();           
	                	System.out.println("-------------------------------------------------------------------------");
	                	System.out.println("배부름 : " + score[2] + "이 올랐습니다.");
	                	full = full + score[2];
	                	full = setPoint(full);
	                	setFull(full);
	                	System.out.println("행복도 : " + score[2] + "이 올랐습니다.");
	                	happy = happy + score[2];
	                	happy = setPoint(happy);
	                	setHappy(happy);
	                	System.out.println("청결도 : " + score[2] + "이 떨어졌습니다.");
	                	clean = clean - score[2] ;
	                	clean = setPoint(clean);
	                	setClean(clean);
	                	System.out.println();
	            		foodcheck[2]--;
	            		System.out.println("생선이"+foodcheck[2]+"개 남았습니다.");
	                	System.out.println("-------------------------------------------------------------------------");
	            	}
	            	else {
            	    	System.out.println("생선이 하나도 없어요 ㅠㅠ");
            	    	System.out.println("-------------------------------------------------------------------------");
            	    }
	                break; 
	            case 4:
	            	if(foodcheck[3]>0) {
	            		System.out.println("고오급 로얄 통조림을 주었습니다 ");
	            		mo.motion4();	               
	                	System.out.println("-------------------------------------------------------------------------");
	                	System.out.println("배부름 : " + score[3] + "이 올랐습니다.");
	                	full = full + score[3];
	                	full = setPoint(full);
	                	setFull(full);
	                	System.out.println("행복도 : " + score[3] + "이 올랐습니다.");
	                	happy = happy + score[3];
	                	happy = setPoint(happy);
	                	setHappy(happy);
	                	System.out.println("청결도 : " + score[3] + "이 떨어졌습니다.");
	                	clean = clean - score[3] ;
	                	clean = setPoint(clean);
	                	setClean(clean);
	                	System.out.println();
	            		foodcheck[3]--;
	            		System.out.println("고오급 로얄 통조림이"+foodcheck[3]+"개 남았습니다.");
	                	System.out.println("-------------------------------------------------------------------------");
	            	}
	            	else {
            	    	System.out.println("고오급 로얄 통조림이 하나도 없어요 ㅠㅠ");
            	    	System.out.println("-------------------------------------------------------------------------");
            	    }
	                break;
	            case 5:              
	            	System.out.println("먹이를 주지 않습니다.");
	            	System.out.println();
	            	return;
	            	
	            default :	//선택지에 있는 수 말고 다른 숫자를 입력하였을떄 출력문을 나오게함
	    			System.out.println(" 선택지에 있는 숫자만 입력해주세요 !! ");
	    			System.out.println();
	    			break;	
	        		}
			}
	}   

	   
	public void play()
	{
		while(run)
		{
			System.out.println("배부름정도: " + full);
	    	System.out.println("청결도: " + clean);	
	    	System.out.println("행복도: " + happy);
	    	System.out.println("피로도: " + tired);
	    	System.out.println("-------------------------------------------------------------------------");
	    	System.out.println("1. 간지럽히기  |  2. 높다! 높다!  | 3. 레슬링  | 4. 노래 불러주기   | 5. 놀이 끝내기 ");
	    	System.out.println("-------------------------------------------------------------------------");
	    	System.out.print("선택>");
	    	int select = scan.nextInt();

	    	switch(select) 
	    	{
	    		case 1 :
	    			System.out.println("간지럽히기를 선택하셨습니다 ");
	    			mo.motion1();
	    			for(int a = 0;a<pla.length;a++)
	    			{
	    				System.out.println("-------------------------------------------------------------------------");
	    				pla[a] = random.nextInt(10)+1;	//1~10까지 랜덤 값을 주어  실행할떄마다 다르게 올라가게함
	    				System.out.println("행복도가"+ pla[a] + "만큼 올랐습니다.");
	    				happy = happy + pla[a];
	    				happy = setPoint(happy);
	    				setHappy(happy);
	    				pla[a] = random.nextInt(10)+1;
	    				System.out.println("피로도가"+ pla[a] + "만큼 올랐습니다.");
	    				tired = tired + pla[a];
	    				tired = setPoint(tired);
	    				setTired(tired);
	    				pla[a] = random.nextInt(10)+1;
	    				System.out.println("청결도가"+ pla[a] + "만큼 내려갔습니다.");
	    				clean = clean - pla[a];
	    				clean = setPoint(clean);
	    				setClean(clean);
	    				pla[a] = random.nextInt(10)+1;
	    				System.out.println("배부름이"+ pla[a] + "만큼 내려갔습니다.");
	    				full = full - pla[a];
	    				full = setPoint(full);
	    				setFull(full);
	    				System.out.println("-------------------------------------------------------------------------");
	    			}
	    			break;
	    		case 2 :
	    			System.out.println("높다! 높다!를 선택하셨습니다 ");
	    			mo.motion2();
	    			for(int b = 0; b<pla.length;b++)
	    			{
	    				System.out.println("-------------------------------------------------------------------------");
	    				pla[b] = random.nextInt(15)+5;
	    				System.out.println("행복도가"+ pla[b] + "만큼 올랐습니다.");
	    				happy = happy + pla[b];
	    				happy = setPoint(happy);
	    				setHappy(happy);
	    				pla[b] = random.nextInt(15)+5;
	    				System.out.println("피로도가"+ pla[b] + "만큼 올랐습니다.");
	    				tired = tired + pla[b];
	    				tired = setPoint(tired);
	    				setTired(tired);
	    				pla[b] = random.nextInt(15)+5;
	    				System.out.println("청결도가"+ pla[b] + "만큼 내려갔습니다.");
	    				clean = clean - pla[b]; 
	    				clean = setPoint(clean);
	    				setClean(clean);
	    				pla[b] = random.nextInt(15)+5;
	    				System.out.println("배부름이"+ pla[b] + "만큼 내려갔습니다.");
	    				full = full - pla[b];
	    				full = setPoint(full);
	    				setClean(full);
	    				System.out.println("-------------------------------------------------------------------------");
	    			}
	    			break;
	    		case 3 :
	    			System.out.println("레슬링을 선택하셨습니다 ");
	    			mo.motion3();
	    			for(int c = 0;c<pla.length;c++)
	    			{
	    				System.out.println("-------------------------------------------------------------------------");
	    				pla[c] = random.nextInt(20)+10;
	    				System.out.println("청결도가"+ pla[c] + "만큼 올랐습니다.");
	    				happy = happy + pla[c];
	    				happy = setPoint(happy);
	    				setHappy(happy);
	    				pla[c] = random.nextInt(20)+10;
	    				System.out.println("피로도가"+ pla[c] + "만큼 올랐습니다.");
	    				tired = tired + pla[c];
	    				tired = setPoint(tired);
	    				setTired(tired);
	    				pla[c] = random.nextInt(20)+10;
	    				System.out.println("청결도가"+ pla[c] + "만큼 내려갔습니다.");
	    				clean = clean - pla[c]; 
	    				clean = setPoint(clean);
	    				setClean(clean);
	    				pla[c] = random.nextInt(20)+10;
	    				System.out.println("배부름이"+ pla[c] + "만큼 내려갔습니다.");
	    				full = full - pla[c];
	    				full = setPoint(full);
	    				setClean(full);	
	    				System.out.println("-------------------------------------------------------------------------");
	            	}
	            	break;
	    		case 4 :
	    			System.out.println("노래 불러주기를 선택하셨습니다 ");
	    			mo.motion4();
	    			for(int d = 0;d<pla.length;d++)
	    			{
	    				System.out.println("-------------------------------------------------------------------------");
	    				pla[d] = random.nextInt(25)+15;
	    				System.out.println("청결도가"+ pla[d] + "만큼 올랐습니다.");
	    				happy = happy + pla[d];
	    				happy = setPoint(happy);
	    				setHappy(happy);
	    				pla[d] = random.nextInt(25)+15;
	    				System.out.println("피로도가"+ pla[d] + "만큼 올랐습니다.");
	    				tired = tired + pla[d];
	    				tired = setPoint(tired);
	    				setTired(tired);
	    				pla[d] = random.nextInt(25)+15;
	    				System.out.println("피로도가"+ pla[d] + "만큼 올랐습니다.");
	    				clean = clean - pla[d]; 
	    				clean = setPoint(clean);
	    				setClean(clean);
	    				pla[d] = random.nextInt(25)+15;
	    				System.out.println("배부름이"+ pla[d] + "만큼 내려갔습니다.");
	    				full = full - pla[d];
	    				full = setPoint(full);
	    				setClean(full);	
	    				System.out.println("-------------------------------------------------------------------------");
	    			}
	    			break;
	    		case 5 :
	    			System.out.println("놀이를 끝마칩니다. ");                
	    			System.out.println();
	    			return;
	    		default :
	    			System.out.println(" 선택지에 있는 숫자만 입력해주세요 !! ");
	    			System.out.println();
	    			break;
	    			}
		}
	         scan.close();
	}
	
	public void walking() 
	{                  
		while(run) 
		{
			System.out.println("배부름정도: " + full);
			System.out.println("청결도: " + clean);	
			System.out.println("행복도: " + happy);
			System.out.println("피로도: " + tired);
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("1. 공원 | 2. 주차장 | 3. 놀이터 | 4. 동네 한바퀴 | 5. 산책 끝내기");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택 > ");
	          
			int walking = scan.nextInt();
	          
			switch(walking) 
			{
				case 1:
					System.out.println("공원을 선택하셨습니다.");
					mo.motion2();                  

					for(int a = 0; a<wal.length; a++) 
					{
						System.out.println("-------------------------------------------------------------------------");
						wal[a] = random.nextInt(10)+1;
						System.out.println("행복도가" + wal[a] + "올랐습니다.");
						happy = happy + wal[a];
						happy = setPoint(happy);
						setHappy(happy);
						wal[a] = random.nextInt(10)+1;
						System.out.println("피로도가" + wal[a] + "올랐습니다.");
						tired = tired + wal[a];
						tired = setPoint(tired);
						setTired(tired);
						wal[a] = random.nextInt(10)+1;
						System.out.println("청결도가" + wal[a] + "떨어졌습니다.");
						clean = clean - wal[a];
						clean = setPoint(clean);
						setClean(clean);
	    				wal[a] = random.nextInt(10)+1;
	    				System.out.println("배부름이"+ wal[a] + "만큼 내려갔습니다.");
	    				full = full - wal[a];
	    				full = setPoint(full);
	    				setClean(full);	
	    				System.out.println("-------------------------------------------------------------------------");
					}
					break;
				case 2:
					System.out.println("주차장을 선택하셨습니다.");
					mo.motion1();                 
	             
	             	for(int b = 0; b<wal.length; b++)
	             	{
	             		System.out.println("-------------------------------------------------------------------------");
	             		wal[b] = random.nextInt(15)+5;
	             		System.out.println("행복도가" + wal[b] + "올랐습니다.");
	             		happy = happy + wal[b];
	             		happy = setPoint(happy);
	             		setHappy(happy);
	             		wal[b] = random.nextInt(15)+5;
	             		System.out.println("피로도가" + wal[b] + "올랐습니다.");
	             		tired = tired + wal[b];
	             		tired = setPoint(tired);
	             		setTired(tired);
	             		wal[b] = random.nextInt(15)+5;
	             		System.out.println("청결도가" + wal[b] + "떨어졌습니다.");
	             		clean = clean - wal[b];
	             		clean = setPoint(clean);
	             		setClean(clean);
	    				wal[b] = random.nextInt(15)+5;
	    				System.out.println("배부름이"+ wal[b] + "만큼 내려갔습니다.");
	    				full = full - wal[b];
	    				full = setPoint(full);
	    				setClean(full);	
	    				System.out.println("-------------------------------------------------------------------------");
	             	}
	             	break;
	          case 3:
	        	  System.out.println("놀이터을 선택하셨습니다.");
	        	  mo.motion3();                 
	        	  for(int c = 0; c<wal.length; c++) 
	        	  {
	        		  System.out.println("-------------------------------------------------------------------------");
	        		  wal[c] = random.nextInt(20)+10;
	        		  System.out.println("행복도가" + wal[c] + "올랐습니다.");
	        		  happy = happy + wal[c];
	        		  happy = setPoint(happy);
	        		  setHappy(happy);
	        		  wal[c] = random.nextInt(20)+10;
	        		  System.out.println("피로도가" + wal[c] + "올랐습니다.");
	        		  tired = tired + wal[c];
	        		  tired = setPoint(tired);
	        		  setTired(tired);
	        		  wal[c] = random.nextInt(20)+10;
	        		  System.out.println("청결도가" + wal[c] + "떨어졌습니다.");
	        		  clean = clean - wal[c];
	        		  clean = setPoint(clean);
	        		  setClean(clean);
	        		  wal[c] = random.nextInt(20)+10;
	        		  System.out.println("배부름이"+ wal[c] + "만큼 내려갔습니다.");
	        		  full = full - wal[c];
	        		  full = setPoint(full);
	        		  setClean(full);
	        		  System.out.println("-------------------------------------------------------------------------");
	             }
	             break;
	          case 4:
	            	 System.out.println("동네 한바퀴를 선택하셨습니다.");
	            	 mo.motion4();  
		             for(int d = 0; d<wal.length; d++) 
		             {
		             System.out.println("-------------------------------------------------------------------------");
		             wal[d] = random.nextInt(25)+15;
	            	 System.out.println("행복도가" + wal[d] + "올랐습니다.");
	            	 happy = happy + wal[d];
	            	 happy = setPoint(happy);
	            	 setHappy(happy);
	            	 wal[d] = random.nextInt(25)+15;
	            	 System.out.println("피로도가" + wal[d] + "올랐습니다.");
	            	 tired = tired + wal[d];
	            	 tired = setPoint(tired);
	            	 setTired(tired);
	            	 wal[d] = random.nextInt(25)+15;
	            	 System.out.println("청결도가" + wal[d] + "떨어졌습니다.");
	            	 clean = clean - wal[d];
	            	 clean = setPoint(clean);
	            	 setClean(clean);
	            	 wal[d] = random.nextInt(25)+15;
	            	 System.out.println("배부름이" + wal[d] + "떨어졌습니다.");
	            	 full = full - wal[d];
	            	 full = setPoint(full);
	            	 setClean(full);
	            	 System.out.println("-------------------------------------------------------------------------");
	            	 
		             }
	             break;
	          case 5:
	             System.out.println("산책을 끝냅니다.");
	             System.out.println();
	             return;   
	          default :
	    		System.out.println(" 선택지에 있는 숫자만 입력해주세요 !! ");
	    		System.out.println();
	    		break;
			}
	          
		}
	          scan.close();
	}
	      
	public void shower() 
	{
		   
		while(run)
		{
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("배부름정도: " + full);
			System.out.println("청결도: " + clean);	
			System.out.println("행복도: " + happy);
			System.out.println("피로도: " + tired);
			System.out.println("현재 현금: " + money);
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("1. 빗질하기  |  2. 물티슈  | 3. 고양이 샴푸  | 4. 펫샵에 맡기기   |5. 목욕 끝내기 ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택>");
			int select = scan.nextInt();
	
	
	
			switch(select) 
			{
			case 1 :
				if(showercheck[0]>0) {
					System.out.println("빗질을 선택하셨습니다 ");
					mo.motion2();                				
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("청결도가"+ score[0] + "만큼 올랐습니다.");
					clean = clean + score[0]; 
					clean = setPoint(clean);
					setClean(clean);
					System.out.println("피로도가"+ score[0] + "만큼 올랐습니다.");
					tired = tired + score[0];
					tired = setPoint(tired);
					setTired(tired);
					System.out.println("행복도가"+ score[0] + "만큼 내려갔습니다.");
					happy = happy - score[0];
					happy = setPoint(happy);
					setHappy(happy);
					System.out.println();
					showercheck[0]--;
					System.out.println("빗이 "+showercheck[0]+"개 남았습니다.");					
					System.out.println("-------------------------------------------------------------------------");
				}
				else {
        	    	System.out.println("빗이 하나도 없어요 ㅠㅠ");
        	    	System.out.println("-------------------------------------------------------------------------");
        	    }
				break;
			case 2 :
				if(showercheck[1]>0) {
					System.out.println("물티슈를 선택하셨습니다 ");
					mo.motion5();                  				
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("청결도가"+ score[1] + "만큼 올랐습니다.");
		            clean = clean + score[1]; 
		            clean = setPoint(clean);
		            setClean(clean);
		            System.out.println("피로도가"+ score[1] + "만큼 올랐습니다.");
		            tired = tired + score[1];
		            tired = setPoint(tired);
		            setTired(tired);
		           	System.out.println("행복도가"+ score[1] + "만큼 내려갔습니다.");
		            happy =  happy - score[1];
		            happy = setPoint(happy);
		            setHappy(happy);
		            System.out.println();
					showercheck[1]--;
					System.out.println("물티슈가 "+showercheck[1]+"개 남았습니다.");		
		            System.out.println("-------------------------------------------------------------------------");
				}
				else {
        	    	System.out.println("물티슈가 하나도 없어요 ㅠㅠ");
        	    	System.out.println("-------------------------------------------------------------------------");
        	    }
				break;
			case 3 :
				if(showercheck[2]>0) {
					System.out.println("고양이샴푸를 선택하셨습니다 ");
					mo.motion5();                 				
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("청결도가"+ score[2] + "만큼 올랐습니다.");
		            clean = clean + score[2]; 
		            clean = setPoint(clean);
		            setClean(clean);
		           	System.out.println("피로도가"+ score[2] + "만큼 올랐습니다.");
		            tired = tired + score[2];
		            tired = setPoint(tired);
		            setTired(tired);
		            System.out.println("행복도가"+ score[2] + "만큼 내려갔습니다.");
		            happy = happy - score[2];
		            happy = setPoint(happy);
		            setHappy(happy);
		            System.out.println();
					showercheck[2]--;
					System.out.println("고양이 샴푸가 "+showercheck[2]+"개 남았습니다.");	
		            System.out.println("-------------------------------------------------------------------------");
				}
				else {
        	    	System.out.println("고양이 샴푸가 하나도 없어요 ㅠㅠ");
        	    	System.out.println("-------------------------------------------------------------------------");
        	    }
				break;
			case 4 :
				if(showercheck[3]>0) {
					System.out.println("펫샵에 맡기기를 선택하셨습니다. ");
					mo.motion4();                					
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("청결도가"+ score[3] + "만큼 올랐습니다.");
		            clean = clean + score[3]; 
		            clean = setPoint(clean);
		            setClean(clean);
		           	System.out.println("피로도가"+ score[3] + "만큼 올랐습니다.");
		            tired = tired + score[3];
		            tired = setPoint(tired);
		            setTired(tired);
		            System.out.println("행복도가"+ score[3] + "만큼 내려갔습니다.");
		            happy = happy - score[3];
		            happy = setPoint(happy);
		            setHappy(happy);
		            System.out.println();
					showercheck[3]--;
					System.out.println("펫샵 이용권이"+showercheck[3]+"개 남았습니다.");	
		            System.out.println("-------------------------------------------------------------------------");
				}
				else {
        	    	System.out.println("펫샵 이용권이  하나도 없어요 ㅠㅠ");
        	    	System.out.println("-------------------------------------------------------------------------");
        	    }
				break;
			case 5 :
				System.out.println("목욕을 끝마칩니다. ");       
				System.out.println();
				return;
			default :
				System.out.println(" 선택지에 있는 숫자만 입력해주세요 !! ");
				System.out.println();
				break;
			}
					
		}
		
	}
	
	
	
	public void contest() 
	{                  
		while(run) 
		{
			System.out.println("배부름정도: " + full);
			System.out.println("청결도: " + clean);	
			System.out.println("행복도: " + happy);
			System.out.println("피로도: " + tired);
			System.out.println("현재 현금: " + money);
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("1. 뽐내기 | 2. 장애물 경주 | 3. 먹을 것 참기 | 4. 재롱 떨기 | 5. 콘테스트 종료");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택 > ");
	          
			int contest = scan.nextInt();
	          
			switch(contest) 
			{
				case 1:
					System.out.println("뽐내기에 참가 하셨습니다.");
					mo.motion2();                  

					
						System.out.println("-------------------------------------------------------------------------");
						if(clean >= 80) {	//청결도가 80이상일 경우 조건문실행
							System.out.println("3만원을 획득 하셨습니다.");
						money = money + 30000;	//3만원획득하고 청결도 감소하여 중복실행 방지
						clean = clean - 30;
						clean = setPoint(clean); 
						setClean(clean);
						}else {
							System.out.println("열심히 뽐내 보았지만 상금 획득에는 실패하셨습니다.");
						}
	    				System.out.println("-------------------------------------------------------------------------");
	    				break;
				case 2:
					System.out.println("장애물 경주에 참가하셨습니다.");
					mo.motion1();                 
	             
	             	
	             		System.out.println("-------------------------------------------------------------------------");
						if(tired <= 20) {
							System.out.println("3만원을 획득 하셨습니다.");
						money = money + 30000;
						tired = tired + 30;
						tired = setPoint(tired);
						setClean(clean);
						}else {
							System.out.println("열심히 장애물을 넘어 보았지만 상금 획득에는 실패하셨습니다.");
						}
	    				System.out.println("-------------------------------------------------------------------------");
	             	
	             	break;
	          case 3:
	        	  System.out.println("먹을 것 참기에 도전하셨습니다.");
	        	  mo.motion3();                 
	        	  
	        		  System.out.println("-------------------------------------------------------------------------");
						if(full >= 80) {
							System.out.println("3만원을 획득 하셨습니다.");
						money = money + 30000;
						full = full - 30;
						full = setPoint(full);
						setClean(full);
						}else {
							System.out.println("참지 못하고 고양이가 먹을 것을 먹었습니다. 상금 획득에는 실패하셨습니다.");
						}
	        		  System.out.println("-------------------------------------------------------------------------");
	          
	             break;
	          case 4:
	            	 System.out.println("재롱떨기에 참가 하셨습니다.");
	            	 mo.motion4();  

		             System.out.println("-------------------------------------------------------------------------");
						if(happy >= 80) {
							System.out.println("3만원을 획득 하셨습니다.");
						money = money + 30000;
						happy = happy - 30;
						happy = setPoint(happy);
						setClean(happy);
						}else {
							System.out.println("고양이가 무시하고 자리에서 이탈 했습니다. 상금 획득에는 실패하셨습니다.");
						}
	            	 System.out.println("-------------------------------------------------------------------------");

	             break;
	          case 5:
	             System.out.println("콘테스트 참가를 종료 하셨습니다.");
	             System.out.println();
	             return;   
	          default :
	        	  System.out.println(" 선택지에 있는 숫자만 입력해주세요 !! ");
	        	  System.out.println();
	        	  break;
			}
	          
		}
	         
	}
	
	public void shop() 
	{                  
		while(run) 
		{
			System.out.println("배부름정도: " + full);
			System.out.println("청결도: " + clean);	
			System.out.println("행복도: " + happy);
			System.out.println("피로도: " + tired);
			System.out.println("현재 현금: " + money);
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("1. 먹을 것 | 2. 샤워 도구 | 3. 상점 나가기 ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택 > ");
	        int shop = scan.nextInt();
	          
			switch(shop) 
			{
				case 1:
					System.out.println("먹을 것을 선택 하셨습니다.");
					mo.motion2();                  
					
					
						System.out.println("-------------------------------------------------------------------------");
						System.out.println("1. 사료 | " + shoping[0] + " 2. 육포 | " + shoping[1] + 
						" 3. 생선 | " + shoping[2] + " 4. 고오급 로얄 통조림 | " + shoping[3] + " 5. 나가기 | ");
						System.out.println("-------------------------------------------------------------------------");
						System.out.print("선택 > ");
						int sj = scan.nextInt();
						System.out.println();
						if(sj==1) 	//상점에서 입력받은 수에따른 조건문 출력
						{
							if(money >= shoping[0])	//현재 돈이 사료값보다 많을 경우 아래 내용 출력
							{
								money = money - shoping[0];  foodcheck[0]++; foodkit[0] = foodcheck[0];
							}	// 현재돈에서 사료값을 빼고, 보유한 사료의 갯수를 증가 시킨다.
							else
							{
								System.out.println("잔액이 부족하여 구매가 불가능 합니다!"); 
							}
						}
						else if(sj==2) 
						{
							if(money >= shoping[1])
							{
								money = money - shoping[1];  foodcheck[1]++; foodkit[1] = foodcheck[1];
							}
							else
							{
								System.out.println("잔액이 부족하여 구매가 불가능 합니다!");
							}
						}
						else if(sj==3) 
						{
							if(money >= shoping[2])
							{
								money = money - shoping[2];  foodcheck[2]++; foodkit[2] = foodcheck[2];
							}
							else
							{
								System.out.println("잔액이 부족하여 구매가 불가능 합니다!");
							}
						}
						else if(sj==4) 
						{
							if(money >= shoping[3])
							{
							money = money - shoping[3];  foodcheck[3]++; foodkit[3] = foodcheck[3];
							}
							else
							{
								System.out.println("잔액이 부족하여 구매가 불가능 합니다.");
							}
						}
						else if(sj==5) {}
						break;
					
				case 2:
						System.out.println("샤워 도구를 선택 하셨습니다.");
						mo.motion2();                  
						System.out.println("-------------------------------------------------------------------------");
						System.out.println("1. 빗질 | " + shoping[0] + " 2. 물티슈 | " + shoping[1] + 
						" 3. 목욕도구 | " + shoping[2] + " 4. 펫샵 이용권 | " + shoping[3] + " 5. 나가기 | ");
						System.out.println("-------------------------------------------------------------------------");
						System.out.print("선택 > ");
						int sj2 = scan.nextInt();
						System.out.println();
						if(sj2==1) 
						{
							if(money >= shoping[0])
							{
								money = money - shoping[0];  showercheck[0]++;  showerkit[0] = showercheck[0];
							}
							else
							{
								System.out.println("잔액이 부족하여 구매가 불가능 합니다!");
							}
						}
						else if(sj2==2) 
						{
							if(money >= shoping[1])
							{
								money = money - shoping[1];  showercheck[1]++;  showerkit[1] = showercheck[1];
							}
							else
							{
								System.out.println("잔액이 부족하여 구매가 불가능 합니다!");
							}
						}
						else if(sj2==3) 
						{
							if(money >= shoping[2])
							{
								money = money - shoping[2];  showercheck[2]++;  showerkit[2] = showercheck[2];
							}
							else
							{
								System.out.println("잔액이 부족하여 구매가 불가능 합니다!");
							}
						}
						else if(sj2==4) 
						{
							if(money >=shoping[3])
							{
								money = money - shoping[3];  showercheck[3]++;  showerkit[3] = showercheck[3];
							}
							else
							{
								System.out.println("잔액이 부족하여 구매가 불가능 합니다!");
							}
						}
						else if(sj2==5) {}
						break;
				
				case 3:
	             System.out.println("상점에서 나갑니다.");
	             return; 
				default :
		        	  System.out.println(" 선택지에 있는 숫자만 입력해주세요 !! ");
		        	  System.out.println();
		        	  break;
			}
	          
		}
		
	          
	}
	
	
	public void bag() {
		if(bagcount==1) {	// bagcount를 1로 선언후 list들을 추가한뒤 증가시켜 메소드가 다시선언될경우 실행안되게 함
			list.add("사료 : ");
			list.add(" | 육포 : ");
			list.add(" | 생선 : "); 
			list.add(" | 고오급 로얄 통조림 : "); 
			list.add("   빗 : ");
			list.add(" | 물티슈 : ");
			list.add(" | 고양이 샴푸 : ");
			list.add(" | 펫샵 이용권 : ");
		bagcount++;
		}	
			
		int size = list.size();	// 리스트내에 크기를 표시
		System.out.println("물건의 종류수 : "+size);
		System.out.println();
		System.out.println("물건의 개수  "); //리스트번호마다 저장되어있는 값을 출력후 갯수를 저장한 변수도 같이 출력
		System.out.print(list.get(0));System.out.print(foodcheck[0]);
		System.out.print(list.get(1));System.out.print(foodcheck[1]);
		System.out.print(list.get(2));System.out.print(foodcheck[2]);
		System.out.print(list.get(3));System.out.println(foodcheck[3]);
		System.out.print(list.get(4));System.out.print(showercheck[0]);
		System.out.print(list.get(5));System.out.print(showercheck[1]);
		System.out.print(list.get(6));System.out.print(showercheck[2]);
		System.out.print(list.get(7));System.out.print(showercheck[3]);
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
		
	}
		
		

	public int getHappy() {
		return happy;
	}
	public void setHappy(int happy) {
		this.happy = happy;
	}
	public int getClean() {
		return clean;
	}
	public void setClean(int clean) {
		this.clean = clean;
	}
	public int getTired() {
		return tired;
	}
	public void setTired(int tired) {
		this.tired = tired;
	}
	public int getFull() {
		return full;
	}
	public void setFull(int full) {
		this.full = full;
	}
}