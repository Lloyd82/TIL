# JAVA 기초 개념 정리

### 변수

- 덧셈 연산자(+)는 피연산자가 모두 숫자일 때는 두 수를 더하지만, 피연산자 중 어느 한쪽이 String이면 나머지 한 쪽을 먼저 String으로 변환한 다음 두 String을 결합한다.

- **참조변수의 출력이나 덧셈연산자를 이용한 참조변수와 문자열의 결합에는 toString()이 자동적으로 호출되어 참조변수를 문자열로 대치 후 처리**

  

 ### 연산자

+ x << 2 + 1 : 쉬프트연산자(<<)는 덧셈연산자보다 우선순위가 낮다.  => x << (2 + 1)

+ data & 0xFF == 0 : 논리연산자(&)는 비교연산자(==)보다 우선순위가 ↓ ,

  비교연산 후에 논리연산이 수행된다. => data & (0xFF == 0)

+ x < -1 || x > 3 && x < 5 : 논리연산자 중에서 AND를 의미하는 `&&`가 

  OR을 의미하는 `||`보다 우선순위 높음. => **x < -1 || (x > 3 && x < 5)**

  + **`산술 변환`** : 연산 전에 피연산자 타입의 일치를 위해 자동 형변환, 단항연산 포함.					 

  + ‘산술 변환’의 규칙은 다음과 같다.

    1. 두 피연산자의 타입을 같게 일치시킨다. (보다 큰 타입으로 일치)

       - long + int -> long + long -> long

       - float + int -> float + float -> float

         > **자동 형변환처럼 피연산자의 값손실을 최소화하기 위한 것**

    2. 피연산자의 타입이 int보다 작은 타입이면 int로 변환된다.

       - byte + short -> int + int -> int

       - char + short -> int + int -> int

         > **정수형의 기본 타입인 int가 가장 효율적인 타입**

          각 타입변수가  저장할수 있는 값 이상이 되면 오버플로우 발생

         ```												java
         byte b = 10;
         int i = b; // 묵시적 형변환
         ```

         ```java
         int i = 1234
         byte b = (byte)i //명시적 형변환
         ```

         

         

    3. 효율적인 연산

       - OR 연산 ‘||’의 경우, 두 피연산자 중 어느 한 쪽만 ‘참’이어도 전체 연산결과가 ‘참’이므로 좌측 피연산자가 ‘true(참)’이면, 우측 피연산자의 값은 평가 X

       - AND 연산 ‘&&’의 경우, 어느 한쪽만 ‘거짓(0)’이어도 전체 연산결과가 ‘거짓(0)’이므로 좌측 피연산자가 ‘거짓(0)’이면, 우측 피연산자의 값은 평가 X

       - 변수 앞에 키워드 ‘final’을 붙이면 상수가 된다. 상수는 반드시 선언과 동시에 값을 저장해야하며, 한 번 저장된 값은 바꿀 수 없다.조건문 & 반복문

         

### 제어문 [조건(분기)문 & 반복문]

1. #### 조건문 - 비교 & 논리연산자 활용

   +  **IF**문 - if 문은 조건식의 결과가 참(true)이면 주어진 명령문을 실행, 거짓(false)이면  실행X.

     + ``` java
       public static void main(String[] args) { 
           int su = 10; 
           
           System.out.println("정수: " + su); 
           if (su % 2 == 0){ 
             System.out.println("2의 배수"); 
           } 
       
           if (su % 3 == 0){ 
             System.out.println("3의 배수"); 
           } 
            
           if (su % 4 == 0){ 
             System.out.println("4의 배수"); 
           } 
         } 
       ```
       
       +   if 문에서 실행될 명령문이 한 줄 뿐이라면 중괄호({})를 생략 가능

   ​       

   ​	 

   + **IF/ELSE** 문 - if 문과 함께 사용하는 else 문, if 와 반대로 조건식의 결과가 거짓(false)이면  실행

     + ```java
         public static void main(String[] args) { 
           int su = -7; 
            
           System.out.println("정수: " + su); 
           if (su < 0){ 
              
             System.out.println("음수"); 
              
           }else{ 
              
             System.out.println("양수"); 
       ```
       
       + if / else 문에서도 실행될 명령문이 한 줄뿐이라면 중괄호({})를 생략 가능

   ​		

   + **IF / ELSE IF/ ELSE** 문 - 중첩 IF ELSE 문

     + ```java
       public static void main(String[] args) {
           int i = 120;
        
           // 참일 경우만 처리, 거짓은 무시
           if (i % 2 == 0) {                    
             int count = 1;
             System.out.println(i + "은(는) 짝수");
           }
        
           // System.out.println("count: " + count);
           
           // else를 통한 참, 거짓 구분 처리
           if (i % 2 == 0) {
             System.out.println("짝수 " + i); // 참
           } else {
             System.out.println("홀수 " + i); // 거짓
           }
        
           // 조건에 걸릴때까지 계속적인 검사, 다중 IF
           if (i % 3 == 0) {
             System.out.println("3의 배수");
           } else if (i % 4 == 0) {
             System.out.println("4의 배수");
           } else if (i % 7 == 0) {
             System.out.println("7의 배수");
           } else {
        
             System.out.println("3, 4, 7의 배수가 아닙니다.");
           }
           
           if ( 1 == 1) System.out.println("동일");  
           
           if ( 2 == 2)
           System.out.println("동일");              
           if ( 3 == 3){
             
             System.out.println("동일");   
           } 
        }   
       ```
       
       

   + **SWITCH** 문

     + 주어진 조건 값의 결과에 따라 프로그램이 다른 명령을 수행하도록 하는 조건문

     +  if / else 문보다 가독성이 더 좋으며, 컴파일러가 최적화를 쉽게 할 수 있어 속도 또한 빠른 편

     + 하지만 switch 문의 조건 값으로는 int형으로 승격할 수 있는(integer promotion) 값만이 사용

       switch 문은 if / else 문보다는 사용할 수 있는 상황이 적음

     + ```java
           public static void main(String args[]){ 
               int k = 1; 
                
               switch(k){ 
                   case 1: 
                       System.out.println("1 입니다."); 
                       break; 
                   case 2: 
                       System.out.println("2 입니다."); 
                       break; 
                   case 3: 
                       System.out.println("3 입니다."); 
                       break; 
                   case 4: 
                       System.out.println("4 입니다."); 
                       break; 
                   default: 
                       System.out.println("1부터 4까지 입력해야 합니다."); 
                       break; 
               } 
           } 
       ```
       
       + 각 case 절 및 default 절은 반드시 break 키워드를 포함

   + 논리 연산자를 이용한 제어 조건의 이용 

     + ```java
              int a = 10; 
              int b = 5; 
       
              a > b || c < d 
       
       ```

       + `||`= 좌측의 연산식의 결과가 참이면 우측의 연산을  검사하지 않고 참 처리 

     + ```java
              int a = 5; 
              int b = 10; 
       
              a > b && c < d 
       ```

       + `&&`= 좌측의 연산식의 결과가 거짓이면 우측의 연산을 검사하지 않고 거짓 처리 

     + ```java
       public static void main(String args[]){ 
         int k=101; 
       
         //논리 연산자 or의 사용  
         if((k % 3 == 0) || (k % 5 == 0)){ 
         System.out.println("k의 값은:" + k + ": 3의 배수 or 5의 배수"); 
         } else { 
         System.out.println("K의 값은 3의 배수이거나 5의 배수가 아닙니다."); 
         } 
       } 
       ```

       + 입력받은 값이 3의 배수이거나 5의 배수인 수를 판단하는 IF문의 사용

     + ```java
       public static void main(String args[]){ 
         int k=90; 
         //논리 and 연산자  
         if(k % 3 == 0 && k % 5 == 0){ 
            System.out.println("k의 값은:" + k + ": 3의 배수 & 5의 배수."); 
         } else { 
            System.out.println("K의 값은 3의 배수 & 5의 배수 X"); 
         } 
       } 
       ```

       + 입력받은 값이 3의 배수이면서 5의 배수인 수를 판단하는 IF문의 사용

   

   

2. #### 반복문 

   + **while** 문 - 특정 조건`true`를 만족할 때까지 계속해서 명령문을 반복 실행

     + ```java
        public static void main(String args[]){ 
                
               int j = -5; 
       
               //j가 0보다 작을 동안 실행합니다. 
               while(j <= 0){  
                   System.out.println("번호 : " + j);//-5, -4 
                   j++; 
                   if(j==-3) break; 
               } 
       
               System.out.println("--------- END ---------"); 
               System.out.println("While 종료후 j의 값:" + j); 
           } 
       
       ```

       + 문 내부에 조건식의 결과를 변경하는 명령문이 존재하지 않을 때 영원히 반복

   + **DoWhile** 문

     + ```java
       public static void main(String args[]){ 
         int j=1; 
         do{  
            System.out.println("번호 : " + j); //1 
               j++;  //2 
               if(j == 5) break; 
               //j가 0보다 작을 동안 실행     
         }while(j < 0); 
            System.out.println("--------- END ---------"); 
            System.out.println("do-while문 종료후의 j의 값:" + j); 
         } 
       }
       ```

   + **for** 문 

     + 반복 횟수가 지정되어 있는 경우 사용
     +  내부에 초기화 코드를 가짐, 조건식이 참이면 계속 실행
       + ![](java%20%EA%B0%9C%EB%85%90%20%EC%A0%95%EB%A6%AC.assets/java06_05.jpg)

     + ```java
       public class ForSample { 
       	public static void main (String[] args) { 
       		int i, j; 
       		for (j=0,i=1; i <= 10; i++) {  
       			j += i; 
       			System.out.print(i); 
       		if(i==10) { 
       			System.out.print("="); 
       			System.out.print(j); 
       		} else 
       			System.out.print("+"); 
       	} 
       } 
       ```

     

### 배열















 

​	



