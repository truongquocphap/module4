
function fibonacci(num: number): number  {

    if (num <=1) {
        return 1;
    }
    return fibonacci(num-1) + fibonacci(num-2);

}
let num: number =10;
let sum: number = 0;
let i: number=0;
for (i;i<num;i++){
    sum+=fibonacci(i);
    console.log(`các số fibonacci là: `+fibonacci(i));
}
console.log(`tổng dẫy số fibonacci là: ` +sum);


