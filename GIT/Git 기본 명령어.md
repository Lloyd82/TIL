## GIT

**분산 버전 관리 시스템**, 형상 관리툴, 버전 관리툴

https://git-scm.com/book/ko/v2 <- 한글 설명 

현장 사용 100% 





**명령어**를 통해서 사용

유닉스 / 리눅스  명령어 **사용불가** - 터미널에서 특정 옵션 `git bash` 선택시 사용가능

### 기본**명령어** 

+ `ls` 파일 목록 보기
+ `cd<path>` 위치 이동
+ `cd ..`상위 폴더로 이동, ../..으로 연속 사용
  +  `..` 부모 `.` 현 위치의미 => 상대 경로, 현위치 기준
  + 절대 경로 =>  파일 위치 주소, pc 기준
+ dos 와 같이 `tab` 사용가능

* 폴더명 일부 + `tab`

---------------------------------------------------------------

**파일생성**-`mkdir<name>`

`readme.md`는 항상 생성

+ `git init` 명령어로 로컬 저장소 생성 -이 디렉토리 안에 번전관리에 필요한 모든것이 저장 

  + 특정버전으로 남기는게 가능 = `"커밋(commit)한다"` 

  + working directory - 작업하는 실제 디렉토리

  + straging - 커밋으로 남기고 싶은, 특정버전으로 관리하고 싶은 파일이 있는곳
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
+ `git log` git의 변경 내역 보기
  + git log --graph --oneline 내용 축약
+ `git diff <변경주소>`   변경 내용 보기 - `git status` 에서 확인가능 
  + hash 앞 내자리만 하면 해도 주소 가능

### git remote 명령어

+ `git remote add origin` {remote_repo1} -  'origin' 을 연결
  + git remote rm origin => 리모트 연결 삭제 
  + git remote -v  리모트 연결 확인
+ `git push -u origin master`  로컬(master)과 온라인(remote_repository -origin)을 연결 (push)
  + 온라인에 있는 마스터 브렌치 를 변경
  + 연결 후엔 git push 만으로도 가능
  + u 는 처음 한번만 하고 생략 

+ `git clone {remote_repo}` remote repo를 local로 복사
  + 내려 받기

+ git full 원격 적장소에 있는 변경사항을 로컬로 복사
  + 오리진에 있는 마스터 브렌치를 땡겨옴
  + git pull origin master 
+ git restore -- staged {file} => stage 된것을 다시 올림
  + add 된걸 다시 복구
  + git restore{ file } 최신 상태. 즉 작업 하던것을 날리고 원상복구

+ git reset --hard [위치코드]  코드를 이용해 원하는 지점으로 이동
  + soft ,  mix 도 존재

+ git 은 10기가 미만 사용
+ touch .gitignore 파일 생성후 내용에 파일(폴더) 이름 적으면 무시(제외)
  + 특정파일,  특정 폴더 , *.확장자
  + !profile.png =>모든 png는 빼고, profile.png 넣음 
  + repository 생성시 같이 만드는게 좋음 private 기능

### Branch - 특정커밋을 가르키는 `포인터`

브랜치란 독립적으로 어떤 작업을 진행하기 위한 개념, 필요에 의해 만들어지는 각각의 브랜치는 다른 브랜치의 영향을 받지 않기 때문에, 여러 작업을 동시에 진행할 수 있습니다.

![브랜치 01](Git%20%EA%B8%B0%EB%B3%B8%20%EB%AA%85%EB%A0%B9%EC%96%B4.assets/%EB%B8%8C%EB%9E%9C%EC%B9%98%2001.png)

이렇게 만들어진 브랜치는 다른 브랜치와 병합(Merge)함으로써, 작업한 내용을 다시 새로운 하나의 브랜치로 모을 수 있다.

각자 작업을 진행한 후, 작업이 끝난 사람은 메인 브랜치에 자신의 브랜치의 변경 사항을 적용합니다. 이렇게 함으로써 다른 사람의 작업에 영향을 받지 않고 독립적으로 특정 작업을 수행하고 그 결과를 하나로 모아

브랜치로 그 작업의 기록을 중간 중간에 남기게 되므로 문제가 발생했을 경우 원인이 되는 작업을 찾아내거나 그에 따른 대책을 세우기 쉬워집니다.

![브랜치 02](Git%20%EA%B8%B0%EB%B3%B8%20%EB%AA%85%EB%A0%B9%EC%96%B4.assets/%EB%B8%8C%EB%9E%9C%EC%B9%98%2002-16312514753181.png)

![브랜치 03](Git%20%EA%B8%B0%EB%B3%B8%20%EB%AA%85%EB%A0%B9%EC%96%B4.assets/%EB%B8%8C%EB%9E%9C%EC%B9%98%2003.png)

git branch <branch> 브랜치 생성

+ git branch 만 썻을경우 목록 색인
+ git branch -d <branch>  =>삭제
+ git push origin --delete<branchName>  **Repository** 브랜치  삭제

git checkout <branch> 전환 및 이동

+ git  checkout -b <branch>  
  + '' -b' 옵션을 넣으면 브랜치 작성과 체크아웃을 한번에 실행

git merge <branch> 병합

+ merge commit case =>머지하는 상황에서 발생하는 커밋

  



