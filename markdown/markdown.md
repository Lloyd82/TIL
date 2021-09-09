# 마크다운

+ 개발자 문서 정리의 기본



**제목 설정**

(#) - 문서의 제목을 정리  

(#)갯수로 사이즈 조절 사능





**리스트**

1. `+` +`스페이스바`순서가 없는 리스트  



2. `1`+`.`  순서가 있는 리스트

​         쓰다 쓰지 않으려면  (쉬프트) + (텝)









**코드블럭**



```python
print("hello world")
```

시간에 관한 함구를 쓸 때에는 `import time` 을 사용하면 됩니다. - (`)

(```) - 코드 블럭

- 우클릭 시  변경가능한 목록 생성



**링크**

([ ]) 명령어

+ ex - ([google]+(url))

이미지는 링크와 같지만 (!+[google]+(url))

![google](C:/Users/enjoy/Desktop/cat.jpg)



![The Cat Raised by a Mouse - YouTube](markdown.assets/images.jpeg)



+ 끌어놓기 가능

**폰트 **

```null
__굵게__
**굵게**
_기울여 쓰기_
*기울여 쓰기*
~취소선~
~~취소선~~
```



**체크박스**

`-`, `*`, `+` 뒤에 띄어쓰기 후 __대괄호__를 넣어 작성 

`-` `[` `]` 체크 박스 AND 

- [ ] 체크박스 

  



**테이블** `|`로 구분

A` |` B  로 구분 기본적인 스타일 적용가능 또한 `-(하이픈)`으로 구분된 곳 각각  왼쪽,양쪽,오른쪽에

 `:`콜론을 붙일 경우 순서대로 왼쪽 정렬, 가운데 정렬, 오른쪽 정렬이 가능



## GIT

**분산 버전 관리 시스템**, 형상 관리툴, 버전 관리툴

https://git-scm.com/book/ko/v2 <- 한글 설명 

현장 사용 100% 





**명령어**를 통해서 사용

유닉스 / 리눅스  명령어 **사용불가** - 터미널에서 특정 옵션 `git bash` 선택시 사용가능

**명령어** 

+ `ls` 파일 목록 보기

+ `cd<path>` 위치 이동

+ `cd ..`상위 폴더로 이동

+ dos 와 같이 `tab` 사용가능

* 폴더명 일부 + `tab`

---------------------------------------------------------------

**파일생성**-`mkdir<name>`

`readme.md`는 항상 생성

+ `git init` 명령어로 로컬 저장소 생성 -이 디렉토리 안에 번전관리에 필요한 모든것이 저장 

  + 특정버전으로 남기는게 가능 = `"커밋(commit)한다"` 

  + working directory - 작업하는 실제 디렉토리

    straging - 커밋으로 남기고 싶은, 특정버전으로 관리하고 싶은 파일이 있는곳

  + repository - 커밋들이 저장되는 곳

  + git config --global user.email `you@example.com`- 한번만설정
    git config --global user.name `Your Name`  -한번만 설정

    + 다른 옵션을 주고 싶을땐 `local`



**순서**

`git init`  >  `git add` > `git commit` >...반복

------------------------------------------------------------------------------

+ `mkdir<name>`

+ `touch`파일 생성

+ `rm<name`>파일 삭제

  +   `rm -r <name> `사용시 내부 파일 까지 삭제

+ `git status`깃 상태 확인

+ `git add` staging area 로 커밋생성

+ git add `.` 사용 시 커밋으로 남길수 있는 상태가 됨

+ `git commit` repository 로 커밋 생성

+ `git commit -m "  "` 커밋으로 남길수 있는 메시지 -자세하게...

+ `git log` git의 내용보기

+ `git diff <변경주소>`   변경 내용 보기 - `git status` 에서 확인가능



+ `git remote add origin` {remote_repo1} -  'origin' 

+ `git push -u origin master`  로컬(master)과 온라인(remote_repository -origin)을 연결 (push)

- - u 는 처음 한번만 하고 생략 
  - 

+ `git clone {remote_repo}` remote repo를 local로 복사









