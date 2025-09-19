const num1 = document.getElementById('num1');
const num2 = document.getElementById('num2');
const add = document.getElementById('+');
const sub = document.getElementById('-');
const mul = document.getElementById('*');
const div = document.getElementById('/');
const result = document.getElementById('Result');
const clear =document.getElementById('clear');
const operator = ['+', '-', '*', '/'];
try{
operator.forEach(op => {
    document.getElementById(op).addEventListener('click', function() {
        let n1 = parseInt(num1.value);
        let n2 = parseInt(num2.value);
        let res;
        switch(op) {
            case '+':
                res = n1 + n2;
                console.log(res);
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
            case '/':
                res = n1 / n2;
                break;
        }
        result.value = res;
    });

});
}catch(err){
    console.log(err);
}
clear.addEventListener('click', function() {
    num1.value = '';
    num2.value = '';
    result.value = '';

})
