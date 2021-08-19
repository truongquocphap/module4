
let money = 100;
const buyACar = (car: any) =>{
    // @ts-ignore
    return new Promise(((resolve,reject)=>
    {
        setTimeout(()=>{
            if (money>=1000){
                resolve("can by "+car);
            }else {
                reject("Do not enough money");
            }
        },100)
    }))
}
money =100;
const promise =buyACar("vinFast").then(value =>{
    console.log(value);
}, error =>{
    console.log(error);
})
