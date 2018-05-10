package Java;

import java.util.Scanner;

public class StartEnding extends Condition
{
	Scanner scan = new Scanner(System.in);
	Condition co = new Condition();
	
	public void prologue()
	{
		System.out.println("20XX년 세계적으로 길고양이가 폭발적으로 증가하게되어 여러 도시문제가 발생하게 되었다.");
		scan.nextLine();
		System.out.println("정부는 길고양이들을 대규모로 안락사시키기를 주장하였지만");
		scan.nextLine();
		System.out.println("각종 동물단체에서 비인도적인 고양이 처리를 반대하여 이에 새로운 방법을 모색하게 되었다.");
		scan.nextLine();
		System.out.println("유기된 동물들을 돌보는 정부부처를 설립하여 공무원들을 채용하기로 한것이다.");
		scan.nextLine();
		System.out.println("당신은 지금 서류심사와 면접심사를 통과하고 고양이를 일주일간 키워보는 최종심사만을 남겨두고 있다.");
		scan.nextLine();
		System.out.println("부디 열심히 고양이를 키워서 꼭 취업하도록 하자!!");
		scan.nextLine();
		System.out.println("-------------------------------------------------------------------------");
	}
	   
	   public void endingHappy() {
		   System.out.println("-------------------------------------------------------------------------");
		   System.out.print(" 배부름: " + co.getFull()+" |");
		   System.out.print(" 청결도: " + co.getClean()+" |");	
		   System.out.print(" 행복도: " + co.getHappy()+" |");
		   System.out.println(" 피로도: " + co.getTired()+" |");
		   System.out.println("-------------------------------------------------------------------------");
		   System.out.println("	                       /\\___/\\	취업 축하한다냥~");
		   System.out.println("	                      /  ♬　♬ |");
		   System.out.println("	                                                ㅣ 　　       ㅣ");
		   System.out.println("	                                                            ／    `ミ＿xノ");
		   System.out.println("	                                                         ／　　 　       ㅣ");
		   System.out.println("	                                                      ／　  ヽ　           ﾉ");
		   System.out.println("	                                         ㅣ　　   ㅣ  ㅣ ㅣ");
		   System.out.println("	                                              ／￣　　     ㅣ  ㅣ ㅣ");
		   System.out.println("	                                   ㅣ (￣ヽ___ヽ_つ_つ");
		   System.out.println("	                                               ヽ二つ");
		   System.out.println("축하합니다 드디어 직장을 갖게 되었습니다!");
	   }
	   
	   public void endingSad() 
	   {
		   System.out.println("-------------------------------------------------------------------------");
		   System.out.print(" 배부름: " + co.getFull()+" |");
		   System.out.print(" 청결도: " + co.getClean()+" |");	
		   System.out.print(" 행복도: " + co.getHappy()+" |");
		   System.out.println(" 피로도: " + co.getTired()+" |");
		   System.out.println("-------------------------------------------------------------------------");
		   System.out.println("	                       /\\___/\\	이래서 취업은 할 수 있냥?");
		   System.out.println("	                      /  ┬　┬ |");
		   System.out.println("	                                                ㅣ 　　       ㅣ");
		   System.out.println("	                                                            ／    `ミ＿xノ");
		   System.out.println("	                                                         ／　　 　       ㅣ");
		   System.out.println("	                                                      ／　  ヽ　           ﾉ");
		   System.out.println("	                                         ㅣ　　   ㅣ  ㅣ ㅣ");
		   System.out.println("	                                              ／￣　　     ㅣ  ㅣ ㅣ");
		   System.out.println("	                                   ㅣ (￣ヽ___ヽ_つ_つ");
		   System.out.println("	                                               ヽ二つ");
		   System.out.println("취업에 실패했습니다.");
	   }
	   

}
