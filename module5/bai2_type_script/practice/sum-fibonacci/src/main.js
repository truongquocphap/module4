function fibonacci(num) {
    if (num <= 1) {
        return 1;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
}
var num = 10;
var sum = 0;
var i = 0;
for (i; i < num; i++) {
    sum += fibonacci(i);
    console.log("c\u00E1c s\u1ED1 fibonacci l\u00E0: " + fibonacci(i));
}
console.log(" t\u1ED5ng d\u1EABy s\u1ED1 fibonacci l\u00E0: " + sum);
