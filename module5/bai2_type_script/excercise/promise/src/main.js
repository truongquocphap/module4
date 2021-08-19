var money = 100;
var buyACar = function (car) {
    // @ts-ignore
    return new Promise((function (resolve, reject) {
        setTimeout(function () {
            if (money >= 1000) {
                resolve("can by " + car);
            }
            else {
                reject("Do not enough money");
            }
        }, 100);
    }));
};
money = 100;
var promise = buyACar("vinFast").then(function (value) {
    console.log(value);
}, function (error) {
    console.log(error);
});
