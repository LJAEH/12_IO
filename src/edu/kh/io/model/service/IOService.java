package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOService {
	
	// IO
	
	// Input (입력) : 외부 => 내부로 데이터를 들여오는 것
	// Output (출력) : 내부 => 외부로 데이터를 내보내는 것
	
	// Stream : 입/출력 통로 역할(데이터가 흘러가는 통로)
	// 			기본적으로 Stream은 단방향
	
	
	// 1) 파일 출력(내부 == 프로그램, 외부 == 파일)
	
	// *** 전체 흐름 *** 시험문제
	
	// 바이트기반 스트림
	public void output1() {
		
		// FileOutputStream fos = new FileOutputStream("test1.txt"); // <= 매개변수로 파일명을 받음
		
		// Unhandled exception type FileNotFoundException
		// 예외 발생 가능성 => 예외처리 try - catch 구문을 써서 처리하자
		// 파일 입출력 시에는
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("test1.txt");
			// 현재 프로그램에서
			// test1.txt 파일로 출력하는 통로 객체 생성
			
			// 이 파일은 목적지가 필요함
			// => 12_IO 지금 해당된 프로젝트 파일이 
			//    기본 목적지로 설정되어있음
			
			// 파일에 "Hello" 내보내기
			
			String str = "Hello";
			
			
			for (int i = 0; i < str.length(); i++) {
				// System.out.println( str.charAt(i));
			
				// "Hello"를 한 문자씩 끊어서 파일로 출력하기
				fos.write(str.charAt(i));
				// write() 는 IOException을 발생시킴
				// Unhandled exception type IOException
			}
		} catch(IOException e) {
			// FileNotFoundException 은 IOException의 자식
			// 다형성 적용 IOException으로 다 잡을 수 있음
			
			System.out.println("예외 발생");
			e.printStackTrace(); // 예외 추적
		} finally {
			// 예외가 발생하더라도 무조건 수행
			
			// 쓸데없는 통로 지우기!
			// => 자원반환
			
			// 사용한 스트림 자원반환(통로 없앰) ==> 필수 작성
			// 프로그램 메모리 관리 차원에서 항상 다쓰면 끊어줌
			// => 작성 안하면 문제점으로 꼽을 수 있음.
			
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// <= 파이널리 자원반환에서 국룰임 .close(); 트라이캐치 처리
		}
	}

	// 2) 파일 입력(외부(파일) => 내부(프로그램))
	
	public void input1() {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("test1.txt");
			
			// FileInputSteam 은 1byte씩만 읽어올 수 있음
			
			while(true) {
				int data = fis.read(); // 다음 1byte를 읽어오는데 정수형임
									   // 다음 내용이 없으면 -1 반환
				if(data == -1) { // 다음 내용 없음 => 종료
					break;
				}
				
				// 반복 종료가 안됐으면 char로 강제 형변환하여 문자로 출력
				System.out.print((char)data);
			}
			
		} catch(IOException e) {
			e.printStackTrace(); // 예외 추적
			
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

//--------------------------------------------------------
	
	// 문자기반 스트림
	public void output2() {
		
		FileWriter fw = null; // 프로그램 => 파일로 쓰는 문자 기분 스틈
		
		try {
			fw = new FileWriter("test1.txt" ,  true ); 
			// 매개변수에 true 같이 전달하면 이어쓰기됨 ㄷㄷ
			
			String str = "안냐세요";
			
			fw.write(str);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void input2() {
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("test1.txt");
			
			while(true) {
				int data = fr.read();
				if( data == -1 ) {
					break;
				}
				
				System.out.println((char)data);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
