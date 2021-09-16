function printHello(){
    console.log('Hello');
}

printHello();

function log(massage){
    console.log(massage);
}

log('Hello @');
log(12345);

// parameters
// premitive parameters : passed by value
// object parameters: passed by reference

function changeName(obj){
    obj.name ='coder';
}
const kim ={name:'kim'};
changeName(kim);
console.log(kim);

//default parameters(added in ES6)
function showMessage(message, from){
    console.log(`${message} by ${from}`);
}
// showMessage('hi');//from undifined

function showMessage2(message, from='unknown'){
    console.log(`${message} by ${from}`);
}

showMessage2('hi');//from undifined
//Rest parameters (added in ES6) : 배열형태로 전달 
function printall(...args){
    for (let i=0; i<args.length; i++){
        console.log(args[i])
    }
    for (const arg of args){
        console.log(arg);
    }
    args.forEach((arg)=> console.log(arg));
}

printall('developer','coder','teams');

// local scope 
let globalMessage ='global';
function printMessage3(){
    let message = 'hello';
    console.log(message);
    console.log(globalMessage);
}
printMessage3();
console.log(globalMessage);
// console.log(Messege); //오류

console.log(sum(3,3)); //호출가능 (hoisted)
function sum(a,b){
    return a+b;
}
//First-class function
//Function expression
//변수 에 함수 할당
//함수표현식에서는
//print(); //오류 무조건 밑으로

const print = function(){
    console.log('print');
}

print();

const printAgain = print;
printAgain();

const sumAgain = sum;
console.log(sumAgain(1,2));

//callback function using function expression
//함수를 파라미터로 전달
//함수 밖에서 선언한 전역변수
function randomQuiz(answer, printYes2, printNo){ 
    if(answer === 'love you'){
        printYes2();
    }else{
        printNo();
    }
}
const printYes = function(){
    console.log('Yes!');
}
function print2(){ //named function - 함수안에서 자신 스스로를 부룰때 쓸수 있다.
    console.log('No!');
}

randomQuiz('wrong', function(){console.log('yes');}, print2);
randomQuiz('love you', printYes, print2);

// const simplePrint =function(){
//     console.log('simplePrint');
// }; 변경한게 밑

const simplePrint = () => console.log('simplePrint');

simplePrint();

const add = (a, b) => a + b;

console.log(add(100,200));
// const simpleMultiply = (a, b) => {return a + b;}
//IIFE: Immediately Invoked Function Expression
function hello(){
    console.log('IIfe');
}

hello();










